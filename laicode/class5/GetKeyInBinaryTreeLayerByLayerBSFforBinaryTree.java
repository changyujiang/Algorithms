package laicode.class5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import laicode.class4.TreeNode;

public class GetKeyInBinaryTreeLayerByLayerBSFforBinaryTree {
	public List<List<Integer>> layerByLayer(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		Queue<TreeNode> bfs = new LinkedList<>();

		bfs.offer(root);
		while (!bfs.isEmpty()) {
			// size of cur layer
			int size = bfs.size();
			List<Integer> curLayer = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode n = bfs.poll();
				curLayer.add(n.key);
				if (n.left != null) {
					bfs.offer(n.left);
				}
				if (n.right != null) {
					bfs.offer(n.right);
				}
			}
			res.add(curLayer);
		}
		return res;
	}

}
