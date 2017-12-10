package laicode.class15.dp3;

/*Longest Cross Of 1s
 Given a matrix that contains only 1s and 0s, 
 find the largest cross which contains only 1s, 
 with the same arm lengths and the four arms joining at the central point.

 Return the arm length of the largest cross.

 Assumptions
 The given matrix is not null, has size of N * M, N >= 0 and M >= 0.

 Examples
 { {0, 0, 0, 0},

 {1, 1, 1, 1},

 {0, 1, 1, 1},

 {1, 0, 1, 1} }
 the largest cross of 1s has arm length 2.*/

public class LongestCrossOf1s {
	// 0. key point
	// matrix only contains 0s and 1s
	// largest cross, same arm length,
	// four arms joining at the central point
	// return arm length

	// 1. assumption
	// matrix is not null N*M

	// 2. approach
	// use dp to pre-process on four directions
	// then select a min from four matrixs

	// 3. data structure

	// 4. comments

	// 5. BIG O Comlpexity
	// time： O(n^2)
	// space: O(n^2)
	public int largest(int[][] matrix) {
		// n>=0 m>= 0
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int n = matrix.length;
		int m = matrix[0].length;

		// n>=1 m>=1
		// pre-process
		// 1. m1(left-right)
		int[][] m1 = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// initial state
				if (j == 0) {
					m1[i][j] = matrix[i][j];
				} else if (matrix[i][j] == 1) {
					m1[i][j] = m1[i][j - 1] + 1;
				} else {
					m1[i][j] = 0;
				}
			}
		}

		// 2. m2(right-left)
		int[][] m2 = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = m - 1; j >= 0; j--) {
				// initial state
				if (j == m - 1) {
					m2[i][j] = matrix[i][j];
				} else if (matrix[i][j] == 1) {
					m2[i][j] = m2[i][j + 1] + 1;
				} else {
					m2[i][j] = 0;
				}
			}
		}

		// 3. m3(top-bottom)
		int[][] m3 = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// initial state
				if (i == 0) {
					m3[i][j] = matrix[i][j];
				} else if (matrix[i][j] == 1) {
					m3[i][j] = m3[i - 1][j] + 1;
				} else {
					m3[i][j] = 0;
				}
			}
		}

		// 4. m4(bottom-up)
		int[][] m4 = new int[n][m];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < m; j++) {
				// initial state
				if (i == n - 1) {
					m4[i][j] = matrix[i][j];
				} else if (matrix[i][j] == 1) {
					m4[i][j] = m4[i + 1][j] + 1;
				} else {
					m4[i][j] = 0;
				}
			}
		}

		// step2
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
}
