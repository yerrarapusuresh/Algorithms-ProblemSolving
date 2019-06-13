/**
 * Suresh Y
 */
package com.suresh.datastructers.dp;

/**
 * @author syerrarapu
 *
 */
public class StairCaseProblem {

  /**
   * @param args
   */
  public static void main(String[] args) {
    stepPerms(5);

  }

  // Complete the stepPerms function below.
  static int stepPermsHelper(int n) {
    if (n < 0) {
      return 0;
    }
    if (n == 0) {
      return 1;
    }

    return stepPermsHelper(n - 1) + stepPermsHelper(n - 2) + stepPermsHelper(n - 3);

  }

  static int stepPerms(int n) {
    if (n == 0) {
      return 0;
    }
    if (n <= 3) {
      return stepPermsHelper(n);
    }
    int[] array = new int[n];
    array[0] = stepPermsHelper(1);
    array[1] = stepPermsHelper(2);
    array[2] = stepPermsHelper(3);
    for (int i = 3; i < array.length; i++) {
      array[i] = array[i - 1] + array[i - 2] + array[i - 3];
    }

    return array[array.length - 1];
  }

}
