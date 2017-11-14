package laicode.class8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPermutationsII {
	// assumption:
	// method:
	// DFS
	// example:
	// aba

	public List<String> Permutation(String s) {
		// corner case
		if (s == null) {
			return new ArrayList<String>();
		}

		List<String> res = new ArrayList<>();
		char[] cArr = s.toCharArray();
		helper(0, res, cArr);
		return res;
	}

	private void helper(int level, List<String> res, char[] cArr) {
		if (level == cArr.length) {
			res.add(new String(cArr));
			return;
		}
		Set<Character> isSelected = new HashSet<>();
		for (int i = level; i < cArr.length; i++) {
			if (!isSelected.contains(cArr[i])) {
				swap(cArr, level, i);
				helper(level + 1, res, cArr);
				swap(cArr, level, i);
				isSelected.add(cArr[i]);
			}
		}
	}

	private void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		return;
	}

}
