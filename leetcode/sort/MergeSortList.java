package leetcode.sort;

public class MergeSortList {
	public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        
        //cut into two halves
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        
        ListNode res = merge(left,right);
        
        return res;
    }
    
    public ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while (left != null && right != null){
            if (left.val <= right.val){
                 cur.next = left;
                left = left.next;
            }
            else{
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        
        if (left != null){
            cur.next = left;
        }
        if (right != null){
            cur.next = right;
        }
        
        return dummy.next;
    }
    
    private class ListNode {
    	      int val;
    	      ListNode next;
    	      ListNode(int x) { val = x; }
    	  }
    
    public static void main(String[] args){
    	MergeSortList solution = new MergeSortList();
    	ListNode a = solution.new ListNode(2);
    	ListNode b = solution.new ListNode(1);
    	ListNode c = solution.new ListNode(5);
    	ListNode d = solution.new ListNode(-10);
    	a.next = b;
    	b.next = c;
    	c.next = d;
    	
    	a = solution.sortList(a);
    	while (a != null){
    		System.out.print(a.val+" ");
    		a = a.next;
    	}
    }
}
