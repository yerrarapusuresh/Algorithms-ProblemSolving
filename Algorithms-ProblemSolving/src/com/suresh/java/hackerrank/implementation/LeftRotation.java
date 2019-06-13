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
public class LeftRotation {

  // Complete the minimumBribes function below.
  static void minimumBribes(int[] q) {
    int noOfBribes = 0;
    for (int i = 0; i < q.length; i++) {
      int numberOfBribesWithCurrentElement = 0;
      for (int j = i + 1; j < q.length; j++) {
        if (q[i] > q[j]) {
          numberOfBribesWithCurrentElement++;
        }
      }
      if (numberOfBribesWithCurrentElement > 2) {
        System.out.println("Too chaotic");
      }
      noOfBribes += numberOfBribesWithCurrentElement;
    }

    System.out.println(noOfBribes);

  }

  static int gcd(int numOne, int numTwo) {
    if (numTwo != 0) {
      return gcd(numTwo, numOne % numTwo);
    } else {
      return numOne;
    }
  }

  static int[] rotLeft(int[] a, int d) {

    int dis = gcd(a.length, d);

    for (int i = 0; i < dis; i++) {
      int temp = a[i];
      int j = i;
      while (true) {
        int k = (j + d) % a.length;
        if (k == i) {
          a[j] = temp;
          break;
        }
        a[j] = a[k];
        j = k;

      }
    }

    return a;

  }

  public static void main(String[] args) {
    int[] a = { 1, 2, 3, 4, 5 };
    rotLeft(a, 4);
    System.out.println(Arrays.toString(a));

  }

}
