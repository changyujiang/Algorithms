package laicode.class18plus1.lca;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import laicode.common.TreeNode;


/*Lowest Common Ancestor IV
Given K nodes in a binary tree, find their lowest common ancestor.

Assumptions
K >= 2
There is no parent pointer for the nodes in the binary tree
The given K nodes are guaranteed to be in the binary tree

Examples

        5

      /   \

     9     12

   /  \      \

  2    3      14

The lowest common ancestor of 2, 3, 14 is 5

The lowest common ancestor of 2, 3, 9 is 9*/

public class LCAIV {
	  // 0. key point
	  // k nodes in a binary tree
	  
	  // 1. assumption
	  // nodes are guaranteed in the binary tree
	  
	  // 2. approach
	  // recursion
	  // base case: if root == null || anyone of nodes list return root
	  // recursion rule: 
	  // case1: both of left and right is null, return null
	  // case2: both of left and right is not null, return root
	  // case3: either left or right is not null, return not null;
	  
	  // 3. data structure
	  // hash set to store k nodes
	  // to improve the operation of searching
	  
	  // 4. comments
	  
	  // 5. big o complexity
	  // time: O(n) to traverse all nodes
	  // space: O(height) + O(k) (hashset)
	  public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
	    Set<TreeNode> nodesSet = new HashSet<>();
	    for (TreeNode t : nodes) {
	      nodesSet.add(t);
	    }
	    
	    TreeNode res = kLCA(root, nodesSet);
	    
	    return res;
	  }
	  
	  private TreeNode kLCA(TreeNode root, Set<TreeNode> set) {
	    // base case
	    if (root == null || set.contains(root)) {
	      return root;
	    }
	    
	    TreeNode left = kLCA(root.left, set);
	    TreeNode right = kLCA(root.right, set);
	    
	    // recursion rule
	    if (left != null && right != null) {
	      return root;
	    } else {
	      return left == null? right : left;
	    }
	  }
}
