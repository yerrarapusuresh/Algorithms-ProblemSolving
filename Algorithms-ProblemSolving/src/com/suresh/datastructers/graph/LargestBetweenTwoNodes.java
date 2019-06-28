/**
 * Suresh Yd
 */
package com.suresh.datastructers.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author syerrarapu
 *
 */
public class LargestBetweenTwoNodes {

  static class TreeDistnaceHelperClass implements Comparable<TreeDistnaceHelperClass> {
    int maxDistance;
    int maxHeight;

    public TreeDistnaceHelperClass() {
      this.maxDistance = 0;
      this.maxHeight = 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(TreeDistnaceHelperClass that) {
      if (this.maxHeight < that.maxHeight) {
        return -1;
      } else if (this.maxHeight > that.maxHeight) {
        return 1;
      } else {
        return 0;
      }
    }
  }

  /**
   * @param args
   */
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
    System.out.println(largestBetweenTwoNodes(temp));

  }

  public static int largestBetweenTwoNodes(ArrayList<Integer> array) {
    if (array == null || array.size() == 0) {
      return 0;
    }
    Map<Integer, List<Integer>> map = new HashMap<>();
    int root = 0;
    List<Integer> temp;
    for (int i = 0; i < array.size(); i++) {
      if (array.get(i) == -1) {
        root = i;
        continue;
      } else {
        if (map.containsKey(array.get(i))) {
          map.get(array.get(i)).add(i);
        } else {
          temp = new ArrayList<Integer>();
          temp.add(i);
          map.put(array.get(i), temp);
        }
      }
    }
    return largestBetweenTwoNodesHelper(root, map).maxDistance;
  }

  public static TreeDistnaceHelperClass largestBetweenTwoNodesHelper(int root,
      Map<Integer, List<Integer>> map) {
    if (!map.containsKey(root)) {
      return new TreeDistnaceHelperClass();
    }
    TreeDistnaceHelperClass temp;
    if (map.get(root).size() == 1) {
      temp = largestBetweenTwoNodesHelper(map.get(root).get(0), map);
      temp.maxDistance++;
      temp.maxHeight = Math.max(temp.maxDistance, temp.maxHeight);
      return temp;
    }

    PriorityQueue<TreeDistnaceHelperClass> pq = new PriorityQueue<>();

    for (int i : map.get(root)) {
      temp = largestBetweenTwoNodesHelper(i, map);
      temp.maxHeight++;
      if (pq.size() < 2) {
        pq.add(temp);
      } else {
        if (pq.peek().maxHeight <= temp.maxHeight) {
          pq.poll();
          pq.add(temp);
        }
      }
    }
    temp = pq.poll();
    TreeDistnaceHelperClass tempMaxHeightNode = pq.poll();
    // if ((temp.maxHeight + tempMaxHeightNode.maxHeight) > tempMaxHeightNode.maxDistance) {
    // tempMaxHeightNode.maxDistance = temp.maxHeight + tempMaxHeightNode.maxHeight;
    // }

    TreeDistnaceHelperClass maxDistance = temp.maxDistance > tempMaxHeightNode.maxDistance ? temp
        : tempMaxHeightNode;
    if ((temp.maxHeight + tempMaxHeightNode.maxHeight) > maxDistance.maxDistance) {
      maxDistance.maxDistance = temp.maxHeight + tempMaxHeightNode.maxHeight;
      maxDistance.maxHeight = Math.max(temp.maxHeight, tempMaxHeightNode.maxHeight);
    }
    return maxDistance;
  }

}
