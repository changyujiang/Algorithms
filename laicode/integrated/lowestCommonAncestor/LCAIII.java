package laicode.integrated.lowestCommonAncestor;

import laicode.common.TreeNode;

/*Recursion
Lowest Common Ancestor III
Given two nodes in a binary tree, find their lowest common ancestor 
(the given two nodes are not guaranteed to be in the binary tree).

Return null If any of the nodes is not in the tree.

Assumptions
There is no parent pointer for the nodes in the binary tree
The given two nodes are not guaranteed to be in the binary tree

Examples

        5

      /   \

     9     12

   /  \      \

  2    3      14

The lowest common ancestor of 2 and 14 is 5

The lowest common ancestor of 2 and 9 is 9

The lowest common ancestor of 2 and 8 is null (8 is not in the tree)*/

public class LCAIII {
	  // 0. key points
	  // 2 nodes in binary tree without parent pointer
	  // not guaranteed to be in the binary tree
	  
	  // 1. assumption
	  
	  // 2. approach
	  // first traverse the tree to see both nodes are in the tree
	  // do it like a normal tree
	  
	  // 3. data structure
	  
	  // 4. comments
	  
	  // 5. big o complexity
	  // time: O(n) confirm if both nodes are exist, O(n) to find the lca
	  // space: O(height)
	  public TreeNode lowestCommonAncestor(TreeNode root,
	      TreeNode one, TreeNode two) {
	    
	    boolean[] isExists = new boolean[2];
	    exist(root, one, two, isExists);
	    if (isExists[0] == false || isExists[1] == false) {
	      return null;
	    }
	    
	    TreeNode res = lca(root, one, two);
	    
	    return res;
	  }
	  
	  private TreeNode lca(TreeNode root, TreeNode one, TreeNode two) {
	    //base case
	    if (root == null || root == one || root == two) {
	      return root;
	    }
	    
	    TreeNode left = lca(root.left, one, two);
	    TreeNode right = lca(root.right, one, two);
	    
	    if(left != null && right != null) {
	      return root;
	    } else {
	      return left == null? right : left;
	    }
	  }
	  
	  private void exist(TreeNode root, TreeNode one, TreeNode two, boolean[] isExists) {
	    //base case 
	    if (root == null) {
	      return;
	    }
	    
	    if (root == one) {
	      isExists[0] = true;
	    }
	    if (root == two) {
	      isExists[1] = true;
	    }
	    
	    exist(root.left, one, two, isExists);
	    exist(root.right, one, two, isExists);
	  }
}
