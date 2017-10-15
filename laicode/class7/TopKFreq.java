package laicode.class7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFreq {
	public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (!map.containsKey(i)){
                map.put(i,1);
            }
            Integer count = map.get(i);
            map.put(i, count + 1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer,Integer>>(){
        	public int compare(Map.Entry<Integer,Integer> e1, Map.Entry<Integer,Integer> e2){
                return e1.getValue().compareTo(e2.getValue());
            }
        });
        
        
        for (Map.Entry<Integer,Integer> e : map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(e);
            } else if (e.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(e);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++){
            res.add(minHeap.poll().getKey());
        }
        return res;
    }
}
