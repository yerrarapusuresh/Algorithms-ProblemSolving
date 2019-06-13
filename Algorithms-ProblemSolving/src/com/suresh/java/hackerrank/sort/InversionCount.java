/**
 * Suresh Y
 */
package com.suresh.java.hackerrank.sort;

/**
 * @author syerrarapu
 *
 */
public class InversionCount {

  // Complete the countInversions function below.
  static long countInversions(int[] arr) {
    int[] aux = new int[arr.length];
    return sort(arr, aux, 0, arr.length - 1);
  }

  /**
   * @param arr
   * @param aux
   * @param i
   * @param j
   * @return
   */
  private static long sort(int[] arr, int[] aux, int start, int end) {
    if (start >= end) {
      return 0;
    }
    int mid = start + (end - start) / 2;
    long left = sort(arr, aux, start, mid);
    long right = sort(arr, aux, mid + 1, end);
    long current = merge(arr, aux, start, mid, end);
    return left + right + current;
  }

  /**
   * @param arr
   * @param aux
   * @param start
   * @param mid
   * @param end
   * @return
   */
  private static long merge(int[] arr, int[] aux, int start, int mid, int end) {
    for (int i = start; i <= end; i++) {
      aux[i] = arr[i];
    }
    long inversions = 0;
    int i = start;
    int j = mid + 1;
    for (int k = start; k <= end; k++) {
      if (i > mid) {
        arr[k] = aux[j++];
      } else if (j > end) {
        arr[k] = aux[i++];
      } else if (aux[j] < aux[i]) {
        inversions += (mid + 1) - i;
        arr[k] = aux[j++];

      } else {
        arr[k] = aux[i++];
      }
    }
    return inversions;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    int[] arr = { 4, 3, 2, 1, 0 };
    System.out.println(countInversions(arr));

  }

}
