package laicode.class5;

import java.util.*;

public class KSmallestInMatrix {
	public int kthSmallest(int[][] matrix, int k) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0
				|| k == 0) {
			return 0;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;

		PriorityQueue<Cell> pq = new PriorityQueue<>(k, new Comparator<Cell>() {
			@Override
			public int compare(Cell c1, Cell c2) {
				if (c1.value == c2.value) {
					return 0;
				}
				return c1.value < c2.value ? -1 : 1;
			}
		});

		boolean[][] generated = new boolean[rows][cols];

		pq.offer(new Cell(matrix[0][0], 0, 0));
		generated[0][0] = true;
		List<Integer> res = new ArrayList<>();

		while (!pq.isEmpty()) {
			Cell cur = pq.poll();
			res.add(cur.value);
			if (res.size() == k) {
				break;
			}
			int curRow = cur.row;
			int curCol = cur.col;
			if (curCol + 1 < cols && !generated[curRow][curCol + 1]) {
				pq.offer(new Cell(matrix[curRow][curCol + 1], curRow,
						curCol + 1));
				generated[curRow][curCol+1] = true;
			}
			if (curRow + 1 < rows && !generated[curRow + 1][curCol]) {
				pq.offer(new Cell(matrix[curRow + 1][curCol], curRow + 1,
						curCol));
				generated[curRow+1][curCol] = true;
			}
		}
		return res.get(k - 1);
	}

	private class Cell {
		int value;
		int row;
		int col;

		Cell(int value, int row, int col) {
			this.value = value;
			this.row = row;
			this.col = col;
		}
	}

}
