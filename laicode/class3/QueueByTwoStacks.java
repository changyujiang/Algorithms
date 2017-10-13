package laicode.class3;

import java.util.Deque;
import java.util.LinkedList;

public class QueueByTwoStacks {
	// insert into the in stack
	private Deque<Integer> in;
	// remove from the out stack
	private Deque<Integer> out;

	public QueueByTwoStacks() {
		in = new LinkedList<Integer>();
		out = new LinkedList<Integer>();
	}

	public Integer poll() {
		move();
		return out.pollFirst();
	}

	public void offer(int element) {
		in.offerFirst(element);
	}

	public Integer peek() {
		move();
		return out.peekFirst();
	}

	public int size() {
		return in.size() + out.size();
	}

	public boolean isEmpty() {
		return in.size() == 0 && out.size() == 0;
	}
	
	private void move() {
		if (out.isEmpty()) {
			while (!in.isEmpty()) {
				out.offerFirst(in.pollFirst());
			}
		}
	}
}
