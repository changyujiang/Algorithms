package laicode.class7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * key points： sorted array, duplicate allowed
 * 
 * assumption: not null; length for each array A and B? A << B or A == B
 */
public class CommonNumbersOfTwoSortedArray {
	/**
	 * method1 it seems not work for duplicate allowed situation
	 */
	public List<Integer> commonI(List<Integer> a, List<Integer> b) {
		Set<Integer> setA = new HashSet<>();
		List<Integer> res = new ArrayList<>();
		for (int i : a) {
			setA.add(i);
		}
		for (int i : b) {
			if (setA.contains(i)) {
				res.add(i);
			}
		}
		return res;
	}

	/**
	 * method2 two pointers 谁小移谁
	 */
	// a 1 1 2 3 4
	// b 1 2 2 3 3
	// Time: O(m + n)
	// Space: O(1)
	public List<Integer> commonII(List<Integer> A, List<Integer> B) {
		int a = 0;
		int b = 0;
		List<Integer> res = new ArrayList<>();
		while (a < A.size() && b < B.size()) {
			if (A.get(a) == B.get(b)) {
				res.add(A.get(a));
				a++;
				b++;
			} else if (A.get(a) < B.get(b)) {
				a++;
			} else {
				b++;
			}
		}
		return res;
	}

	/**
	 * method3 hash map store (value, count) pairs
	 */
	// a 1 1 2 3 4
	// b 1 2 2 3 3
	public List<Integer> commonIII(List<Integer> A, List<Integer> B) {
		List<Integer> res = new ArrayList<>();
		Map<Integer,Integer> mapA = new HashMap<>();
		Map<Integer,Integer> mapB = new HashMap<>();
		for (int i : A) {
			Integer countI = mapA.get(i);
			if (countI == null) {
				mapA.put(i, 1);
			} else {
				mapA.put(i, ++countI);
			}
		}
		for (int i : B) {
			Integer countI = mapB.get(i);
			if (countI == null) {
				mapB.put(i, 1);
			} else {
				mapB.put(i, ++countI);
			}
		}
		
		for (Map.Entry<Integer, Integer> e : mapA.entrySet()) {
			Integer countEinB = mapB.get(e.getKey());
			if (countEinB != null) {
				int appear = Math.min(e.getValue(), countEinB);
				for (int i = 0; i < appear; i++) {
					res.add(e.getKey());
				}
			}
		}
		
		return res;
	}
}
