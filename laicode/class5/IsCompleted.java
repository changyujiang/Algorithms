package laicode.class5;

import java.util.LinkedList;
import java.util.Queue;

import laicode.class4.TreeNode;

public class IsCompleted {
	public boolean isCompleted(TreeNode root) {
		if (root == null) {
			return true;
		}

		Queue<TreeNode> myQueue = new LinkedList<>();

		boolean flag = false;
		myQueue.offer(root);
		while (!myQueue.isEmpty()) {
			TreeNode cur = myQueue.poll();
			if (cur.left == null) {
				flag = true;
			} else {
				if (flag) {
					return false;
				} else {
					myQueue.offer(cur.left);
				}
			}
			if (cur.right == null) {
				flag = true;
			} else {
				if (flag) {
					return false;
				} else {
					myQueue.offer(cur.right);
				}
			}
		}
		return true;
	}

}
