package laicode.class8;

public class RightShiftByN {
	// assumption:
	// n < s.length()
	// s is not null
	// methods:

	// example:
	// abcd, 2 -> cdab
	// ab|cd -> ba|dc -> cdab
	// abcd, 1 -> dabc
	// abc|d -> cba|d -> dabc
	public String rightShift(String s, int n) {
		if (s.length() == 0 || n == 0) {
			return s;
		}
		char[] cArray = s.toCharArray();
		n = n % s.length();
		reverse(cArray, 0, cArray.length - 1 - n);
		reverse(cArray, cArray.length - n, cArray.length - 1);
		reverse(cArray, 0, cArray.length - 1);
		return new String(cArray);
	}

	private void reverse(char[] cArray, int l, int r) {
		while (l < r) {
			swap(cArray, l, r);
			l++;
			r--;
		}
	}

	private void swap(char[] cArray, int i, int j) {
		char temp = cArray[i];
		cArray[i] = cArray[j];
		cArray[j] = temp;
	}

}
