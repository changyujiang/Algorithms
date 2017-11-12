package laicode.class7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
}
