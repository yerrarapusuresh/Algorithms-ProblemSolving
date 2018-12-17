
package com.suresh.java.test.hackerrank.implementation;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.suresh.java.hackerrank.implementation.EncryptionOfGivenString;

/**
 * Test cases for encryption problem for hackerrank.
 * 
 * @author syerrarapu
 *
 */
class EncryptionOfGivenStringTest {

  @Test
  void testOne() {
    assertTrue(
        EncryptionOfGivenString.encryption("haveaniceday").compareTo("hae and via ecy") == 0);

  }

  @Test
  void testTwo() {
    assertEquals(EncryptionOfGivenString.encryption("feedthedog"), "fto ehg ee dd");

  }

  @Test
  void testThree() {
    assertEquals(EncryptionOfGivenString.encryption("chillout"), "clu hlt io");

  }

}
