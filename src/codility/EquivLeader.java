package codility;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class EquivLeader {

  public static void main(String[] args) {
    int[] A = new int[]{4, 3, 4, 4, 4, 2};
    System.out.println(new EquivLeader().solution(A));
  }

  public int solution(int[] A) {
    HashMap<Integer, Integer> cntMap = new HashMap<>();
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    HashMap<Integer, Integer> leftLeaderIdxMap = new HashMap<>();

    for (int i = 0; i < A.length; i++) {
      cntMap.merge(A[i], 1, Integer::sum);
      queue.add(cntMap.get(A[i]));
      if (queue.peek() > (i + 1) / 2) {
        leftLeaderIdxMap.put(i, queue.peek());
      }
      System.out.println(leftLeaderIdxMap);

      cntMap.clear();
      lastLeader = -1;
      for (int i = A.length - 1; i > 0; i--) {
        cntMap.merge(A[i], 1, Integer::sum);
        if (cntMap.get(A[i]) > (A.length - i) / 2) {
          rightLeaderIdxMap.put(i, A[i]);
          lastLeader = A[i];
        } else if (lastLeader > (A.length - i) / 2) {
          rightLeaderIdxMap.put(i, lastLeader);
        }
      }

      int equivCnt = 0;
      for (Entry<Integer, Integer> e : leftLeaderIdxMap.entrySet()) {
        if (rightLeaderIdxMap.get(e.getKey() + 1) == e.getValue()) {
          equivCnt++;
        }
      }

      return equivCnt;
    }

  }
