package laicode.class7;

public class RemoveAdjacentRepeatedCharactersI {
	// Method: two pointers
	// slow, the left of slow (inclusive) is what we want to return;
	// fast, the current
	// example: “aaaabbbcc”
	public String deDup(String s) {
		if (s == null) {
			return s;
		}
		char[] cArr = s.toCharArray();
		int slow = 0;
		int fast = 1;
		while (fast < cArr.length) {
			if (cArr[slow] == cArr[fast]) {
				fast++;
			} else {
				slow++;
				cArr[slow] = cArr[fast];
				fast++;
			}
		}
		return new String(cArr, 0, slow + 1);
	}
}
