/**
 * Suresh Y
 */
package com.suresh.datastructers.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author syerrarapu
 *
 */
public class LargetBitwenTwoNodesSol {
  static int n;
  static ArrayList<ArrayList<Integer>> graph;

  public static void main(String[] args) {
    int[] array = { -1, 0, 1, 1, 2, 0, 5, 0, 3, 0, 0, 2, 3, 1, 12, 14, 0, 5, 9, 6, 16, 0, 13, 4, 17,
        2, 1, 22, 14, 20, 10, 17, 0, 32, 15, 34, 10, 19, 3, 22, 29, 2, 36, 16, 15, 37, 38, 27, 31,
        12, 24, 29, 17, 29, 32, 45, 40, 15, 35, 13, 25, 57, 20, 4, 44, 41, 52, 9, 53, 57, 18, 5, 44,
        29, 30, 9, 29, 30, 8, 57, 8, 59, 59, 64, 37, 6, 54, 32, 40, 26, 15, 87, 49, 90, 6, 81, 73,
        10, 8, 16 };
    ArrayList<Integer> temp = new ArrayList<>();
    for (int i : array) {
      temp.add(i);
    }
    System.out.println(solve(temp));

  }

  public static int solve(ArrayList<Integer> a) {
    n = a.size();

    if (n == 1) {
      return 0;
    }

    graph = new ArrayList<>(n);
    for (int index = 0; index < n; index++) {
      graph.add(new ArrayList<Integer>());
    }

    for (int index = 0; index < n; index++) {
      final int parent = a.get(index);
      if (parent == -1) {
        continue;
      }
      graph.get(index).add(parent);
      graph.get(parent).add(index);
    }

    final int v = findFurthest(0)[0];
    return findFurthest(v)[1];
  }

  private static int[] findFurthest(int start) {
    final boolean[] marked = new boolean[n];
    Deque<Integer> level = new LinkedList<>();

    marked[start] = true;
    level.add(start);
    int dist = 0;

    while (true) {
      final Deque<Integer> nextLevel = new LinkedList<>();

      for (int i : level) {
        for (int j : graph.get(i)) {
          if (!marked[j]) {
            marked[j] = true;
            nextLevel.add(j);
          }
        }
      }

      if (nextLevel.isEmpty()) {
        return new int[] { level.getLast(), dist };
      }

      level = nextLevel;
      dist++;
    }
  }
}
