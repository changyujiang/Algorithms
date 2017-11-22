package laicode.class18plus1.lca;

import laicode.common.TreeNodeP;


/*Lowest Common Ancestor II
Given two nodes in a binary tree (with parent pointer available), 
find their lowest common ancestor.

Assumptions
There is parent pointer for the nodes in the binary tree
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

public class LCAII {
	  // 0. keypoint
	  // 2 nodes , binary tree , with parent pointer
	  
	  // 1. assumption
	  // two nodes are not guaranteed to be in the tree
	  
	  // 2. approach
	  // start from each node, get the height of each node
	  // diff = |heightOne - heightTwo|
	  // move the deeper one up; when diff == 0, move two nodes up together
	  // until they meets
	  
	  // 3. data structure
	  
	  // 4. comment
	  
	  // 5. big o complexity
	  // time: O(n) to get height O(n) to merge
	  // space: O(1)
	  public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
	    int heightOne = getHeight(one);
	    int heightTwo = getHeight(two);
	    
	    TreeNodeP res = mergeNode(one, two, heightOne, heightTwo);
	    
	    return res;
	  }
	  
	  private TreeNodeP mergeNode(TreeNodeP one, TreeNodeP two, int h1, int h2) {
	    int diff = Math.abs(h1 - h2);
	    while (diff != 0) {
	      if (h1 > h2) {
	        one = one.parent;
	        diff--;
	      } else {
	        two = two.parent;
	        diff--;
	      }
	    }
	    
	    // if nodes are not in the same tree
	    // in the end both of them equal to null
	    // return null
	    while (one != two) {
	      one = one.parent;
	      two = two.parent;
	    }
	    
	    return one;
	  }
	  
	  private int getHeight(TreeNodeP node) {
	    int height = 1;
	    while (node != null) {
	      height++;
	      node = node.parent;
	    }
	    return height;
	  }
}
