/**
 * Suresh Y
 */
package com.suresh.datastructers.dictionaries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author syerrarapu
 *
 */
public class SherlockAndValidStrings {

  // Complete the isValid function below.
  static String isValid(String s) {

    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }

    Map<Integer, List<Character>> valueToKey = new HashMap<>();
    for (Entry<Character, Integer> entry : map.entrySet()) {
      Integer value = entry.getValue();
      if (valueToKey.containsKey(value)) {
        valueToKey.get(value).add(entry.getKey());
      } else {
        List<Character> list = new ArrayList<>();
        list.add(entry.getKey());
        valueToKey.put(value, list);
      }

      if (valueToKey.size() > 2) {
        return "NO";
      }

    }

    if (valueToKey.size() == 1) {
      return "YES";
    }
    List<Character> listOne = null;
    List<Character> listTwo = null;
    boolean check = true;
    for (Entry<Integer, List<Character>> entry : valueToKey.entrySet()) {
      if (check) {
        listOne = entry.getValue();
        check = false;
      } else {
        listTwo = entry.getValue();
      }

    }

    if (listOne.size() > listTwo.size()) {
      if (listTwo.size() > 1) {
        return "NO";
      } else {
        char c2 = listTwo.get(0);
        char c1 = listOne.get(0);
        int i1 = map.get(c2);
        int i2 = map.get(c1);
        if (Math.abs(i1 - i2) != 1) {
          return "NO";
        }

      }

    } else if (listOne.size() < listTwo.size()) {
      if (listOne.size() > 1) {
        return "NO";
      } else {
        char c2 = listTwo.get(0);
        char c1 = listOne.get(0);
        int i1 = map.get(c2);
        int i2 = map.get(c1);
        if (Math.abs(i2 - i1) != 1) {
          return "NO";
        }

      }

    } else {
      return "NO";
    }

    return "YES";

  }

  public static void main(String[] args) {

    System.out.println(isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd"));
  }

}

/*
 * 
 * 
 * 
 * 
 * 
 * set.add(i); if(set.size() > 2) return "NO";
 * 
 * if(set.size() == 2)) { int[] array = set.stream().mapToInt(x ->x).toArray(); if(Math.abs(array[0]
 * - array[1]) > 1) { return "NO"; } }
 * 
 * 
 * 
 * 
 * 
 */
