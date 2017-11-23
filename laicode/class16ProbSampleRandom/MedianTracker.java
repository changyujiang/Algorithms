package laicode.class16ProbSampleRandom;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/*Median Tracker
 Given an unlimited flow of numbers, keep track of the median of all 
 elements seen so far.

 You will have to implement the following two methods for the class

 read(int value) - read one value from the flow
 median() - return the median at any time, return null if there is 
 no value read so far

 Examples
 read(1), median is 1
 read(2), median is 1.5
 read(3), median is 2
 read(10), median is 2.5
 ......*/

//0. key point
//unlimited flow; keep track of median

//1. assumptions

//2. approach
//use one max heap for left part, one min heap for right part;
//size(max heap) = size(min heap) or size(maxHeap) = size(minHeap) + 1
//even number: median = maxHeap.max+minHeap.min / 2
//odd number: median = maxHeap.max
//example: 1 2 3 10 4 8
//maxHeap 1 
//minHeap 2 3
//case1:  value <= maxHeap.peek; then maxHeap.offer
//case2:  value > maxHeap.peek; then minHeap.offer

//if sizeMax == sizeMin before, if sizeMin > sizeMax after, extracte min, offer max;
//if sizeMax == sizeMin +1 before, if sizeMax > sizeMin after, extract max, offer min;

//3. data structure
//maxHeap and minHeap to keep track of the maximum number in the smaller part
//and the minimum number in the larger part
//and maintain sizeMaxHeap - sizeMinHeap belongs to [0,1]
//then we can track the median using MaxHeap.max and MinHeap.min

//4. comment

//5. big o complexity
//time: once a new vlaue come, at most two heap operation O(nlogn)
//space: O(n)
public class MedianTracker {
	Queue<Integer> maxHeap;
	Queue<Integer> minHeap;

	public MedianTracker() {
		maxHeap = new PriorityQueue<>(11, Collections.reverseOrder());
		minHeap = new PriorityQueue<>();
	}

	public void read(int value) {
		Integer maxOfSmaller = maxHeap.peek();
		//Integer minOfLarger = minHeap.peek();

		// add value
		if (maxOfSmaller == null || value <= maxOfSmaller) {
			maxHeap.offer(value);
		} else {
			minHeap.offer(value);
		}

		// maintain the relative size
		if (maxHeap.size() - minHeap.size() > 1) {
			int temp = maxHeap.poll();
			minHeap.offer(temp);
		} else if (maxHeap.size() < minHeap.size()) {
			int temp = minHeap.poll();
			maxHeap.offer(temp);
		}
	}

	public Double median() {
		if (maxHeap.size() == 0) {
			return null;
		}

		if (maxHeap.size() == minHeap.size()) {
			return (double) (maxHeap.peek() + minHeap.peek()) / 2;
		} else {
			return (double) maxHeap.peek();
		}
	}
}
