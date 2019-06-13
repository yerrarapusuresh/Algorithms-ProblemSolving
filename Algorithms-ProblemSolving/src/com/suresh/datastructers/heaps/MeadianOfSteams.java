/**
 * Suresh Y
 */
package com.suresh.datastructers.heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author syerrarapu
 *
 */
public class MeadianOfSteams {

  /**
   * @param args
   */
  public static void main(String[] args) {
    MeadianOfSteams meadianOfSteams = new MeadianOfSteams();
    meadianOfSteams.meadinOfStream();

  }

  public void meadinOfStream() {

    // assume we are reading input stream of infinate integers
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new descOrder());

    List<Integer> list = Arrays.asList(1, 0, 3, 5, 2, 0, 1);
    for (int inputNumber : list) {

      if (maxHeap.isEmpty()) {
        maxHeap.add(inputNumber);
      } else {
        if (inputNumber <= maxHeap.peek()) {
          maxHeap.add(inputNumber);
        } else {
          minHeap.add(inputNumber);
        }
      }

      if (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
        if (maxHeap.size() > minHeap.size()) {
          minHeap.add(maxHeap.poll());
        } else {
          maxHeap.add(minHeap.poll());
        }
      }

      if (minHeap.size() == maxHeap.size()) {
        System.out.println("average median " + (maxHeap.peek() + minHeap.peek()) / 2.0);
      } else if (minHeap.size() > maxHeap.size()) {
        System.out.println("average median " + minHeap.peek());
      } else {
        System.out.println("average median " + maxHeap.peek());
      }
    }

  }

  private static class descOrder implements Comparator<Integer> {

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    @Override
    public int compare(Integer one, Integer two) {
      if (one < two) {
        return 1;
      } else if (one > two) {
        return -1;
      }
      return 0;
    }
  }

  // create two priority queues 1. minHeap 2.maxHeap
  // if maxheap is null
  // store it in
  // else
  // if input element is greater than maxheap
  // store it in minheap
  // else
  // store it in maxheap

  // now equlize the both heaps
  // if(math.abs(minHeap.size()-maxheap.size()) > 1)
  // if(minHeaps.size() > maxheap.size()) {
  // take first element of the store minheap in maxheap
  // esle
  // take first element of the maxheap and store it in minheap

  // if both size equal print avg of both peeks
  // else if min heap grater than maxheap print maxheap
  // print maxheap
  // }
}
