package laicode.class4;

import java.util.ArrayList;
import java.util.List;

public class NodeInGivenRange {
	public List<Integer> getRange(TreeNode root, int min, int max) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		inorder(root, min, max, res);

		return res;
	}

	private static void inorder(TreeNode root, int min, int max,
			List<Integer> res) {
		if (root == null) {
			return;
		}
		if (root.key > min) {
			inorder(root.left, min, max, res);
		}
		if (root.key >= min && root.key <= max) {
			res.add(root.key);
		}
		if (root.key < max) {
			inorder(root.right, min, max, res);
		}
		return;
	}

}
