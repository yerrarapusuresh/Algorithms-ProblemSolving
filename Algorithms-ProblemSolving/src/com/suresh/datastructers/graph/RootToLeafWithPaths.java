/**
 * Suresh Y
 */
package com.suresh.datastructers.graph;

import java.util.ArrayList;

/**
 * @author syerrarapu
 *
 */
public class RootToLeafWithPaths {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    TreeNode root = new TreeNode(1);
    TreeNode one = new TreeNode(2);
    TreeNode two = new TreeNode(3);
    root.left = one;
    root.right = two;
    for (ArrayList<Integer> list : sumPathToLeaf(root, 3))
      System.out.println(list);
  }

  public static ArrayList<ArrayList<Integer>> sumPathToLeaf(TreeNode root, int sum) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> current = new ArrayList<>();
    sumPathToLeafHelper(root, sum, result, current);
    return result;
  }

  public static void sumPathToLeafHelper(TreeNode root, int sum,
      ArrayList<ArrayList<Integer>> result, ArrayList<Integer> currentList) {
    if (root == null) {
      return;
    }
    currentList.add(root.val);
    if (root.val == sum && root.right == null && root.left == null) {
      ArrayList<Integer> tempList = new ArrayList<>(currentList);
      result.add(tempList);
      currentList.remove(currentList.size() - 1);
      return;
    }
    sumPathToLeafHelper(root.left, sum - root.val, result, currentList);
    sumPathToLeafHelper(root.right, sum - root.val, result, currentList);

    currentList.remove(currentList.size() - 1);

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
