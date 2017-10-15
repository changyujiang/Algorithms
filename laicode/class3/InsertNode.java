package laicode.class3;

public class InsertNode {
	public ListNode insert(ListNode head, int value) {
		ListNode newNode = new ListNode(value);
		// 1. determine if inserted node is before head
		if (head == null || head.value >= value) {
			newNode.next = head;
			return newNode;
		}

		// 2. insert the node into right position
		// prev is the node before the position
		ListNode prev = head;
		// loop terminate when go to the end OR find the position\
		// node inseted between prev and prev.next
		while (prev.next != null && prev.next.value <= value) {
			prev = prev.next;
		}
		newNode.next = prev.next;
		prev.next = newNode;

		return head;
	}
}
