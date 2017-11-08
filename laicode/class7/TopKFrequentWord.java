package laicode.class7;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentWord {
	public String[] topK(String[] combo, int k) {
		// corner case
		if (combo.length == 0) {
			return new String[0];
		}
        
		// step1: count the frequency of each word
		Map<String, Integer> freqMap = getFreqMap(combo);
		
		// step2: form a minHeap with size K storing top k frequent words
		Queue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k,
				new MyComparator());
		
		for (Map.Entry<String, Integer> e : freqMap.entrySet()) {
			if (minHeap.size() < k) {
				minHeap.offer(e);
			} else {
				if (e.getValue() > minHeap.peek().getValue()) {
					minHeap.poll();
					minHeap.offer(e);
				}
			}
		}
		
		return freqArray(minHeap);
	}

	private String[] freqArray(Queue<Map.Entry<String, Integer>> minHeap) {
		String[] freqArray = new String[minHeap.size()];
		for (int i = freqArray.length - 1; i >= 0; i--) {
			freqArray[i] = minHeap.poll().getKey();
		}
		return freqArray;
	}

	private static class MyComparator implements
			Comparator<Map.Entry<String, Integer>> {
		@Override
		public int compare(Map.Entry<String, Integer> e1,
				Map.Entry<String, Integer> e2) {
			return e1.getValue().compareTo(e2.getValue());
		}
	}

	private Map<String, Integer> getFreqMap(String[] combo) {
		Map<String, Integer> freqMap = new HashMap<>();
		for (String s : combo) {
			Integer count = freqMap.get(s);
			if (count == null) {
				freqMap.put(s, 1);
			} else {
				freqMap.put(s, ++count);
			}
		}
		return freqMap;
	}
}
