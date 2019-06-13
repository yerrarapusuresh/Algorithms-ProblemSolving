/**
 * Suresh Y
 */
package com.suresh.java.hackerrank.implementation;

/**
 * @author syerrarapu
 *
 */
public class JumpingOnTheClouds {

  /**
   * @param args
   */
  public static void main(String[] args) {
    int[] array = { 0, 0, 0, 0, 0, 1, 0 };
    System.out.println(jumpingOnClouds(array));
  }

  static int jumpingOnClouds(int[] c) {

    int jumps = 0;
    for (int i = 0; i < c.length;) {
      if ((i + 2 < c.length) && c[i] != 1) {
        jumps++;
        i += 2;
      } else {
        if (i + 1 < c.length)
          jumps++;
        i += 1;
      }
    }
    return jumps;
  }

}
