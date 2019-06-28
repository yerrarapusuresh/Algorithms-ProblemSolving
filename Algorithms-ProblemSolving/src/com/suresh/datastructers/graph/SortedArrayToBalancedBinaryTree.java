/**
 * Suresh Y
 */
package com.suresh.datastructers.graph;

import java.util.ArrayList;
import java.util.Arrays;

import com.suresh.datastructers.graph.ZigZagTraversal.TreeNode;

/**
 * @author syerrarapu
 *
 */
public class SortedArrayToBalancedBinaryTree {

  /**
   * @param args
   */
  public static void main(String[] args) {
    int[] array = { 1, 2, 3, 4, 5 };
    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);

    TreeNode root = arrayToBinaryTree(list);
    System.out.println(root);

  }

  public static TreeNode arrayToBinaryTree(final ArrayList<Integer> array) {
    if (array.size() <= 0) {
      return null;
    }
    return arrayToBinaryTree(array, 0, array.size() - 1);

  }

  /**
   * @param array
   * @param i
   * @param j
   * @return
   */
  private static TreeNode arrayToBinaryTree(ArrayList<Integer> array, int start, int end) {
    if (end < start) {
      return null;
    }
    int mid = start + (end - start) / 2;
    TreeNode root = new TreeNode(array.get(mid));
    root.left = arrayToBinaryTree(array, start, mid - 1);
    root.right = arrayToBinaryTree(array, mid + 1, end);
    return root;
  }

}
