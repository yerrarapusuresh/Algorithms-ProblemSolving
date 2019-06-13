/**
 * Suresh Y
 */
package com.suresh.datastructers.singlelinkedlist;

import java.util.Arrays;
import java.util.List;

/**
 * @author syerrarapu
 *
 */
public class SingleLinkedListUtils {

  /**
   * main method.
   * 
   * @param args
   *          command line arguments.
   */
  public static void main(String[] args) {
    // list creation

    Node<Integer> listOne = generateList(Arrays.asList(0, 1,3,4,5,6,7,8,9));
    Node<Integer> listTwo = generateList(Arrays.asList(6, 7, 8, 9, 0));
    // listOne = append(listOne, listTwo);

    listOne = reverseListRecursive(listOne);
    // listOne = removeDuplicates(listOne);

    // listTwo = alternateSplit(listOne);
     printLinkedList(listOne);
    // printLinkedList(listTwo);
    /*
     * listTwo = splitByHalf(listOne); printLinkedList(listOne); printLinkedList(listTwo);
     */

    /*
     * root = sortedInsert(root, new Node<>(2, null)); root = sortedInsert(root, new Node<>(4,
     * null)); root = sortedInsert(root, new Node<>(6, null)); root = sortedInsert(root, new
     * Node<>(8, null)); root = sortedInsert(root, new Node<>(0, null)); root = sortedInsert(root,
     * new Node<>(9, null));
     */

    /*
     * root = insertNth(root, -1, 0); insertNth(root, 10, 3); insertNth(root, 9, 9);
     */
    // to print list

    /*
     * // check size of the list if (getListSize(root) == list.size()) {
     * System.out.println("Size of the list " + list.size()); }
     * 
     * // get Nth position for (int i = -1; i < 10; i++) { try { System.out.println(getNth(root,
     * i)); } catch (Exception e) { System.out.println("Exception caught at " + i); } }
     */

  }

  public static void printLinkedList(Node<Integer> root) {
    System.out.println();
    while (root != null) {
      System.out.println(root);
      root = root.getNext();
    }
  }

  public static Node<Integer> generateList(List<Integer> list) {
    Node<Integer> dummy = new Node<Integer>(0, null);
    Node<Integer> root = dummy;

    for (Integer i : list) {
      dummy.setNext(new Node<Integer>(i, null));
      dummy = dummy.getNext();
    }
    return root.getNext();
  }

  public static int getListSize(Node<Integer> root) {
    int counter = 0;
    while (root != null) {
      counter++;
      root = root.getNext();
    }
    return counter;
  }

  public static Node<Integer> getNth(Node<Integer> root, int index)
      throws IndexOutOfBoundsException, UnsupportedOperationException {
    if (index < 0) {
      throw new IndexOutOfBoundsException("Index should not below 0");
    }

    if (root == null) {
      throw new UnsupportedOperationException("cannon perform operation empty list");
    }

    int i = 0;
    while (root != null) {
      if (i++ == index) {
        return root;
      }
      root = root.getNext();
    }

    throw new IndexOutOfBoundsException("Index should not below 0");
  }

  public static Node<Integer> insertNth(Node<Integer> root, int value, int index) {
    if (index < 0) {
      throw new IndexOutOfBoundsException("index should not less than 0");
    }
    if (index == 0) {
      return push(root, value);
    }
    int i = 1;
    Node<Integer> dummy = root;
    while (dummy != null) {
      if (i++ == index) {
        dummy.setNext(new Node<>(value, dummy.getNext()));
        return root;
      }
      dummy = dummy.getNext();
    }
    throw new IndexOutOfBoundsException("index is out of bounds: greater than list size");
  }

  /**
   * @param root
   * @param value
   * @return
   */
  public static Node<Integer> push(Node<Integer> root, int value) {
    return new Node<>(value, root);
  }

  public static Node<Integer> sortedInsert(Node<Integer> root, Node<Integer> item) {
    if (root == null || item.getValue() < root.getValue()) {
      item.setNext(root);
      return item;
    }

    Node<Integer> dummy = root;
    while (dummy.getNext() != null && dummy.getNext().getValue() < item.getValue()) {
      dummy = dummy.getNext();
    }

    item.setNext(dummy.getNext());
    dummy.setNext(item);
    return root;
  }

  public static Node<Integer> insertionSort(Node<Integer> root) {
    Node<Integer> sortedResult = null;
    while (root != null) {
      Node<Integer> temp = root.getNext();
      sortedResult = sortedInsert(sortedResult, root);
      root = temp;
    }
    return sortedResult;
  }

  public static Node<Integer> append(Node<Integer> listOne, Node<Integer> listTwo) {
    if (listOne == null) {
      return listTwo;
    }
    if (listTwo == null) {
      return listOne;
    }

    Node<Integer> root = listOne;
    while (root.getNext() != null) {
      root = root.getNext();
    }
    root.setNext(listTwo);
    return listOne;
  }

  public static Node<Integer> splitByHalf(Node<Integer> root) {
    if (root == null) {
      return root;
    }

    Node<Integer> slowRunner = root;
    Node<Integer> fastRunner = root;
    while (fastRunner.getNext() != null && fastRunner.getNext().getNext() != null) {
      slowRunner = slowRunner.getNext();
      fastRunner = fastRunner.getNext().getNext();
    }

    fastRunner = slowRunner.getNext();
    slowRunner.setNext(null);
    return fastRunner;

  }

  public static Node<Integer> removeDuplicates(Node<Integer> root) {
    if (root == null) {
      return null;
    }

    Node<Integer> iterator = root;
    while (iterator.getNext() != null) {
      if (iterator.getValue() == iterator.getNext().getValue()) {
        iterator.setNext(iterator.getNext().getNext());
      } else {
        iterator = iterator.getNext();
      }
    }
    return root;

  }

  public static Node<Integer> moveNode(Node<Integer> listOne, Node<Integer> listTwo) {
    if (listOne == null) {
      return listTwo;
    }
    if (listTwo == null) {
      return listOne;
    }
    return null;
  }

  public static Node<Integer> alternateSplit(Node<Integer> head) {
    if (head == null || head.getNext() == null) {
      return null;
    }

    Node<Integer> dummyHeaderOne = new Node<Integer>(0, null);
    Node<Integer> dummyHeaderTwo = new Node<Integer>(0, null);
    Node<Integer> dummyIterator = dummyHeaderTwo;

    while (head != null) {
      Node<Integer> node = head.getNext();
      insertNode(dummyHeaderOne, head);
      dummyHeaderOne = dummyHeaderOne.getNext();

      if (node != null) {
        head = node.getNext();
        insertNode(dummyIterator, node);
        dummyIterator = dummyIterator.getNext();
      } else {
        head = node;
      }
    }
    return dummyHeaderTwo.getNext();
  }

  private static void insertNode(Node<Integer> nodeOne, Node<Integer> nodeTwo) {
    if (nodeOne == null) {
      return;
    }
    if (nodeTwo == null) {
      return;
    }
    nodeTwo.setNext(nodeOne.getNext());
    nodeOne.setNext(nodeTwo);

  }

  public static Node<Integer> reverseList(Node<Integer> list) {
    if (list == null || list.getNext() == null) {
      return list;
    }
    Node<Integer> prev = null;
    Node<Integer> curr = list;
    Node<Integer> next = null;
    while (curr != null) {
      next = curr.getNext();
      curr.setNext(prev);
      prev = curr;
      curr = next;
    }
    return prev;
  }
  
  public static Node<Integer> reverseListRecursive(Node<Integer> list) {
    if(list == null || list.getNext() == null) {
      return list;
    }
   return  reverseListRecursive(list, null);
    
  }

  /**
   * @param list
   * @param object
   * @return
   */
  private static Node<Integer> reverseListRecursive(Node<Integer> list, Node<Integer> prev) {
    if(list.getNext() == null) {
      list.setNext(prev);
      return list;
    }
    Node<Integer> temp = list.getNext();
    list.setNext(prev);
    return reverseListRecursive(temp, list);
  }
}
