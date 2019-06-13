/**
 * Suresh Y
 */
package com.suresh.java.bitset;

import java.util.stream.*;

/**
 * Count number of bits in given number;
 * 
 * @author syerrarapu
 *
 */
public class CountBits {

  public static int countBitsNaive(int n) {
    int count = 0;

    while (n != 0) {
      count += n & 1;
      n = n >> 1;
    }

    return count;
  }

  public static int countBitsInJava(int n) {
    return Integer.bitCount(n);
  }

  public static void main(String[] args) {
    long count = Stream.generate(Math::random).map(n -> (int) (n * 100)).limit(10)
        .filter(n -> countBitsInJava(n) == countBitsNaive(n)).count();
    System.out.println(count);

  }

}
