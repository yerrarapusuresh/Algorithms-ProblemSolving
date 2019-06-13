/**
 * Suresh Y
 */
package com.suresh.datastructers.stack;

import java.util.Stack;

/**
 * @author syerrarapu
 *
 */
public class MaxRectUnderHistogram {

  static int maxRect(int[] array) {
    int max = Integer.MIN_VALUE;

    Stack<Integer> stack = new Stack<Integer>();
    for (int i = 0; i < array.length; i++) {
      if (stack.isEmpty() || array[i] >= array[stack.peek()]) {
        stack.push(i);
      } else {
        while (!stack.isEmpty() && array[i] < array[stack.peek()]) {
          int topIndex = stack.pop();
          int currentMax = array[topIndex] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
          if (max < currentMax) {
            max = currentMax;
          }
        }
        stack.push(i);
      }
    }

    while (!stack.isEmpty()) {

      int topIndex = stack.pop();
      int currentMax = array[topIndex]
          * (stack.isEmpty() ? array.length : (array.length - stack.peek() - 1));
      if (max < currentMax) {
        max = currentMax;
      }

    }

    return max;
  }

  public static void main(String[] args) {
    int[] array = { 11, 11, 10, 10, 10 };
    System.out.println(maxRect(array));

  }

}
