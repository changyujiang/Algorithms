package laicode.class3;


public class ReverseLinkedList {
	public class Solution {
		public ListNode reverse(ListNode head) {
			if (head == null) {
				return head;
			}
			ListNode prev = null;
			ListNode cur = head;
			ListNode next = null; // mark

			while (cur != null) {
				next = cur.next; // mark
				cur.next = prev;
				prev = cur;
				cur = next;
			}

			return prev;
		}
	}

	private class ListNode {
		public int value;
		public ListNode next;

		public ListNode(int value) {
			this.value = value;
			next = null;
		}
	}
}
