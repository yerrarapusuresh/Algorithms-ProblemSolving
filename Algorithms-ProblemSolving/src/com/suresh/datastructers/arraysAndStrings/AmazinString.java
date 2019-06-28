/**
 * Suresh Y
 */
package com.suresh.datastructers.arraysAndStrings;

/**
 * @author syerrarapu
 *
 */
public class AmazinString {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    solveAmazingString("ABEC");
  }

  public static int solveAmazingString(String input) {
    if (input == null || input.length() == 0) {
      return 0;
    }
    long result = 0;
    int aeiou = 0;
    aeiou = aeiou | 1 << 'a' - 'a';
    aeiou = aeiou | 1 << 'e' - 'a';
    aeiou = aeiou | 1 << 'i' - 'a';
    aeiou = aeiou | 1 << 'o' - 'a';
    aeiou = aeiou | 1 << 'u' - 'a';
    for (int i = 0; i < input.length(); i++) {
      if ((aeiou & 1 << (Character.toLowerCase(input.charAt(i)) - 'a')) > 0) {
        result = result + (input.length() - i);
        result %= 10003;
      }
    }

    return (int) result;

  }

}
