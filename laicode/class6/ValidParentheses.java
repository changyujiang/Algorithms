package laicode.class6;

import java.util.*;

public class ValidParentheses {
	public List<String> validParentheses(int n) {
		List<String> res = new ArrayList<>();
		if (n == 0) {
			res.add("");
			return res;
		}

		StringBuilder sb = new StringBuilder();
		helper(n, sb, 0, 0, res);

		return res;
	}

	private static void helper(int n, StringBuilder sb, int l, int r,
			List<String> res) {
		if (l + r == n * 2) {
			res.add(sb.toString());
			return;
		}

		if (l < n) {
			helper(n, sb.append("("), l + 1, r, res);
			sb.deleteCharAt(sb.length() - 1);
		}
		if (r < l) {
			helper(n, sb.append(")"), l, r + 1, res);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
