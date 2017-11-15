package laicode.class10;

import laicode.class3.ListNode;

public class ReverseInPairs {
	public ListNode reverseInPairs(ListNode head) {
		// corner case
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pastNext = head.next;
		head.next = reverseInPairs(head.next.next);
		pastNext.next = head;
		return pastNext;
	}

}
