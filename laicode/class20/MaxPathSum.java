package laicode.class20;

import laicode.class4.TreeNode;

public class MaxPathSum {
	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int[] max = new int[]{Integer.MIN_VALUE};
		rootToLeafSum(max, root);
		return max[0];
	}

	private int rootToLeafSum(int[] max, TreeNode root) {
		// base case
		if (root == null) {
			return 0;
		}
		int leftSum = rootToLeafSum(max, root.left);
		int rightSum = rootToLeafSum(max, root.right);
		if (root.left != null && root.right != null) {
			max[0] = Math.max(max[0], leftSum + rightSum + root.key);
			return Math.max(leftSum, rightSum) + root.key;
		}
		return root.left == null? rightSum + root.key : leftSum + root.key; 
	}

}
