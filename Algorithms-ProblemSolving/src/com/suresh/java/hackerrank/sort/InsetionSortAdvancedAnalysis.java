package com.suresh.java.hackerrank.sort;

/**
 * this program is for insertion sort advanced analysis in hackerrank.
 * 
 * @author syerrarapu
 *
 */
public class InsetionSortAdvancedAnalysis {

  /**
   * main method.
   * 
   * @param args
   *          command line arguments.
   */
  public static void main(String[] args) {
    int[] arrayReverseOrder = new int[] { 2, 1, 3, 1, 2 };
    System.out.println(sort(arrayReverseOrder));
    for (int i : arrayReverseOrder) {
      System.out.println(i);
    }
  }

  /**
   * this is method count inversion.
   * 
   * @param array
   *          input array.
   */
  public static int sort(int[] array) {
    return sort(array, new int[array.length], 0, array.length - 1);
  }

  /**
   * sort implementation.
   * 
   * @param array
   *          input array.
   * @param aux
   *          auxilary array.
   * @param low
   *          starting point in array.
   * @param high
   *          end point in array.
   * @return number of inversion in array. e.g index i is less than j and array[i] > array[j].
   */
  private static int sort(int[] array, int[] aux, int low, int high) {
    if (high <= low) {
      return 0;
    }
    int mid = low + (high - low) / 2;
    int leftInversions = sort(array, aux, low, mid);
    int rightInversions = sort(array, aux, mid + 1, high);
    return leftInversions + rightInversions + merge(array, aux, low, mid, high);
  }

  /**
   * this method is merge part for two sorted array into single sorted array.
   * 
   * @param array
   *          input array.
   * @param aux
   *          auxilary for input array.
   * @param low
   *          starting point of input array.
   * @param mid
   *          mid point of input array.
   * @param high
   *          end point of input array.
   */
  private static int merge(int[] array, int[] aux, int low, int mid, int high) {
    int inversionsCount = 0;

    for (int k = 0; k <= high; k++) {
      aux[k] = array[k];
    }
    int i = low;
    int j = mid + 1;
    for (int k = low; k <= high; k++) {
      if (i > mid) {
        array[k] = aux[j++];
      } else if (j > high) {
        array[k] = aux[i++];
      } else if (aux[j] < aux[i]) {
        inversionsCount += ((mid - i) + 1);
        array[k] = aux[j++];
      } else {
        array[k] = aux[i++];
      }
    }
    return inversionsCount;

  }

}
