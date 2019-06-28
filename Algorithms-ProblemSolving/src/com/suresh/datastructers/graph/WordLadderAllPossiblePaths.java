/**
 * Suresh Y
 */
package com.suresh.datastructers.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * @author syerrarapu
 *
 */
public class WordLadderAllPossiblePaths {

  public static void main(String[] args) {
    String str = "bb aa bb ba ab aa ab bb aa aa ab bb ba aa ba ab ba ab ab aa bb ab aa aa ba bb ab ba ab aa aa aa ba ab ab aa aa ab ba ba bb";
    String[] strArray = str.split(" ");
    ArrayList<String> list = new ArrayList<>();
    for (String s : strArray) {
      list.add(s);
    }
    System.out.println(ladderLength("bb", "bb", list));
  }

  public static ArrayList<ArrayList<String>> ladderLength(String start, String end,
      ArrayList<String> dictV) {
    ArrayList<ArrayList<String>> result = new ArrayList<>();
    if (start.equals(end)) {
      ArrayList<String> list = new ArrayList<>();
      list.add(start);
      result.add(list);
      return result;
    }
    HashSet<String> set = new HashSet<>(dictV);
    dictV.clear();
    dictV.addAll(set);

    Map<String, Integer> map = new HashMap<String, Integer>();
    for (int i = 0; i < dictV.size(); i++) {
      map.put(dictV.get(i), i);
    }
    Graph g = new Graph(dictV.size());

    for (int i = 0; i < dictV.size(); i++) {
      for (int j = i + 1; j < dictV.size(); j++) {
        if (diffOfTwoWordIsOne(dictV.get(i), dictV.get(j))) {
          g.addEdge(i, j);
        }
      }
    }

    BFS bfs = new BFS(g, map.get(start), map.get(end));
    List<List<Integer>> list = bfs.getListOfLists();

    for (int i = 0; i < list.size(); i++) {
      ArrayList<String> temp = new ArrayList<>();
      for (int j = list.get(i).size() - 1; j >= 0; j--) {
        temp.add(dictV.get(list.get(i).get(j)));
      }
      result.add(temp);
    }

    return result;
  }

  static boolean diffOfTwoWordIsOne(String one, String two) {
    int nonMatchCount = 0;
    for (int i = 0; i < one.length(); i++) {
      if (one.charAt(i) != two.charAt(i)) {
        nonMatchCount++;
      }
      if (nonMatchCount > 1) {
        return false;
      }
    }
    return true;
  }

  static class BFS {
    private Queue<Integer> queue;
    private int[] distance;
    private int[] fromVertex;
    private boolean[] visited;
    private int origin;
    private List<List<Integer>> listOfList = null;

    public BFS(Graph g, int origin, int end) {
      this.origin = origin;
      distance = new int[g.getVertexSize()];
      fromVertex = new int[g.getVertexSize()];
      visited = new boolean[g.getVertexSize()];
      queue = new LinkedList<Integer>();
      listOfList = new ArrayList<>();
      processGraph(g, origin);
      int dis = distance[end];
      for (int i = 0; i < g.getVertexSize(); i++) {
        distance[i] = 0;
        fromVertex[i] = 0;
        visited[i] = false;
      }

      processGraph(g, origin, end, dis);
    }

    public List<List<Integer>> getListOfLists() {
      return listOfList;
    }

    /**
     * @param g
     * @param origin2
     * @param end
     * @param dis
     */
    private void processGraph(Graph g, int origin, int end, int dis) {
      queue.add(origin);
      visited[origin] = true;
      while (!queue.isEmpty()) {
        int dequeue = queue.poll();
        for (int i : g.getAdjList(dequeue)) {
          if (!visited[i]) {
            distance[i] = distance[origin] + 1;
            fromVertex[i] = origin;
            visited[i] = true;
            if (i == end && distance[i] == dis) {
              List<Integer> list = getPath(i);
              listOfList.add(list);
              visited[i] = false;
              break;
            }
            processGraph(g, i, end, dis);
          }
        }
      }
      visited[origin] = false;
    }

    /**
     * @param g
     * @param origin2
     */
    private void processGraph(Graph g, int origin) {
      visited[origin] = true;
      distance[origin] = 0;
      queue.add(origin);
      while (!queue.isEmpty()) {
        int dequeuedItem = queue.poll();
        for (int adj : g.getAdjList(dequeuedItem)) {
          if (!visited[adj]) {
            distance[adj] = distance[dequeuedItem] + 1;
            visited[adj] = true;
            fromVertex[adj] = dequeuedItem;
            queue.add(adj);
          }
        }
      }
    }

    public double getDistance(int v) {
      if (!visited[v])
        return Double.POSITIVE_INFINITY;
      return distance[v];
    }

    public List<Integer> getPath(int v) {
      if (!visited[v])
        return null;
      Stack<Integer> list = new Stack<>();
      list.add(v);
      while (fromVertex[v] != origin) {
        v = fromVertex[v];
        list.push(v);
      }
      list.add(origin);
      return list;
    }
  }

  static class Graph {
    private final int vertexSize;
    private int edgeSize;
    private List<Integer>[] adjList;

    public Graph(int vertexSize) {
      this.vertexSize = vertexSize;
      adjList = (List<Integer>[]) new List[vertexSize];
      for (int i = 0; i < vertexSize; i++) {
        adjList[i] = new ArrayList<>();
      }

    }

    public int getVertexSize() {
      return vertexSize;
    }

    public int getEdgeSize() {
      return edgeSize;
    }

    public Iterable<Integer> getAdjList(int i) {
      return adjList[i];
    }

    public void addEdge(int v, int u) {
      adjList[v].add(u);
      adjList[u].add(v);
      edgeSize++;
    }

    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append(" " + vertexSize + "" + edgeSize + "\n");
      for (int i = 0; i < vertexSize; i++) {
        sb.append(i + ": ");
        for (int adj : adjList[i]) {
          sb.append(" " + adj);
        }
        sb.append("\n");
      }
      return sb.toString();
    }
    
    static int minimumAbsoluteDifference(int[] arr) {
      Arrays.sort(arr);
      int min = Integer.MAX_VALUE;
      for(int i = 1; i < arr.length; i++) {
          int currentMin = Math.abs(arr[i-1] - arr[i]);
          if(currentMin < min) min = currentMin;
      }
      return min;
  }

  }

}
