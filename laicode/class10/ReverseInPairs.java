package laicode.class10;

import laicode.class3.ListNode;

/*Reverse Linked List In Pairs
Reverse pairs of elements in a singly-linked list.

Examples

L = null, after reverse is null
L = 1 -> null, after reverse is 1 -> null
L = 1 -> 2 -> null, after reverse is 2 -> 1 -> null
L = 1 -> 2 -> 3 -> null, after reverse is 2 -> 1 -> 3 -> null*/

public class ReverseInPairs {
	// 0. key point
	// reverse pair by pair

	// 1. assumption
	// if input is null, return null
	// if input.next == null, return input

	// 2. approach
	// recursion
	// 1 -> 2 -> 3 -> null
	// subproblem:
	// subHead = reverse(head.next.next);
	// 2 -> 1 -> 3 -> null

	// 3. data structure

	// 4. comment

	// 5. BIG O COMPLEXITY
	// TIEM: O(N)
	// SPACE: O(N/2) call stack
	public ListNode reverseInPairs(ListNode head) {
		// base case
		if (head == null || head.next == null) {
			return head;
		}

		ListNode subHead = reverseInPairs(head.next.next);
		ListNode newHead = head.next;
		newHead.next = head;
		head.next = subHead;

		return newHead;
	}
}