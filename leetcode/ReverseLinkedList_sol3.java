package leetcode;

/*
 * Reverse a singly linked list.
 * Hint:
 * A linked list can be reversed either iteratively or recursively. 
 * Could you implement both?
 */

public class ReverseLinkedList_sol3 {
	private class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
		
		ListNode p = reverseList(head.next);

		head.next.next = head;
		head.next = null;
		
		return p;
	}
}
