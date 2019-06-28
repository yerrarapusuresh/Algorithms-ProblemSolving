/**
 * Suresh Y
 */
package com.suresh.datastructers.backtracking;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author syerrarapu
 *
 */
public class SudokuSolver {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    int[][] puzzle = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
    sudokuSolver(puzzle);
    System.out.println();

  }

  public static void sudokuSolver(int[][] puzzle) {
    sudokuSolver(puzzle, 0, 3);
  }

  /**
   * @param puzzle
   * @param i
   */
  private static boolean sudokuSolver(int[][] puzzle, int row, int length) {
    if (row == puzzle[0].length) {
      return true;
    }

    boolean[] check = new boolean[puzzle[0].length];
    for (int i = 0; i < puzzle[row].length; i++) {
      if (puzzle[row][i] != 0) {
        check[puzzle[row][i] - 1] = true;
      }
    }

    Deque<Integer> deque = new LinkedList<>();
    for (int i = 0; i < check.length; i++) {
      if (!check[i]) {
        deque.add(i + 1);
      }
    }

    for (int i = 0; i < length; i++) {
      if (puzzle[row][i] == 0) {
        int counter = 0;
        while (counter < deque.size()) {
          int toAddPuzzle = deque.poll();
          puzzle[row][i] = toAddPuzzle;

          if (!checkValid(puzzle, row, i, length)) {

            deque.addLast(toAddPuzzle);
            counter++;
          } else {

            if (sudokuSolver(puzzle, row, length))
              return true;

          }
        }
      }
    }
    sudokuSolver(puzzle, row + 1, length);
    return true;
  }

  private static boolean checkValid(int[][] puzzle, int row, int col, int length) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < length; i++) {
      if (puzzle[row][i] == 0) {
        continue;
      }
      if (set.contains(puzzle[row][i])) {
        return false;
      } else {
        set.add(puzzle[row][i]);
      }
    }

    set.clear();

    for (int i = 0; i < length; i++) {
      if (puzzle[i][col] == 0) {
        continue;
      }
      if (set.contains(puzzle[i][col])) {
        return false;
      } else {
        set.add(puzzle[i][col]);
      }
    }
    return true;
  }
}
