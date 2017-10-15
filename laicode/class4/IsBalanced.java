package laicode.class4;
/*
 * TWO VERSION FOR THIS QUESTION
 */
public class IsBalanced {
	
	public boolean isBalanced(TreeNode root) {
		// base case
		if (root == null) {
			return true;
		}
		int depthL = getDepth(root.left);
		int depthR = getDepth(root.right);
		if (Math.abs(depthL - depthR) > 1) {
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
	}

	public int getDepth(TreeNode root) {
		// base case
		if (root == null) {
			return 0;
		}
		return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
	}
	
	public boolean isBalanced2(TreeNode root) {
		// base case
		if (root == null) {
			return true;
		}
		return height(root) != -1;
	}
	
	public int height(TreeNode root) {
		// base case
		if (root == null) {
			return 0;
		}
		int heightL = height(root.left);
		int heightR = height(root.right);
		if (heightL == -1) {
			return -1;
		}
		if (heightR == -1) {
			return -1;
		}
		
		if (Math.abs(heightL - heightR) > 1) {
			return -1;
		}
		
		return Math.max(heightL, heightR) + 1;
	}
}
