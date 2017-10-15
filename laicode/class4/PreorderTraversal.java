package laicode.class4;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal {
	public List<Integer> preOrder(TreeNode root) {
		List<Integer> preOrder = new ArrayList<>();
		if (root == null) {
			return preOrder;
		}

		Deque<TreeNode> stack = new LinkedList<>();
		stack.offerFirst(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pollFirst();
			// the left subtree should be traversed before right subtree
			// since stack is LIFO, WE should push right into stack first
			// so for the next step the top element of the stack is the 
			// left subtree
			
			if (cur.right != null) {
				stack.offerFirst(cur.right);
			}
			if (cur.left != null) {
				stack.offerFirst(cur.left);
			}
			preOrder.add(cur.key);
		}
		return preOrder;
	}
}
