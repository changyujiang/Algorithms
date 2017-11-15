package laicode.class8;

import java.util.ArrayList;
import java.util.List;

public class StringRelpace {
	// input, s, t are not null; s is not empty string
	public String replace(String input, String s, String t) {
		char[] cArray = input.toCharArray();
		if (s.length() >= t.length()) {
			return replaceShorter(cArray, s, t);
		} else {
			return replaceLonger(cArray, s, t);
		}
	}

	// in this case, the length of resulting string is shorter or equal
	// to original string
	// Method: two pointers, slow, fast
	// slow, the left of slow (inclusive) is what we want to return
	// fast, the current
	private String replaceShorter(char[] input, String s, String t) {
		int slow = -1;
		int fast = 0;
		while (fast < input.length) {
			// <= or < !!!!
			if (fast <= input.length - s.length()
					&& equalSubstring(input, fast, s)) {
				slow++;
				copySubstring(input, slow, t);
				slow += t.length() - 1;
				fast += s.length();
			} else {
				input[++slow] = input[fast++];
			}
		}
		return new String(input, 0, slow + 1);
	}

	private boolean equalSubstring(char[] input, int fromIndex, String s) {
		for (int i = 0; i < s.length(); i++) {
			if (input[fromIndex + i] != s.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	private void copySubstring(char[] input, int fromIndex, String t) {
		for (int i = 0; i < t.length(); i++) {
			input[fromIndex + i] = t.charAt(i);
		}
	}

	// example:
	// abcdcd d->gg
	// abcggcgg
	private String replaceLonger(char[] input, String s, String t) {
		List<Integer> matches = getAllMatches(input, s);
		char[] result = new char[input.length + matches.size() * (t.length() - s.length())];
		int lastIndex = matches.size() - 1;
		int fast = input.length - 1;
		int slow = result.length - 1;
		while (fast >= 0) {
			if (lastIndex >= 0 && fast == matches.get(lastIndex)) {
				copySubstring(result, slow - t.length() + 1, t);
				slow -= t.length();
				fast -= s.length();
				lastIndex--;
			} else {
				result[slow--] = input[fast--];
			}
		}
		return new String(result);
	}

	private List<Integer> getAllMatches(char[] input, String s) {
		List<Integer> matches = new ArrayList<>();
		int i = 0;
		// <= or < !!!!
		while (i <= input.length - s.length()) {
			if (equalSubstring(input, i, s)) {
				matches.add(i + s.length() - 1);
				i += s.length();
			} else {
				i++;
			}
		}
		return matches;
	}

}
