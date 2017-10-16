package laicode.class5;

import java.util.PriorityQueue;
import java.util.Comparator;

public class SmallestK {
	public int[] kSmallest(int[] array, int k) {
		if (array == null || array.length == 0 || k == 0) {
			return new int[0];
		}

		PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(k,
				new Comparator<Integer>() {
					@Override
					public int compare(Integer i1, Integer i2) {
						return i2.compareTo(i1);
					}
				});

		for (int i = 0;i < array.length; i++) {
			if (i < k) {
				maxheap.offer(array[i]);
			} else {
				if (maxheap.peek() > array[i]) {
					maxheap.poll();
					maxheap.offer(array[i]);
				}
			}
		}

		int[] res = new int[k];
		for (int i = k - 1; i >= 0; i--) {
			res[i] = maxheap.poll();
		}
		return res;
	}

}
