/**
 * Suresh Y
 */
package com.suresh.java.hackerrank.implementation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author syerrarapu
 *
 */
public class MinimumNumberOfSwaps {

  // Complete the minimumSwaps function below.
  static int minimumSwaps(int[] arr) {
    int swaps = 0;
    int[] sortedArray = Arrays.copyOf(arr, arr.length);
    Arrays.sort(sortedArray);
    Map<Integer, Integer> sortedToIndex = new HashMap<Integer, Integer>();
    boolean[] check = new boolean[arr.length];
    for (int i = 0; i < sortedArray.length; i++) {
      sortedToIndex.put(sortedArray[i], i);
      check[i] = false;
    }

    for (int i = 0; i < arr.length; i++) {
      int cycleLength = 0;
      int currentElement = i;
      while (!check[currentElement]) {
        check[currentElement] = true;
        cycleLength++;
        currentElement = sortedToIndex.get(arr[currentElement]);
      }
      if (cycleLength > 1) {
        swaps += (cycleLength - 1);
      }

    }

    return swaps;

  }

  public static void main(String[] args) {
    int[] arr = { 7, 1, 3, 2, 4, 5, 6 };
    System.out.println(minimumSwaps(arr));
  }

}
