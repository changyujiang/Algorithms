package laicode.class10;

import java.util.ArrayList;
import java.util.List;

public class SpiralII {
	public List<Integer> spiral(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix.length == 0) {
			return res;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int rStart = 0;
		int cStart = 0;
		int rEnd = m - 1;
		int cEnd = n - 1;
		while (rStart < rEnd && cStart < cEnd) {
			for (int i = cStart; i < cEnd; i++) {
				res.add(matrix[rStart][i]);
			}
			for (int i = rStart; i < rEnd; i++) {
				res.add(matrix[i][cEnd]);
			}
			for (int i = cEnd; i > cStart; i--) {
				res.add(matrix[rEnd][i]);
			}
			for (int i = rEnd; i > rStart; i--) {
				res.add(matrix[i][cStart]);
			}
			rStart++;
			rEnd--;
			cStart++;
			cEnd--;
		}
		// base case
		if (rStart == rEnd && cStart == cEnd) {
			res.add(matrix[rEnd][cEnd]);
		} else if (rStart == rEnd) {
			for (int i = cStart; i <= cEnd; i++) {
				res.add(matrix[rEnd][i]);
			}
		} else if (cStart == cEnd) {
			for (int i = rStart; i <= rEnd; i++) {
				res.add(matrix[i][cEnd]);
			}
		}
		return res;
	}
}
