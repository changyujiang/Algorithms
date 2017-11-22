package laicode.class18plus1.onion;

/*
 * Rotate an N * N matrix clockwise 90 degrees.

Assumptions
The matrix is not null and N >= 0

Examples
{ {1,  2,  3}

  {8,  9,  4},

  {7,  6,  5} }

after rotation is

{ {7,  8,  1}

  {6,  9,  2},

  {5,  4,  3} }*/

public class RotateMatrix {
	  // 0. keypoint
	  // N*N matrix; rotate 90 degree
	  // 1. assumption
	  // matrix is not null; N >= 0
	  // if N = 0; do nothing
	  
	  // 2. approach
	  // do the ratate operation laryer by layer from outer to inner
	  // like peel onion
	  
	  // example
	  // 1 2 3
	  // 8 9 4
	  // 7 6 5
	  
	  // [1][1] -> [1][n-1]; [1][2] -> [2][n-1]
	  
	  // 3. comments
	  
	  // 4. big o complexity
	  // time: O(n^2)
	  // space: O(1)
	  
	  // 5. additional data structure
	  public void rotate(int[][] matrix) {
	    if (matrix.length == 0) {
	      return;
	    }
	    int n = matrix.length;
	    // if n = 0,1 round = 0
	    // if n = 2,3 round = 1
	    // if n = 4,5 round = 2
	    int round = n / 2;
	    for (int i = 0; i < round; i++) {
	      int left = i;
	      int right = n - i - 2;
	      for (int j = left; j <= right; j++) {
	        int temp = matrix[left][j];
	        matrix[left][j] = matrix[n - 1 - j][left];
	        matrix[n - 1 - j][left] = matrix[n - 1 - left][n - 1 - j];
	        matrix[n - 1 - left][n - 1 - j] = matrix[j][n - 1- left];
	        matrix[j][n - 1- left] = temp;
	      }
	    }
	  }
}
