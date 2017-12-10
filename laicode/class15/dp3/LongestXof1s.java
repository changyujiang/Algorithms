package laicode.class15.dp3;

/*Largest X Of 1s
 Given a matrix that contains only 1s and 0s, find the largest X 
 shape which contains only 1s, with the same arm lengths and the 
 four arms joining at the central point.

 Return the arm length of the largest X shape.

 Assumptions
 The given matrix is not null, has size of N * M, N >= 0 and M >= 0.
 
 Examples
 { {0, 0, 0, 0},

 {1, 1, 1, 1},

 {0, 1, 1, 1},

 {1, 0, 1, 1} }

 the largest X of 1s has arm length 2.*/
public class LongestXof1s {
	// 0. key point
	// find largest X
	// return the arm length

	// 1. assumption
	// matrix is not null
	// N,M>=0

	// 2. approach
	// step1: dp to pre-process
	// step2: get min of four pre-processed matrix

	// 3. data structure

	// 4. comments

	// 5. big o complexity
	// tiem: O(n^2)
	// space: O(n^2)
	public int largest(int[][] matrix) {
		// assumption & corner case
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int n = matrix.length;
		int m = matrix[0].length;

		// n,m >= 1
		// Step1: pre-process
		// 1. upper-left to lower-right
		// 2. upper-right to lower-left
		int[][] m1 = new int[n][m];
		int[][] m2 = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 1) {
					// initial state processes are covered in the function
					// getNumber
					m1[i][j] = getNumber(m1, i - 1, j - 1) + 1;
					m2[i][j] = getNumber(m2, i - 1, j + 1) + 1;
				} else {
					m1[i][j] = 0;
					m2[i][j] = 0;
				}
			}
		}

		// 3. lower-left to upper-right
		// 4. lower-right to upper-left
		int[][] m3 = new int[n][m];
		int[][] m4 = new int[n][m];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 1) {
					m3[i][j] = getNumber(m3, i + 1, j - 1) + 1;
					m4[i][j] = getNumber(m4, i + 1, j + 1) + 1;
				} else {
					m3[i][j] = 0;
					m4[i][j] = 0;
				}
			}
		}

		// Step2: merge four matrix to one
		int[][] M = new int[n][m];
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int t1 = Math.min(m1[i][j], m2[i][j]);
				int t2 = Math.min(m3[i][j], m4[i][j]);
				M[i][j] = Math.min(t1, t2);
				max = Math.max(max, M[i][j]);
			}
		}
		return max;
	}

	private int getNumber(int[][] matrix, int i, int j) {
		int n = matrix.length;
		int m = matrix[0].length;
		if (i < 0 || j < 0 || i >= n || j >= m) {
			return 0;
		}
		return matrix[i][j];
	}
}
