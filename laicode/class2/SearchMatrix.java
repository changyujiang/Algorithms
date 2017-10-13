package laicode.class2;

public class SearchMatrix {
	public int[] search(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return new int[] { -1, -1 };
		}
		int row = matrix.length;
		int col = matrix[0].length;
		int left = 0;
		int right = row * col - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			int midRow = mid / col;
			int midCol = mid % col;
			if (matrix[midRow][midCol] == target) {
				return new int[] { midRow, midCol };
			} else if (matrix[midRow][midCol] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return new int[] { -1, -1 };
	}
}
