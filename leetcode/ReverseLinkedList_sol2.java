package leetcode;

/*
 * Reverse a singly linked list.
 * Hint:
 * A linked list can be reversed either iteratively or recursively. 
 * Could you implement both?
 */

public class ReverseLinkedList_sol2 {
	private class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	
	public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)	return head;
        
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null){
        	ListNode tempnext = curr.next;
        	curr.next = prev;
        	prev = curr;
        	curr = tempnext;
        }
        
        return prev;
    }
}

