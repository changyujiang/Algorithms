package leetcode;

/*
 * Reverse a singly linked list.
 * Hint:
 * A linked list can be reversed either iteratively or recursively. 
 * Could you implement both?
 */

public class ReverseLinkedList_sol1 {
	private class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	
	public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;}
        else if (head.next.next == null){
            ListNode first = head;
            ListNode second = head.next;
            first.next = null;
            second.next = first;
            return second;
        }
        
        ListNode first = head;
        ListNode second = head.next;
        ListNode third = second.next;
        first.next = null;
        
        while (third != null){
            second.next = first;
            first = second;
            second = third;
            third = third.next;
        }
        
        second.next = first;
        
        return second;
    }
}

