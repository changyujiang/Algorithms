package laicode.class13dp2;

public class LargestSquareOf1s {
	// 0. key point
	// largest square; return length

	// 1. assumption
	// matrix is not null; N*N N>=0

	// 2. approach
	// DP
	// subproblem: m[i][j] represents the largest square of submartix with
	// [i][j]
	// as its bottom-right corner;
	// - initial state:
	// 	- m[0][j] = input[0][j]
	// 	- m[i][0] = input[i][0]
	// - induction rule:
	// 	- if input[i][j] == 0 m[i][j] = 0;
	// 	- if input[i][j] == 1 m[i][j] = min(m[i-1][j-1] + m[i][j-1] + m[i-1][j])
	// 	+ 1;

	// 3. data structure

	// 4. comment

	// 5. BIG O complexity
	// time: O(n^2)
	// space: O(n^2) optimized O(n)
	public int largest(int[][] matrix) {
		// N >= 0
		int n = matrix.length;

		int[] prev = new int[n];
		int[] cur;
		int max = 0;

		// eg.
		// 0 0 0 0 0 	0 0 0 0 0
		// 1 1 1 1 0 	1 1 1 1 0
		// 1 1 1 1 0 	1 2 2 2 0
		// 1 1 1 0 0 	1 2 3 0 0
		// 1 1 1 0 0 	1 2 3 0 0

		for (int i = 0; i < n; i++) {
			// caution!! create a new array
			cur = new int[n];
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					cur[j] = matrix[i][j];
				} else if (matrix[i][j] == 0) {
					cur[j] = 0;
				} else if (matrix[i][j] == 1) {
					cur[j] = Math.min(prev[j - 1] + 1, prev[j] + 1);
					cur[j] = Math.min(cur[j - 1] + 1, cur[j]);
				}
				max = Math.max(max, cur[j]);
			}
			prev = cur;
		}
		return max;
	}
	
	public static void main(String[] args) {
		LargestSquareOf1s largestSquareOf1s = new LargestSquareOf1s();
		int[][] matrix = new int[][]{{1,1,1,1},{0,0,1,1},{1,0,1,1},{1,1,1,1}};
		int i = largestSquareOf1s.largest(matrix);
		System.out.println(i);
	}
}
