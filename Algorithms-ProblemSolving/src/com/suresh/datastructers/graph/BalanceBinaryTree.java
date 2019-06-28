/**
 * Suresh Y
 */
package com.suresh.datastructers.graph;

import com.suresh.datastructers.graph.ZigZagTraversal.TreeNode;

/**
 * @author syerrarapu
 *
 */
public class BalanceBinaryTree {

  public static void main(String[] args) {

    TreeNode root = new TreeNode(1);
    TreeNode one = new TreeNode(2);
    TreeNode two = new TreeNode(3);
    root.left = one;
    one.right = two;
    System.out.println(isItBalanced(root));

  }

  public static boolean isItBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }

    return isItBalancedHelper(root, new HelperBalancedClass()).isItBalanced;

  }

  public static HelperBalancedClass isItBalancedHelper(TreeNode root,
      HelperBalancedClass helperClass) {
    if (root == null) {
      helperClass.isItBalanced = true;
      helperClass.maxHeight = 0;
      return helperClass;
    }

    HelperBalancedClass temp = isItBalancedHelper(root.left, helperClass);
    if (!temp.isItBalanced) {
      return temp;
    }
    int leftSize = temp.maxHeight;
    temp = isItBalancedHelper(root.right, helperClass);
    if (!temp.isItBalanced) {
      return temp;
    }
    if (Math.abs(leftSize - temp.maxHeight) > 1) {
      temp.isItBalanced = false;
      return temp;
    }

    temp.maxHeight = Math.max(leftSize, temp.maxHeight) + 1;
    return temp;

  }

  static class HelperBalancedClass {
    private boolean isItBalanced;
    private int maxHeight;
  }

}
