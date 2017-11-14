package laicode.class7;

public class RemoveAdjacentRepeatedCharactersIV {
	// "abbbaaccz" → "aaaccz" → "ccz" → "z"
	// s
	//  f
	// assumption: 
	// if s is null or s.length == 0, we do nothing
	// method: 
	// we can use a stack to simulate the process of repeatedlly
	// removing adjacent elments
	// implicit stack with two pointers
	// 1. slow, the left of slow(inclusive) are what we are going to return
	// 2. fast, the current
	public String deDup(String s) {
		// corner case
		if (s == null || s.length() == 0) {
			return s;
		}

		char[] sArr = s.toCharArray();
		// init
		int slow = -1;
		int fast = 0;
		while (fast < sArr.length) {
			if (slow == -1 || sArr[slow] != sArr[fast]) {
				slow++;
				sArr[slow] = sArr[fast];
				fast++;
			} else {
				while (fast < sArr.length && sArr[slow] == sArr[fast]) {
					fast++;
				}
				slow--;
			}
		}
		return new String(sArr, 0, slow + 1);
	}
}
