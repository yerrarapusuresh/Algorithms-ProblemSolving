package com.suresh.java.test.sorting;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.suresh.java.sorting.InterSectionOfTwoArrays;

/** test cases for InterSectionOfTwoArrays.
 * @author syerrarapu
 *
 */
class InterSectionOfTwoArraysTest {



  @Test
  void testOne() {
    int[] arrayOne = { 1, 2, 3, 4, 5, 6 };
    int[] arrayTwo = { 4, 5, 6 };
    int[] expected = { 4, 5, 6 };
    int[] result = InterSectionOfTwoArrays.intersectionOfTwoArrays(arrayOne, arrayTwo);
    Assert.assertArrayEquals(result, expected);
  }

  @Test
  void testTwo() {
    int[] arrayOne = { 1, 2, 3, 4, 5, 6 };
    int[] arrayTwo = { 4, 5, 6, 7 };
    int[] expected = { 4, 5, 6 };
    int[] result = InterSectionOfTwoArrays.intersectionOfTwoArrays(arrayOne, arrayTwo);
    Assert.assertArrayEquals(result, expected);
  }

  @Test
  void testThree() {
    int[] arrayOne = { 1 };
    int[] arrayTwo = { 4, 5, 6, 7 };
    int[] expected = {};
    int[] result = InterSectionOfTwoArrays.intersectionOfTwoArrays(arrayOne, arrayTwo);
    Assert.assertArrayEquals(result, expected);
  }

  @Test
  void testFour() {
    int[] arrayOne = { 1, 2 };
    int[] arrayTwo = { 4, 5, 6, 7 };
    int[] expected = {};
    int[] result = InterSectionOfTwoArrays.intersectionOfTwoArrays(arrayOne, arrayTwo);
    Assert.assertArrayEquals(result, expected);
  }

  @Test
  void testFive() {
    int[] arrayOne = { 1, 2, 3, 4, 5, 6, 7 };
    int[] arrayTwo = { 1, 2, 3, 4, 5, 6, 7 };
    int[] expected = { 1, 2, 3, 4, 5, 6, 7 };
    int[] result = InterSectionOfTwoArrays.intersectionOfTwoArrays(arrayOne, arrayTwo);
    Assert.assertArrayEquals(result, expected);
  }


}
