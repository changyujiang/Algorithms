package laicode.class20.midtermII;

import laicode.common.TreeNode;

/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class MaxPathSumII {
  // 0. key point
  // max path sum 
  // leaf node to leaf node
  
  // 1. assumption
  // if no such path exists, return min_value
  // when the root is null, return min_value
  
  // 2. approach
  // Recursion + Tree, return value in bottom_up way
  // 
  
  // 3. data structure
  
  // 4. comments
  
  // 5. big O complexity
  // time: O(n)
  // space: O(height) the deepest call stack is the height of binary tree
  public int maxPathSum(TreeNode root) {
    if (root == null) {
      return Integer.MIN_VALUE;
    }
    
    int[] max = new int[1];
    max[0] = Integer.MIN_VALUE;
    getRootToLeafSum(root, max);
    return max[0];
  }
  
  private int getRootToLeafSum(TreeNode root, int[] max) {
    // base case
    if (root == null) {
      return 0;
    }
    
    int left = getRootToLeafSum(root.left, max);
    int right = getRootToLeafSum(root.right, max);
    
    if (root.left == null || root.right == null) {
      return root.left == null? right + root.key : left + root.key;
    } 
    
    // left != null && right != null
    int pathSum = left + right + root.key;
    if (pathSum > max[0]) {
      max[0] = pathSum;
    }
    return Math.max(left, right) + root.key;
  }
}
