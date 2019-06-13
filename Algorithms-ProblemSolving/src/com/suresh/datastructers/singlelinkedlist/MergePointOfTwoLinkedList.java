/**
 * Suresh Y
 */
package com.suresh.datastructers.singlelinkedlist;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * @author syerrarapu
 *
 */
public class MergePointOfTwoLinkedList {

  class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
      this.data = nodeData;
      this.next = null;
    }
  }

  static class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
      this.head = null;
      this.tail = null;
    }

    public void insertNode(int nodeData) {
      SinglyLinkedListNode node = null;

      if (this.head == null) {
        this.head = node;
      } else {
        this.tail.next = node;
      }

      this.tail = node;
    }
  }

  public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep,
      BufferedWriter bufferedWriter) throws IOException {
    while (node != null) {
      bufferedWriter.write(String.valueOf(node.data));

      node = node.next;

      if (node != null) {
        bufferedWriter.write(sep);
      }
    }
  }

  // Complete the findMergeNode function below.

  /*
   * For your reference:
   *
   * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
   *
   */


}
