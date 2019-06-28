/**
 * Suresh Y
 */
package com.suresh.datastructers.graph;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author syerrarapu
 *
 */
public class SmallestMultiple {

  /**
   * @param args
   */
  public static void main(String[] args) {
    multipleOfOneAndTwo(2);

  }

  public static String multipleOfOneAndTwo(int n) {

    Set<String> visited = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    queue.add("" + 1);
    BigInteger source = new BigInteger("" + n);
    while (!queue.isEmpty()) {
      String dequeueItem = queue.poll();

      BigInteger bi = new BigInteger(dequeueItem);

      if (bi.mod(source) == BigInteger.ZERO) {
        return dequeueItem.toString();
      }
      if (!visited.contains(dequeueItem)) {
        visited.add(dequeueItem);
        queue.add(dequeueItem + "0");
        queue.add(dequeueItem + "1");
      }
    }

    return null;
  }

}
