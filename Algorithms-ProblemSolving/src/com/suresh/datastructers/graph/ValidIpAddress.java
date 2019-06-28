/**
 * Suresh Y
 */
package com.suresh.datastructers.graph;

import java.util.ArrayList;

/**
 * @author syerrarapu
 *
 */
public class ValidIpAddress {

  /**
   * @param args
   */
  public static void main(String[] args) {
    for (String s : validIpAddress("0100100")) {
      System.out.println(s);
    }

  }// 1 1 1 12, 11 1 1 2,

  public static ArrayList<String> validIpAddress(String input) {
    if (input == null || input.length() == 0) {
      return null;
    }
    ArrayList<String> result = new ArrayList<>();
    validIPAddessHelper(input, 0, 0, "", result);
    return result;
  }

  /**
   * @param input
   * @param i
   * @param j
   * @param stringBuffer
   * @param arrayList
   * @return
   */
  private static void validIPAddessHelper(String input, int index, int partation, String current,
      ArrayList<String> arrayList) {

    if (index == input.length()) {
      if (partation == 4) {

        arrayList.add(current.substring(0, current.length() - 1));
      }
      return;
    }

    for (int i = index + 1; i <= input.length(); i++) {
      String temp = input.substring(index, i);
      if (temp.length() > 1) {
        if (temp.charAt(0) == '0') {
          continue;
        }
      }
      if (Long.parseLong(temp) <= 255) {

        validIPAddessHelper(input, i, partation + 1, current + input.substring(index, i) + ".",
            arrayList);

      }
    }
  }

}
