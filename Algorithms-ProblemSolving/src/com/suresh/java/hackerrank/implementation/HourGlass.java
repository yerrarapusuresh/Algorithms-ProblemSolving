/**
 * Suresh Y
 */
package com.suresh.java.hackerrank.implementation;

/**
 * @author syerrarapu
 *
 */
public class HourGlass {

  public static void main(String[] args) {
    int[][] array = {

        { 1, 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0 }, { 0, 9, 2, -4, -4, 0 },
        { 0, 0, 0, -2, 0, 0 }, { 0, 0, -1, -2, -4, 0 }, };

    System.out.println(hourglassSum(array));
  }

  public static int hourglassSum(int[][] arr) {
    int hourglass = 3;
    int maxvalue = Integer.MIN_VALUE;
    for (int i = 0; i <= (arr.length - hourglass); i++) {
      for (int j = 0; j <= (arr[i].length - hourglass); j++) {
        int hourglassvalue = computeHourGlassHelper(arr, i, j, hourglass);
        if (hourglassvalue > maxvalue) {
          maxvalue = hourglassvalue;
        }

      }

    }

    return maxvalue;
  }

  /**
   * @param arr
   * @param i
   * @param j
   * @param hourglass
   */
  private static int computeHourGlassHelper(int[][] arr, int row, int col, int hourglass) {
    int sum = 0;
    // compute upper row sum of hourglass
    //System.out.println();
    for (int i = col; i < col + hourglass; i++) {
      sum += arr[row][i];
      //System.out.print(" " + arr[row][i]);
    }
    //System.out.println();

   // System.out.println(arr[(row + hourglass) / 2][(col + hourglass) / 2]);
    // compute lower row sum of hourglass
    for (int i = col; i < col + hourglass; i++) {
      sum += arr[row + hourglass - 1][i];
     // System.out.print(" " + arr[row + hourglass - 1][i]);
    }
   // System.out.println();

    // need to compute I-Beam
    sum += arr[row + hourglass / 2][col + hourglass / 2];
  //  System.out.println();
  //  System.out.println(row + " " + col);
  //  System.out.println("----------------------- " + sum);
    return sum;
  }

}
