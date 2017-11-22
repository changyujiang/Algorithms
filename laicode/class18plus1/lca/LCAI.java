package laicode.class18plus1.lca;

import laicode.common.TreeNode;
/*Recursion
Lowest Common Ancestor I
Given two nodes in a binary tree, find their lowest common ancestor.

Assumptions
There is no parent pointer for the nodes in the binary tree
The given two nodes are guaranteed to be in the binary tree

Examples

        5

      /   \

     9     12

   /  \      \

  2    3      14

The lowest common ancestor of 2 and 14 is 5
The lowest common ancestor of 2 and 9 is 9
*/
public class LCAI {
	  // 0. keypoint
	  // two nodes, binary tree, lca
	  
	  // 1. assumption
	  // no parent pointer in the node;
	  // two nodes are guaranteed to be in the tree
	  
	  // 2. approach
	  // recursion, dfs
	  // base case : if root is null/one/two, return root
	  // recursion rule: 
	  // case1: left != null || right != null return left or right
	  // case2: left && right != null || return root
	  // case3: left,right == null return null
	  
	  // 3. data structure
	  
	  // 4. comments
	  
	  // 5. big o complexity
	  // time: O(n) at most we need to loop throgh all the nodes
	  // space: O(height) the depth of call stack is equal to the tree height;
	  public TreeNode lowestCommonAncestor(TreeNode root,
	      TreeNode one, TreeNode two) {
	    // base cases
	    if (root == null || root == one || root == two) {
	      return root;
	    }
	    
	    // get value from left and right child
	    TreeNode left = lowestCommonAncestor(root.left, one, two);
	    TreeNode right = lowestCommonAncestor(root.right, one, two);
	    
	    // three cases
	    if (left != null && right != null) {
	      return root;
	    } else {
	      return left == null ? right : left;
	    }
	  }
}
