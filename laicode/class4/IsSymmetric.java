package laicode.class4;

public class IsSymmetric {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return helper(root.left, root.right);
	}

	private static boolean helper(TreeNode left, TreeNode right) {
		// base case
		if (left == null || right == null) {
			return left == null && right == null;
		}
		if (left.key != right.key) {
			return false;
		}
		
		return helper(left.left, right.right) && helper(left.right, right.left);
	}

}
