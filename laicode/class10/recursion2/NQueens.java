package laicode.class10.recursion2;

import java.util.ArrayList;
import java.util.List;

/*N Queens
Get all valid ways of putting N Queens on an N * N chessboard so that 
no two Queens threaten each other.

Assumptions
N > 0

Return
A list of ways of putting the N Queens
Each way is represented by a list of the Queen's y index for x indices 
of 0 to (N - 1)

Example
N = 4, there are two ways of putting 4 queens:
[1, 3, 0, 2] --> the Queen on the first row is at y index 1, the Queen on the 
second row is at y index 3, the Queen on the third row is at y index 0 and 
the Queen on the fourth row is at y index 2.

[2, 0, 3, 1] --> the Queen on the first row is at y index 2, the Queen on the 
second row is at y index 0, the Queen on the third row is at y index 3 and the 
Queen on the fourth row is at y index 1.*/

public class NQueens {
	// 0. key point
	// put N queens on N*N chessboard
	// return all valid way

	// 1. assumption
	// N > 0

	// 2. approach
	// Recursion DFS to go through all possible ways to put the queens
	// base case: on the last row
	// 					root
	// 				/ | | | | | | \
	// 		(Q0,0th-col) (Q0,1th-col) (Q0,2th-col) (Q0,3th-col) ... (Q0,7th-col)
	// 		  /|||||||\
	// (Q1,0th-col) (Q1,1th-col) (Q1,2th-col) ...........................
	// Overall # of nodes in recursion tree 1 + 8 + 8^2 + ... 8^8 = O(n^n)

	// 3. data structure

	// 4. comments

	// 5. big o complexity
	// time: O(n^n)
	// space: O(n) height of recursion tree
	public List<List<Integer>> nqueens(int n) {
		// n>=1
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();

		int initRow = 0;
		nqueens(n, initRow, res, cur);

		return res;
	}

	private void nqueens(int n, int curRow, List<List<Integer>> res,
			List<Integer> cur) {
		if (curRow == n) {
			res.add(new ArrayList<Integer>(cur));
			return;
		}

		for (int i = 0; i < n; i++) {
			if (validOnCol(i, curRow, cur)) {
				cur.add(i);
				nqueens(n, curRow + 1, res, cur);
				cur.remove(cur.size() - 1);
				// cur.remove(i + 1);
			}
		}
	}

	private boolean validOnCol(int col, int row, List<Integer> cur) {
		if (cur.size() == 0) {
			return true;
		}
		// i row
		// j col
		for (int i = 0; i < cur.size(); i++) {
			int j = cur.get(i);
			int rowOffset = Math.abs(row - i);
			if (col == j || col == j + rowOffset || col == j - rowOffset) {
				return false;
			}
		}
		return true;
	}
}
