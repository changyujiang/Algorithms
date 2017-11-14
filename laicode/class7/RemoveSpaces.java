package laicode.class7;

public class RemoveSpaces {
	// assumption: string is not null
	// method: two pointers
	// slow: the left of slow(including) is what we want to return
	// fast: the current 
	// Example:
	//  0123456789
	//   i   love   MTV
	//  i 
	//    s
	//       j

	public String removeSpace(String s) {
		// corner case
		if (s.length() == 0) {
			return s;
		}

		char[] chArr = s.toCharArray();
		int slow = -1;
		int fast = 0;
		// skip leading spaces
		while (fast < chArr.length && chArr[fast] == ' ') {
			fast++;
		}
		// process main part
		while (fast < chArr.length) {
			if (chArr[fast] != ' ') {
				chArr[++slow] = chArr[fast++];
			} else if (chArr[fast] == ' ' && chArr[fast - 1] != ' ') {
				chArr[++slow] = chArr[fast++];
			} else {
				fast++;
			}
		}
		// process trailing space
		// attention: slow >= 0 indexOutOfBound
		if (slow >= 0 && chArr[slow] == ' ') {
			slow--;
		}
		return new String(chArr, 0, slow + 1);
	}
}
