package practice.class2;

public class TraceOfMatrix {
	public int traceOfMatrix(int[][] mat) {
		if (mat == null || mat[0] == null || mat.length != mat[0].length) {
			throw new IllegalArgumentException();
		}
		int res = 0;
		for (int i = 1; i < mat.length; i++) {
			res += mat[i][i];
		}
		return res;
	}
}
