package com.suresh.java.hackerrank.implementation;

import java.util.Scanner;
import java.util.Stack;

public class QueueTaleOfTwoStacks {
  public static class MyQueue<T> {
    Stack<T> stackNewestOnTop = new Stack<T>();
    Stack<T> stackOldestOnTop = new Stack<T>();

    public void enqueue(T value) {
      stackNewestOnTop.push(value);

    }

    public T peek() {

      if (!stackOldestOnTop.isEmpty()) {
        return stackOldestOnTop.peek();
      } else {
        while (!stackNewestOnTop.isEmpty()) {
          stackOldestOnTop.push(stackNewestOnTop.pop());
        }
        return stackOldestOnTop.peek();
      }

    }

    public T dequeue() {

      if (!stackOldestOnTop.isEmpty()) {
        return stackOldestOnTop.pop();
      } else {
        while (!stackNewestOnTop.isEmpty()) {
          stackOldestOnTop.push(stackNewestOnTop.pop());
        }
        return stackOldestOnTop.pop();
      }
    }

  }

  public static void main(String[] args) {
    MyQueue<Integer> queue = new MyQueue<Integer>();

    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

    for (int i = 0; i < n; i++) {
      int operation = scan.nextInt();
      if (operation == 1) { // enqueue
        queue.enqueue(scan.nextInt());
      } else if (operation == 2) { // dequeue
        queue.dequeue();
      } else if (operation == 3) { // print/peek
        System.out.println(queue.peek());
      }
    }
    scan.close();
  }
}
