/**
 * Suresh Y
 */
package com.suresh.datastructers.singlelinkedlist;

/**
 * Node class data structures.
 * 
 * @author syerrarapu
 *
 */
public class Node<T extends Comparable<T>> {
  private T t;
  private Node<T> next;

  public Node(T t, Node<T> next) {
    this.t = t;
    this.next = next;
  }

  public T getValue() {
    return t;
  }

  public Node<T> getNext() {
    return next;
  }

  public void setNext(Node<T> nextNode) {
    this.next = nextNode;
  }

  public String toString() {
    return " " + t;
  }
}
