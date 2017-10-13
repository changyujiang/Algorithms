package laicode.class3;

public class ParitionList {
	public ListNode partition(ListNode head, int target) {
		ListNode dummySmallHead = new ListNode(0);
		ListNode dummyLargeHead = new ListNode(0);
		ListNode smallTail = dummySmallHead;
		ListNode largeTail = dummyLargeHead;
		ListNode cur = head;
		while (cur != null) {
			if (cur.value < target) {
				smallTail.next = cur;
				smallTail = smallTail.next;
			} else {
				largeTail.next = cur;
				largeTail = largeTail.next;
			}
			cur = cur.next;
		}
		smallTail.next = dummyLargeHead.next;
		largeTail.next = null;

		return dummySmallHead.next;
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
