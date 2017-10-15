package laicode.class3;

public class MegerSortedList {
	public ListNode merge(ListNode one, ListNode two) {
		ListNode dummyHead = new ListNode(0);
		ListNode curOne = one;
		ListNode curTwo = two;
		ListNode cur = dummyHead;
		while (curOne != null && curTwo != null) {
			if (curOne.value < curTwo.value) {
				cur.next = curOne;
				curOne = curOne.next;
			} else {
				cur.next = curTwo;
				curTwo = curTwo.next;
			}
			cur = cur.next;
		}
		if (curOne != null) {
			cur.next = curOne;
		} else if (curTwo != null) {
			cur.next = curTwo;
		}

		return dummyHead.next;
	}

}
