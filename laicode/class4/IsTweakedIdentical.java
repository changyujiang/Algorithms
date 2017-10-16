package laicode.class4;

public class IsTweakedIdentical {
	public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
		if (one == null || two == null) {
			return one == null && two == null;
		}

		if (one.key != two.key) {
			return false;
		}
		return (isTweakedIdentical(one.left, two.left) && isTweakedIdentical(
				one.right, two.right))
				|| (isTweakedIdentical(one.left, two.right) && isTweakedIdentical(
						one.right, two.left));
	}

}
