/**
 * Suresh Y
 */
package com.suresh.datastructers.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author syerrarapu
 *
 */
public class LevelOrderTravers {

  public static TreeNode insert(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }
    if (val < root.val) {
      root.left = insert(root.left, val);
    } else if (val > root.val) {
      root.right = insert(root.right, val);
    }
    return root;
  }

  public static void printTree(TreeNode root) {
    if (root == null) {
      return;
    }
    printTree(root.left);
    System.out.println(root.val);
    printTree(root.right);
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    TreeNode root = null;
    int[] array = { 5, 2, 8, 1, 3, 6, 9 };
    for (int i : array) {
      root = insert(root, i);
    }

    levelOrder(root);
  }

  public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return null;
    }

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    Queue<TreeNode> queueOne = new LinkedList<>();
    Queue<TreeNode> queueTwo = new LinkedList<>();
    Queue<TreeNode> temp = null;
    queueOne.add(root);
    ArrayList<Integer> li = new ArrayList<>();
    li.add(root.val);
    result.add(li);
    while (true) {
      li = new ArrayList<Integer>();
      while (!queueOne.isEmpty()) {
        TreeNode dequeuedItem = queueOne.poll();
        if (dequeuedItem.left != null) {
          queueTwo.add(dequeuedItem.left);
          li.add(dequeuedItem.left.val);
        }
        if (dequeuedItem.right != null) {
          queueTwo.add(dequeuedItem.right);
          li.add(dequeuedItem.right.val);
        }
      }
      if (queueTwo.isEmpty()) {
        break;
      }
      result.add(li);
      temp = queueTwo;
      queueTwo = queueOne;
      queueOne = temp;

    }

    return result;

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
