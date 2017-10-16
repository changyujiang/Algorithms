package laicode.class4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PostorderTraversal {
	public List<Integer> postOrder(TreeNode head) {
		List<Integer> result = new ArrayList<>();
		if (head == null) {
			return result;
		}
		// post-order is the inversed of pre-order with right subtree
		// traversed before left subtree
		// So we can do the special pre-order
		// than reverse the result
		Deque<TreeNode> stack = new LinkedList<>();

		stack.offerFirst(head);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pollFirst();
			if (cur.left != null) {
				stack.offerFirst(cur.left);
			}
			if (cur.right != null) {
				stack.offerFirst(cur.right);
			}
			result.add(cur.key);
		}
		Collections.reverse(result);
		return result;
	}

}
