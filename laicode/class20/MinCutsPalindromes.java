package laicode.class20;

public class MinCutsPalindromes {
	public int minCuts(String input) {
		if (input.length() == 0) {
			return 0;
		}
		char[] c = input.toCharArray();
		int len = c.length;
		// if substring (i, j) is palindrome
		boolean[][] isP = new boolean[len][len];
		// minCuts for substring with len = i;
		int[] res = new int[len];

		for (int i = 0; i < len; i++) {
			// at most need i times cut
			int min = i;
			for (int j = 0; j <= i; j++) {
				if(c[j] == c[i] && (j + 1 > i - 1 || isP[j+1][i-1])) {
					isP[j][i] = true;
					min = j == 0 ? 0 : Math.min(min, res[j-1] + 1);
				}
			}
			res[i] = min;
		}
		return res[len - 1];
	}

}
