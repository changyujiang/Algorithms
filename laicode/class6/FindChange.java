package laicode.class6;

import java.util.*;

public class FindChange {
	public List<List<Integer>> combinations(int target, int[] coins) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();

		helper(target, coins, 0, cur, res);

		return res;
	}

	private static void helper(int target, int[] coins, int level,
			List<Integer> cur, List<List<Integer>> res) {
		if (level == coins.length - 1) {
			if (target % coins[level] == 0) {
				cur.add(target/coins[level]);
				res.add(new ArrayList<Integer>(cur));
				cur.remove(cur.size() - 1);
			}
			return;
		}
		int max = target / coins[level];
		for (int i = 0; i <= max; i++) {
			cur.add(i);
			helper(target - coins[level] * i, coins, level + 1, cur, res);
			cur.remove(cur.size() - 1);
		}
	}

}
