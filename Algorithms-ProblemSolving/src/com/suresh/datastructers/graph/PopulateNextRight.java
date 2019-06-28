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
public class PopulateNextRight {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

  public class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
      val = x;
    }
  }

  public void connect(TreeLinkNode root) {

    if (root == null) {
      return;
    }

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    Queue<TreeLinkNode> queueOne = new LinkedList<>();
    Queue<TreeLinkNode> queueTwo = new LinkedList<>();
    Queue<TreeLinkNode> temp = null;
    queueOne.add(root);
    ArrayList<Integer> li = new ArrayList<>();
    li.add(root.val);
    result.add(li);
    while (true) {
      li = new ArrayList<Integer>();
      while (!queueOne.isEmpty()) {
        TreeLinkNode dequeuedItem = queueOne.poll();
        dequeuedItem.next = queueOne.peek();
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

  }

}
