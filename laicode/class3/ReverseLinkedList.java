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
		
		// Recursive Method
	    public ListNode reverseList(ListNode head) {
	        //recursively solved
	        //corner case
	        if (head == null) {
	            return head;
	        } 
	        //base case
	        if (head.next == null) {
	            return head;
	        }
	        //return the head
			ListNode p = reverseList(head.next);

			head.next.next = head;
			head.next = null;
			
			return p;
	    }
	}
}
