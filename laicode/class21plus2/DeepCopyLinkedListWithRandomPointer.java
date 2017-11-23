package laicode.class21plus2;

import java.util.HashMap;
import java.util.Map;

import laicode.common.RandomListNode;

public class DeepCopyLinkedListWithRandomPointer {
	// 0. key point
	// each node has next and random;
	// build the relationship between original node and copied node
	// avoiding one node being copy more than one time

	// 1. assumption
	// if head is null, return null

	// 2. approach
	// use a hashmap to store the relation of node and node'

	// 3. data structure
	// hashmap

	// 4. comment

	// 5. Big O complexity
	// time: O(n)
	// space: O(1)

	// example: 1 -> 2 -> 3 -> null
	// | ^
	// |---------|

	// Another method: three pass
	// 1. copy a node a insert it in between
	// 2. generate random pointer
	// 3. extract it from original list
	// it is not a good choice to alter the original data structure;
	// it might be dangerous to do it in real industry production.
	public RandomListNode copy(RandomListNode head) {
		if (head == null) {
			return head;
		}
		// copy the head at first
		RandomListNode oldCur = head;
		RandomListNode newCur = new RandomListNode(oldCur.value);
		// keep newHead and return it in the end
		RandomListNode newHead = newCur;
		// record 1-1 relation
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		map.put(oldCur, newCur);

		while (oldCur != null) {
			RandomListNode next = oldCur.next;
			if (next != null) {
				RandomListNode nextCopy = map.get(next);
				if (nextCopy == null) {
					nextCopy = new RandomListNode(next.value);
					map.put(next, nextCopy);
				}
				newCur.next = nextCopy;
			}

			RandomListNode random = oldCur.random;
			if (random != null) {
				RandomListNode randomCopy = map.get(random);
				if (randomCopy == null) {
					randomCopy = new RandomListNode(random.value);
					map.put(random, randomCopy);
				}
				newCur.random = randomCopy;
			}

			oldCur = oldCur.next;
			newCur = newCur.next;
		}

		return newHead;
	}
}
