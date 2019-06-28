/**
 * Suresh Y
 */
package com.suresh.datastructers.graph;

import com.suresh.datastructers.graph.RootToLeafWithPaths.TreeNode;

/**
 * @author syerrarapu
 *
 */
public class MinDistanceInTree {

  /**
   * @param args
   */
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode one = new TreeNode(2);
    TreeNode two = new TreeNode(3);
    // root.left = one;
    root.right = two;
    System.out.println(minDistance(root));

  }

  public static int minDistance(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return minDistnaceHelper(root);
  }

  /**
   * @param root
   * @return
   */
  private static int minDistnaceHelper(TreeNode root) {
    // check for leaf condition
    if (root.left == null && root.right == null) {
      return 1;
    }
    if (root.left == null) {
      return minDistnaceHelper(root.right) + 1;
    }
    if (root.right == null) {
      return minDistnaceHelper(root.left) + 1;
    }

    return Math.min(minDistnaceHelper(root.left), minDistnaceHelper(root.right)) + 1;

  }

  static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
      left = null;
      right = null;
    }

  }
}
