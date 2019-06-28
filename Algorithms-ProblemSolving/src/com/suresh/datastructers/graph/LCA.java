/**
 * Suresh Y
 */
package com.suresh.datastructers.graph;

import com.suresh.datastructers.graph.ZigZagTraversal.TreeNode;

/**
 * @author syerrarapu
 *
 */
public class LCA {

  /**
   * @param args
   */
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode one = new TreeNode(2);
    TreeNode two = new TreeNode(3);
    root.left = one;
    root.right = two;
    System.out.println(LCA(root, 1, 1));

  }

  public static int LCA(TreeNode root, int itemOne, int itemTwo) {
    if (root == null) {
      return -1;
    }
    LCAHelper res = LCAHelper(root, itemOne, itemTwo);
    return res.lca != null ? res.lca : -1;

  }

  private static LCAHelper LCAHelper(TreeNode root, int itemOne, int itemTwo) {
    if (root == null) {
      return new LCAHelper();
    }

    LCAHelper tempLeft;
    LCAHelper tempRight;
    if (root.val == itemOne && root.val == itemTwo) {
      LCAHelper temp = new LCAHelper();
      temp.check = true;
      temp.lca = root.val;
      return temp;
    }

    if (root.val == itemOne || root.val == itemTwo) {
      tempLeft = LCAHelper(root.left, itemOne, itemTwo);
      if (tempLeft.check) {
        tempLeft.lca = root.val;
        return tempLeft;
      }
      tempRight = LCAHelper(root.right, itemOne, itemTwo);
      if (tempRight.check) {
        tempRight.lca = root.val;
        return tempRight;
      }
      tempLeft.check = true;
      return tempLeft;
    } else {
      tempLeft = LCAHelper(root.left, itemOne, itemTwo);
      if (tempLeft.lca != null) {
        return tempLeft;
      }
      tempRight = LCAHelper(root.right, itemOne, itemTwo);
      if (tempRight.lca != null) {
        return tempRight;
      }

      if (tempLeft.check && tempRight.check) {
        tempLeft.lca = root.val;
        return tempLeft;
      }

      if (tempLeft.check) {
        return tempLeft;
      }
      return tempRight;

    }

  }

  static class LCAHelper {
    boolean check;
    Integer lca;

    public LCAHelper() {
      check = false;
      lca = null;
    }
  }

}
