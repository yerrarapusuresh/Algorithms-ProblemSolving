/**
 * Suresh Y
 */
package com.suresh.datastructers.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author syerrarapu
 *
 */
public class WordLadderTwo {

  public static void main(String[] args) {

    String str = "baba abba aaba bbbb abaa abab aaab abba abba abba bbba aaab abaa baba baaa bbaa babb bbaa babb";
    String[] strArray = str.split(" ");
    ArrayList<String> list = new ArrayList<>();
    for (String s : strArray) {
      list.add(s);
    }
    System.out.println(ladderLength("bbaa", "babb", list));
  }

  public static int ladderLength(String start, String end, ArrayList<String> dictV) {
    int n = dictV.size();
    if (start.equals(end))
      return 1;
    boolean visit[] = new boolean[n];
    int[] from = new int[n];
    Queue<Pair> q = new LinkedList<>();
    Pair p = new Pair(start, 1, 9999);
    q.add(p);

    while (q.isEmpty() == false) {
      String current = q.peek().word;
      int prev = q.peek().prev;
      int length = q.poll().length;
      int index = 0;

      for (int i = 0; i < dictV.size(); i++) {
        if (visit[index] == false && isAdjacent(current, dictV.get(i))) {
          Pair p_new = new Pair(dictV.get(i), length + 1, i);
          q.add(p_new);
          visit[index] = true;
          from[i] = prev;
          if (dictV.get(i).equals(end)) {
            while (i != 9999) {
              System.out.println(dictV.get(i));
              i = from[i];
            }

            return length + 1;
          }
        }
        index++;
      }
    }
    return 0;

  }

  public static boolean isAdjacent(String a, String b) {
    if (a.length() != b.length())
      return false;
    int count = 0;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) != b.charAt(i))
        count++;
    }
    return count == 1;
  }
}

class Pair {
  String word;
  int length;
  int prev;

  Pair(String w, int l, int prev) {
    word = w;
    length = l;
    this.prev = prev;
  }
}
