/**
 * Suresh Y
 */
package com.suresh.java.hackerrank.sort;

import java.util.Arrays;

/**
 * @author syerrarapu
 *
 */
public class FraudulentActivityNotifications {

  // Complete the activityNotifications function below.
  static int activityNotifications(int[] expenditure, int d) {
    int numberOfAlerts = 0;
    boolean isEven = d % 2 == 0 ? true : false;
    for (int i = d; i < expenditure.length; i++) {
      Arrays.sort(expenditure, i - d, i);
      if (isEven) {
        int index = i / 2;
        int median = (expenditure[index] + expenditure[index + 1]) / 2;
        if (expenditure[i ] >= median * 2) {
          numberOfAlerts++;
        }
      } else {
        int index = i / 2;
        if (expenditure[i] >= expenditure[index] * 2) {
          numberOfAlerts++;
        }

      }

    }

    return numberOfAlerts;

  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    int[] array = { 3, 2, 1, 4 };
    activityNotifications(array, 3);
  }

}
