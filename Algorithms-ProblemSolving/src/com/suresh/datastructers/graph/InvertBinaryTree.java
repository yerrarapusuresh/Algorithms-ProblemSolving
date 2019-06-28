/**
 * Suresh Y
 */
package com.suresh.datastructers.graph;

import com.suresh.datastructers.graph.ZigZagTraversal.TreeNode;

/**
 * @author syerrarapu
 *
 */
public class InvertBinaryTree {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

  public static TreeNode invertBinaryTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode temp = root.right;
    root.right = invertBinaryTree(root.left);
    root.left = invertBinaryTree(temp);
    return root;
  }

}
