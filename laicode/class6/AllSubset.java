package laicode.class6;

import java.util.*;

public class AllSubset {
	public List<String> subSets(String set) {
		List<String> res = new ArrayList<>();
	if (set == null) {
		return res;
	}
	if (set.length() == 0) {
		res.add("");
		return res;
	}
	char[] charSet = set.toCharArray();
	StringBuilder sb = new StringBuilder();
	helper(charSet, sb, 0, res);

	    	return res;
	  }

		private static void helper(char[] charSet, StringBuilder sb, int level, List<String> res) {
			if (level == charSet.length) {
		res.add(sb.toString());
	}
	helper(charSet, sb, level + 1, res);
	helper(charSet, sb.append(charSet[level]), level + 1, res);
	sb.deleteCharAt(sb.length() - 1);
	}

}
