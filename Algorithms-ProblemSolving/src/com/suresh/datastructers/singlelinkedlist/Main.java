/**
 * Suresh Y
 */
package com.suresh.datastructers.singlelinkedlist;

import java.util.Arrays;
import java.util.List;

/**
 * @author syerrarapu
 *
 */
public class Main {
  /**
   * 
   */
  
  //######
  public static void  main(String[] args) {
    int size = 5;
    int numberOfBricks = 2;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j <= size - numberOfBricks; j++) {
        System.out.print(" ");
      }
      for (int j = 0; j < numberOfBricks; j++) {
        System.out.print("#");
      }

      numberOfBricks++;
      System.out.println("\n");

    }
  }
}
