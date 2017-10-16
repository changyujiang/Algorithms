package laicode.class6;

import java.util.*;

public class AllPermutation {
	public List<String> permutations(String set) {
    	List<String> res = new ArrayList<>();
    	if (set == null) {
    		return res;
    	}

    	char[] charSet = set.toCharArray();
    	helper(charSet, 0, res);
    	return res;
	}
	
	private static void helper(char[] charSet, int level, List<String> res) {
		if (level == charSet.length) {
			res.add(new String(charSet));
			return;
		}
		for (int i = level; i < charSet.length; i++) {
			swap(charSet, level, i);
			helper(charSet, level + 1, res);
			swap(charSet, level, i);
		}
		return;
	}
	
	private static void swap(char[] charSet, int i, int j) {
		char temp = charSet[i];
		charSet[i] = charSet[j];
		charSet[j] = temp;
	}
}

