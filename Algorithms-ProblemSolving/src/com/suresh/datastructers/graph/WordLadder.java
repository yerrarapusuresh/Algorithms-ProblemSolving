/**
 * Suresh Y
 */
package com.suresh.datastructers.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * @author syerrarapu
 *
 */
public class WordLadder {

  public static void main(String[] args) {

    String str = "hot dot dog lot log hit cog";
    String[] strArray = str.split(" ");
    ArrayList<String> list = new ArrayList<>();
    for (String s : strArray) {
      list.add(s);
    }
    System.out.println(ladderLength("hit", "cog", list));
  }

  public static int ladderLength(String start, String end, ArrayList<String> dictV) {

    Map<String, Integer> map = new HashMap<String, Integer>();
    for (int i = 0; i < dictV.size(); i++) {
      map.put(dictV.get(i), i);
    }
    Graph g = new Graph(dictV.size());

    for (int i = 0; i < dictV.size(); i++) {
      for (int j = i + 1; j < dictV.size(); j++) {
        if (diffOfTwoWordIsOne(dictV.get(i), dictV.get(j))) {
          g.addEdge(i, j);
          // System.out.println(dictV.get(j) + " " + dictV.get(i));
        }
      }
    }

    BFS bfs = new BFS(g, map.get(start));
    double dis = bfs.getDistance(map.get(end));
    System.out.println("-------------");
    for (int i : bfs.getPath(map.get(end))) {
      System.out.println(dictV.get(i));
    }

    return (int) (dis == 0 ? 0 : dis + 1);
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

    public BFS(Graph g, int origin) {
      this.origin = origin;
      distance = new int[g.getVertexSize()];
      fromVertex = new int[g.getVertexSize()];
      visited = new boolean[g.getVertexSize()];
      queue = new LinkedList<Integer>();
      processGraph(g, origin);
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

    public Iterable<Integer> getPath(int v) {
      if (!visited[v])
        return null;
      Stack<Integer> list = new Stack<>();
      list.add(v);
      while (fromVertex[v] != origin) {
        v = fromVertex[v];
        list.add(v);
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

  }

}
