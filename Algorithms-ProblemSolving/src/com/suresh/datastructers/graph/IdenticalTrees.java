/**
 * Suresh Y
 */
package com.suresh.datastructers.graph;

import com.suresh.datastructers.graph.ZigZagTraversal.TreeNode;

/**
 * @author syerrarapu
 *
 */
public class IdenticalTrees {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

  public static boolean identicalTreeCheck(TreeNode rootOne, TreeNode rootTwo) {
    if (rootOne == null && rootTwo == null) {
      return true;
    }

    if (rootOne != null && rootTwo != null) {
      if (rootOne.val != rootTwo.val) {
        return false;
      }
      return identicalTreeCheck(rootOne.left, rootTwo.left)
          && identicalTreeCheck(rootOne.right, rootTwo.right);
    }

    return false;

  }

}
