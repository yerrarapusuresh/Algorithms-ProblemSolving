/**
 * Suresh Y
 */
package com.suresh.datastructers.graph;

/**
 * @author syerrarapu
 *
 */
public class SortedListToBinarySearchTree {

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  // Definition for singly-linked list.
  static class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    ListNode one = new ListNode(1);
    ListNode two = new ListNode(2);

    TreeNode root = sortedListToBST(one);
    System.out.println(root);

  }

  public static TreeNode sortedListToBST(ListNode a) {
    if (a == null) {
      return null;
    }

    ListNode middle = getMiddle(a);
    TreeNode node = new TreeNode(middle.val);
    if (a == middle) {
      node.right = sortedListToBST(middle.next);
      return node;
    }
    ListNode temp = a;
    while (temp.next != middle) {
      temp = temp.next;
    }
    temp.next = null;
    node.left = sortedListToBST(a);
    node.right = sortedListToBST(middle.next);
    temp.next = middle;
    return node;
  }

  public static ListNode getMiddle(ListNode node) {
    if (node == null) {
      return null;
    }
    ListNode slowPointer = node;
    ListNode fastPointer = node;

    while (fastPointer.next != null && fastPointer.next.next != null) {
      fastPointer = fastPointer.next.next;
      slowPointer = slowPointer.next;
    }
    return slowPointer;
  }

}
