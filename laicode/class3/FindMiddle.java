package laicode.class3;

public class FindMiddle {
	public ListNode middleNode(ListNode head) {
		if (head == null) {
			return head;
		}

		ListNode slow = head;
		ListNode fast = head;

//		 fast.next != null && fast.next.next != null
//		 mark!!! important!!!
//		 care about putting the slow at the tail of first half
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

}
