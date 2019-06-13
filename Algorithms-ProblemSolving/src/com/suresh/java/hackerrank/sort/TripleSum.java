/**
 * Suresh Y
 */
package com.suresh.java.hackerrank.sort;

import java.util.Arrays;

/**
 * @author syerrarapu
 *
 */
public class TripleSum {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    int[] a = { 0, 1, 4, 5, 6 };
    int[] b = { 2, 3, 3 };
    int[] c = { 1, 2, 3 };

    System.out.println(triplets(a, b, c));

    /*
     * int[] duplicateCheck = { 1, 2, 3, 4 }; int newLimit = removeDuplicates(duplicateCheck); for
     * (int i = 0; i <= newLimit; i++) { System.out.println(duplicateCheck[i]); }
     */

  }

  static long triplets(int[] a, int[] b, int[] c) {

    int[] aa = Arrays.stream(a).sorted().distinct().toArray();
    int[] bb = Arrays.stream(b).sorted().distinct().toArray();
    int[] cc = Arrays.stream(c).sorted().distinct().toArray();

    long result = 0;
    int x = 0, y = 0, z = 0;
    for (; y < bb.length; y++) {
      x = z = -1;
      x = Arrays.binarySearch(aa, bb[y]);
      z = Arrays.binarySearch(cc, bb[y]);
      x = (x < 0) ? -x - 1 : x + 1;
      z = (z < 0) ? -z - 1 : z + 1;

      result += (long) x * (long) z;
    }
    return result;
  }

  static long triplets2(int[] a, int[] b, int[] c) {
    long count = 0;
    int aLimit = removeDuplicates(a);
    int bLimit = removeDuplicates(b);
    Arrays.sort(b, 0, bLimit + 1);
    int cLimit = removeDuplicates(c);

    for (int i = 0; i <= aLimit; i++) {
      for (int j = 0; j <= cLimit; j++) {
        int index = tripletsHelper(b, Math.max(a[i], c[j]), bLimit);
        if (index == -1) {
          break;
        } else {
          count += (bLimit + 1) - index;
        }

      }
    }

    return count;
  }

  static int tripletsHelper(int[] array, int element, int bLimit) {
    int index = -1;

    int low = 0;
    int high = bLimit;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (array[mid] == element) {
        index = mid;
        high = mid - 1;
      } else if (array[mid] > element) {
        index = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return index;

  }

  static int removeDuplicates(int[] array) {
    int index = 0;

    for (int i = index + 1; i < array.length; i++) {
      if (array[index] != array[i]) {
        if (index + 1 != i) {
          array[index + 1] = array[i];
        }
        index++;
      }
    }

    return index;
  }

}
