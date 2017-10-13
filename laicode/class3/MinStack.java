package laicode.class3;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
	private Deque<Integer> stack;
	private Deque<Integer> minStack;

	public MinStack() {
		stack = new LinkedList<>();
		minStack = new LinkedList<>();
	}

	public int pop() {
		if (stack.isEmpty()) {
			return -1;
		}
		minStack.pollFirst();
		return stack.pollFirst();
	}

	public void push(int element) {
		stack.offerFirst(element);
		if (minStack.isEmpty()) {
			minStack.offerFirst(element);
			return;
		}
		if (element < minStack.peekFirst()) {
			minStack.offerFirst(element);
		} else {
			minStack.offerFirst(minStack.peekFirst());
		}
		return;
	}

	public int top() {
		if (stack.isEmpty()) {
			return -1;
		}
		return stack.peekFirst();
	}

	public int min() {
		if (stack.isEmpty()) {
			return -1;
		}
		return minStack.peekFirst();
	}
}
