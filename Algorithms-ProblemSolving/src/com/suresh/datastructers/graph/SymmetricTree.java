/**
 * Suresh Y
 */
package com.suresh.datastructers.graph;

import com.suresh.datastructers.graph.ZigZagTraversal.TreeNode;

/**
 * @author syerrarapu
 *
 */
public class SymmetricTree {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

  public static int symmeticBinaryTree(TreeNode root) {
    if (root == null) {
      return 1;
    }
    return symmetricBinaryTreeHelper(root.left, root.right) ? 1 : 0;
  }

  public static boolean symmetricBinaryTreeHelper(TreeNode rootOne, TreeNode rootTwo) {
    if (rootOne == null && rootTwo == null) {
      return true;
    }

    if (rootOne != null && rootTwo != null && rootOne.val == rootTwo.val) {
      return symmetricBinaryTreeHelper(rootOne.left, rootTwo.right)
          && symmetricBinaryTreeHelper(rootOne.right, rootTwo.left);
    }
    return false;
  }

}
