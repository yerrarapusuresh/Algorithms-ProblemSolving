
package com.suresh.java.hackerrank.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * This program about implementation of the full counting sort from hackerrank.
 * 
 * @author syerrarapu
 *
 */
public class TheFullCountingSort {

  private static final Scanner scanner = new Scanner(System.in);

  /**
   * to run.
   * 
   * @param args
   *          command line arguments.
   */
  public static void main(String[] args) {

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    Map<Integer, StringBuilder> resultMap = new HashMap<Integer, StringBuilder>();
    int i = 0;
    for (; i < (n / 2); i++) {
      String[] xs = scanner.nextLine().split(" ");
      int x = Integer.parseInt(xs[0]);
      if (resultMap.containsKey(x)) {
        resultMap.get(x).append("- ");
      } else {
        resultMap.put(x, new StringBuilder().append("- "));
      }
    }

    for (; i < n; i++) {
      String[] xs = scanner.nextLine().split(" ");

      int x = Integer.parseInt(xs[0]);

      String s = xs[1];
      if (resultMap.containsKey(x)) {
        resultMap.get(x).append(s + " ");
      } else {
        resultMap.put(x, new StringBuilder().append(s + " "));
      }
    }
    List<Integer> arrayList = new ArrayList<>(resultMap.keySet());
    Collections.sort(arrayList);
    for (Integer itr : arrayList) {
      System.out.print(resultMap.get(itr).toString());
    }

    scanner.close();

  }

}
