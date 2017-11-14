package laicode.class7;

public class StrStr {
	// assumption:
	// large and small are not null
	// 
	// example:
	// bcabc
	// ab
	public int strstr(String large, String small) {
		// corner case
		if (small.length() == 0) {
			return 0;
		}
		if (small.length() > large.length()) {
		  return -1;
		}

		int slen = small.length();
		int llen = large.length();
		for (int i = 0; i < llen - slen + 1; i++) {
			int j = 0; // index of small
			while (j < slen) {
				if (large.charAt(i + j) == small.charAt(j)) {
					j++;
				} else {
					break;
				}
			}
			if (j == slen) {
					return i;
			}
		}
		return -1;
	}

}
