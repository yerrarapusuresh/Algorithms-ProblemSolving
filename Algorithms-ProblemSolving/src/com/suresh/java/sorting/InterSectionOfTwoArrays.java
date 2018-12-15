package com.suresh.java.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * finding intersection of two arrays.
 * 
 * @author Suresh Y
 *
 */
public class InterSectionOfTwoArrays {

  public static void main(String[] args) {
    System.out.println("Hello, World");
  }

  /**
   * it will return the common elements in both array.
   * 
   * @param arrayOne
   *          input array one.
   * @param arrayTwo
   *          input array two.
   * @return
   */
  public static int[] intersectionOfTwoArrays(int[] arrayOne, int[] arrayTwo) {
    List<Integer> list = new ArrayList<Integer>();
    int i = 0;
    int j = 0;
    while (i < arrayOne.length && j < arrayTwo.length) {
      if (arrayOne[i] == arrayTwo[j]) {
        list.add(arrayOne[i]);
        i++;
        j++;
      } else if (arrayOne[i] < arrayTwo[j]) {
        i++;
      } else {
        j++;
      }
    }

    return list.stream().mapToInt(Integer::intValue).toArray();
  }

}
