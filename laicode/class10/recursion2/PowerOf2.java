package laicode.class10.recursion2;

/*Power Of Two
Determine if a given integer is power of 2.

Examples
16 is power of 2 (2 ^ 4)
3 is not
0 is not
-1 is not
*/

public class PowerOf2 {
	// 0. key point
	// input: integer
	// output: boolean

	// 1. assumption
	//

	// 2. approach
	// recursion
	// base case: num == 0 || num == 1 || num == 2
	// recursion rule:
	// isPowerOfTwo(n) = isPowerOfTwo(n/2)

	// 3. data structure

	// 4. comments

	// 5. big o complexity
	// time: O(lgn)
	// space: O(lgn)

	public boolean isPowerOfTwo(int number) {
		// base case
		if (number == 0) {
			return false;
		}
		if (number == 1 || number == 2) {
			return true;
		}

		if (number % 2 == 1) {
			return false;
		}
		return isPowerOfTwo(number / 2);
	}
}
