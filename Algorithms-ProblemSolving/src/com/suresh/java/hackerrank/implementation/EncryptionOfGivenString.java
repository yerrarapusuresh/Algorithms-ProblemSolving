
package com.suresh.java.hackerrank.implementation;

/**
 * Encrypt a given string in grid format.
 * 
 * @author syerrarapu
 *
 */
public class EncryptionOfGivenString {

  /**
   * method for encryption.
   * 
   * @param s
   *          String.
   * @return it will return encrypted string.
   */
  public static String encryption(String s) {
    String nonWhiteSpaceString = s.replaceAll("\\s+", "");
    double sqrtOfStringLength = Math.sqrt(nonWhiteSpaceString.length());
    int rows = (int) Math.floor(sqrtOfStringLength);
    int cols = (int) Math.ceil(sqrtOfStringLength);
    if ((rows * cols) < nonWhiteSpaceString.length()) {
      if (rows < cols) {
        rows++;
      } else {
        cols++;
      }
    }
    char[][] resultArray = new char[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        int indexValue = ((cols * i) + j);
        if (indexValue < nonWhiteSpaceString.length()) {
          resultArray[i][j] = nonWhiteSpaceString.charAt(indexValue);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < cols; i++) {
      for (int j = 0; j < rows; j++) {
        if ((int) resultArray[j][i] != 0) {
          sb.append(resultArray[j][i]);
        }
      }
      sb.append(" ");
    }
    return sb.toString();

  }

  public static void main(String[] args) {

    encryption("feedthedog");
  }

}
