package laicode.class4;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class isBST {
	// Make use of the property of BST
	public boolean isBST(TreeNode root) {
		List<Integer> inorder = new ArrayList<>();
		if (root == null) {
			return true;
		}

		TreeNode cur = root;
		Deque<TreeNode> stack = new LinkedList<>();

		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.offerFirst(cur);
				cur = cur.left;
			} else {
				cur = stack.pollFirst();
				inorder.add(cur.key);
				int index = inorder.indexOf(cur.key);
				if (index > 0 && cur.key < inorder.get(index - 1)) {
					return false;
				}
				cur = cur.right;
			}
		}

		return true;
	}

	public boolean isBST2(TreeNode root) {
		if (root == null) {
			return true;
		}

		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean helper(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}

		if (root.key <= min || root.key >= max) {
			return false;
		}

		return helper(root.left, min, root.key)
				&& helper(root.right, root.key, max);
	}

}
