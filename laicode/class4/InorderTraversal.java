package laicode.class4;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {
	public List<Integer> inOrder(TreeNode head) {
		List<Integer> inorder = new ArrayList<>();
		if (head == null) {
			return inorder;
		}

		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode cur = head;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.offerFirst(cur);
				cur = cur.left;
			} else {
				cur = stack.pollFirst();
				inorder.add(cur.key);
				cur = cur.right;
			}
		}
		return inorder;
	}

}
