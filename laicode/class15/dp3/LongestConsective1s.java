package laicode.class15.dp3;

public class LongestConsective1s {
	// 0. key point

	// 1. assumption
	// the given array is not null
	// only 0 and 1

	// 2. approach
	// dp l[i] is the longest consecutive 1s length for array [0..i]
	// initial state l[0] = 0;
	// l[i] = 0 if i == 0;
	// l[i] = l[i-1] + 1 if i == 1;

	// 3. data structure

	// 4. comment

	// 5. big o complexity
	// time: O(n)
	// space: O(1)
	public int longest(int[] array) {
		// array is not null
		int res = 0;
		int max = res;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				res = 0;
			} else {
				res = res + 1;
			}
			max = Math.max(res, max);
		}
		return max;
	}
}
