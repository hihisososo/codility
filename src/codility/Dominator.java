package codility;

import java.util.HashMap;
import java.util.Map.Entry;

public class Dominator {

  public static void main(String[] args) {
    int[] A = new int[]{3, 4, 3, 2, 3, -1, 3, 3};
    System.out.println(new Dominator().solution(A));
  }

  public int solution(int[] A) {
    if (A.length == 0) {
      return -1;
    }
    HashMap<Integer, Integer> cntMap = new HashMap<>();
    for (int i = 0; i < A.length; i++) {
      cntMap.putIfAbsent(A[i], 0);
      cntMap.put(A[i], cntMap.get(A[i]) + 1);
    }
    for (Entry<Integer, Integer> e : cntMap.entrySet()) {
      if (e.getValue() > A.length / 2) {
        for (int i = 0; i < A.length; i++) {
          if (A[i] == e.getKey()) {
            return i;
          }
        }
      }
    }
    return -1;
  }
}
