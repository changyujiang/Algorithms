package laicode.class10;

import java.util.ArrayList;
import java.util.List;

public class SpiralI {
	public List<Integer> spiral(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		int start = 0;
		int end = matrix.length - 1;
		// base case: start = end - 1 || start = end
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

}
