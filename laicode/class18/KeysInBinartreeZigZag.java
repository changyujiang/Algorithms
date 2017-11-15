package laicode.class18;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import laicode.class4.TreeNode;

public class KeysInBinartreeZigZag {
	public List<Integer> zigZag(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offerFirst(root);
		int level = 1;
		while (!deque.isEmpty()) {
			int size = deque.size();
			for (int i = 0; i < size; i++) {
				if (level % 2 == 1) {
					TreeNode cur = deque.pollLast();
					res.add(cur.key);
					if (cur.right != null) {
						deque.offerFirst(cur.right);
					}
					if (cur.left != null) {
						deque.offerFirst(cur.left);
					}
				}
				if (level % 2 == 0) {
					TreeNode cur = deque.pollFirst();
					res.add(cur.key);
					if (cur.left != null) {
						deque.offerLast(cur.left);
					}
					if (cur.right != null) {
						deque.offerLast(cur.right);
					}
				}
			}
			level++;
		}

		return res;
	}
}
