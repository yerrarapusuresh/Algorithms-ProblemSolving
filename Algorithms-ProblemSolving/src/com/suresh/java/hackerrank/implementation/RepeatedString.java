package com.suresh.java.hackerrank.implementation;

import java.io.IOException;
import java.util.Scanner;

public class RepeatedString {

  // Complete the repeatedString function below.
  static long repeatedString(String s, long n) {

    if (s == null || s.length() == 0) {
      return 0;
    }
    int count = 0;
    int belowRemainder = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'a') {
        count++;
        if (i < (n % s.length())) {
          belowRemainder = count;
        }
      }
      if (i == n) {
        return count;
      }

    }
    return ((n / s.length()) * count) + belowRemainder;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    String s = "aba";
    System.out.println(repeatedString(s, 10));
  }
}
