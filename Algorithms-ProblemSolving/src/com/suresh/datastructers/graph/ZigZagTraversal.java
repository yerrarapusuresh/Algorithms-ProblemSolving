/**
 * Suresh Y
 */
package com.suresh.datastructers.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import com.suresh.datastructers.graph.LevelOrderTravers.TreeNode;

/**
 * @author syerrarapu
 *
 */
public class ZigZagTraversal {

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

    Deque<TreeNode> dequeOne = new LinkedList<>();
    System.out.println(dequeOne.peek());

    TreeNode root = null;
    int[] array = { 5, 2, 8, 1, 3, 6, 9, -1, 11, 0, 10 };
    for (int i : array) {
      root = insert(root, i);
    }

    printTree(root);

    for (ArrayList<Integer> list : zigZagTraversal(root)) {
      System.out.println(list);
    }

  }

  public static ArrayList<ArrayList<Integer>> zigZagTraversal(TreeNode root) {
    Deque<TreeNode> dequeOne = new LinkedList<>();
    Deque<TreeNode> dequeTwo = new LinkedList<>();
    Deque<TreeNode> temp = null;
    int counter = 0;
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    dequeOne.add(root);

    while (!dequeOne.isEmpty()) {
      ArrayList<Integer> levelList = new ArrayList<>();
      if (counter % 2 == 0) {
        // queue one should act like queue
        while (!dequeOne.isEmpty()) {

          TreeNode dequeItem = dequeOne.poll();
          levelList.add(dequeItem.val);
          // second deque acts like stack cause
          if (dequeItem.left != null) {
            dequeTwo.push(dequeItem.left);
          }
          if (dequeItem.right != null) {
            dequeTwo.push(dequeItem.right);
          }
        }
      } else {
        while (!dequeOne.isEmpty()) {
          TreeNode dequeItem = dequeOne.poll();
          levelList.add(dequeItem.val);
          if (dequeItem.right != null) {
            dequeTwo.push(dequeItem.right);
          }
          if (dequeItem.left != null) {
            dequeTwo.push(dequeItem.left);
          }
        }

      }

      counter++;
      temp = dequeOne;
      dequeOne = dequeTwo;
      dequeTwo = temp;
      list.add(levelList);

    }
    return list;
  }

}
