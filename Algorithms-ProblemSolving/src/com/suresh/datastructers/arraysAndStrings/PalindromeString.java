/**
 * Suresh Y
 */
package com.suresh.datastructers.arraysAndStrings;

/**
 * @author syerrarapu
 *
 */
public class PalindromeString {

  /**
   * @param args
   */
  public static void main(String[] args) {
   System.out.println(validIp("race a car"));

  }

  public static int validIp(String input) {
    if (input == null || input.length() == 0) {
      return 0;
    }
    int i = -1;
    int j = input.length();
    while (true) {
      i++;
      while (i < j && !Character.isLetterOrDigit(input.charAt(i))) {
        i++;
      }
      j--;
      while (i < j && !Character.isLetterOrDigit(input.charAt(j))) {
        j--;
      }
      if (i > j) {
        break;
      }
      if (Character.toLowerCase(input.charAt(i)) != Character.toLowerCase(input.charAt(j))) {
        return 0;
      }
    }
    return 1;
  }

}
