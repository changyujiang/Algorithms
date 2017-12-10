package laicode.class10;

import java.util.ArrayList;
import java.util.List;

/*Spiral Order Traverse I
Traverse an N * N 2D array in spiral order clock-wise starting 
from the top left corner. Return the list of traversal sequence.

Assumptions
The 2D array is not null and has size of N * N where N >= 0

Examples
{ {1,  2,  3},

  {4,  5,  6},

  {7,  8,  9} }

the traversal sequence is [1, 2, 3, 6, 9, 8, 7, 4, 5]*/

public class SpiralI {
	// 2. approach
	// 2.2 iterative
	public List<Integer> spiralI(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		int start = 0;
		int end = matrix.length - 1;
		// termination condition: start = end - 1 || start = end
		while (start < end) {
			for (int i = start; i < end; i++) {
				res.add(matrix[start][i]);
			}
			for (int i = start; i < end; i++) {
				res.add(matrix[i][end]);
			}
			for (int i = end; i > start; i--) {
				res.add(matrix[end][i]);
			}
			for (int i = end; i > start; i--) {
				res.add(matrix[i][start]);
			}
			start++;
			end--;
		}
		if (start == end) {
			res.add(matrix[start][start]);
		}
		return res;
	}

	// 0. KEY POINT
	// N*N matrix
	// traverse in spiral order clock-wise
	// return list of sequence

	// 1. assumption
	// array is not null
	// N >= 0

	// 2. approach
	// 2.1 recursion
	//
	// 2.2 iterative

	// 3. data sturcutre

	// 4. comments

	// 5. BIG O complexity
	// time: O(n^2)
	// space: O(n)
	public List<Integer> spiral(int[][] matrix) {
		// assumption / corner case
		List<Integer> res = new ArrayList<>();
		if (matrix.length == 0) {
			return res;
		}

		// n >= 1
		int size = matrix.length;
		int offset = 0;
		spiral(matrix, res, offset, size);
		return res;
	}

	// example:
	// 0 1 2

	// 1, 2, 3
	// 4, 5, 6
	// 7, 8, 9
	// size = 3
	// size-1 = 2

	// size >= 1
	private void spiral(int[][] matrix, List<Integer> res, int offset, int size) {
		// base case
		if (size == 0) {
			return;
		}
		if (size == 1) {
			res.add(matrix[offset][offset]);
			return;
		}
		// i < 2,
		// up row
		for (int i = 0; i < size - 1; i++) {
			res.add(matrix[offset][i + offset]);
		}
		// right col
		for (int i = 0; i < size - 1; i++) {
			res.add(matrix[i + offset][size - 1 + offset]);
		}
		// bottom row
		for (int i = 0; i < size - 1; i++) {
			res.add(matrix[size - 1 + offset][size - 1 + offset - i]);
		}
		// left col
		for (int i = 0; i < size - 1; i++) {
			res.add(matrix[size - 1 + offset - i][offset]);
		}

		spiral(matrix, res, offset + 1, size - 2);
	}
}
