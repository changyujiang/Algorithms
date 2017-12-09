package laicode.class15dp3;

/*
 * Largest SubMatrix Sum
	Given a matrix that contains integers, find the submatrix with 
	the largest sum.

	Return the sum of the submatrix.

	Assumptions
	The given matrix is not null and has size of M * N, where M >= 1 and N >= 1
	
	Examples
{ {1, -2, -1, 4},

  {1, -1,  1, 1},

  {0, -1, -1, 1},

  {0,  0,  1, 1} }

the largest submatrix sum is (-1) + 4 + 1 + 1 + (-1) + 1 + 1 + 1 = 7.
*/

public class LargestSubmatrixSum {
	// 0. key point
	// input: matrix contains integers
	// goal: find submatrix with largest sum
	// output: the largest sum

	// 1. assupmtion
	// input is not null
	// N, M >= 1

	// 2. approach
	// columnwise prefix sum + largest sum of subarray

	// 3. data structure

	// 4. comments

	// 5. complexity
	// time O(n^3)
	// space O(n^2)
	public int largest(int[][] matrix) {
		// assumption
		// N, M >= 1
		int n = matrix.length;
		int m = matrix[0].length;

		// step1: column-wise prefix sum to pre-process O(n^2)
		int[][] prefixSum = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0) {
					prefixSum[i][j] = matrix[i][j];
				} else {
					prefixSum[i][j] = prefixSum[i - 1][j] + matrix[i][j];
				}
			}
		}

		// step2: find upper row and lower row and do largest sum subarray
		// sumItoJ = prefixSum[][]
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) { 		// find upper row
			for (int j = i; j < n; j++) { 	// find lower row
				int curSum = 0;
				for (int k = 0; k < m; k++) {
					// column-wise prefixSum
					int colSum = prefixSum[j][k] - prefixSum[i][k]
							+ matrix[i][k];
					if (curSum > 0) {
						curSum = curSum + colSum;
					} else {
						curSum = colSum;
					}
					max = Math.max(max, curSum);
				}
			}
		}
		return max;
	}
}
