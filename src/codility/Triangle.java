package codility;

import java.util.Arrays;

public class Solution {

  public static void main(String[] args) {
    int[] A = new int[]{10, 50,5,1};
    System.out.println(new Solution().solution(A));
  }

  public int solution(int[] A) {
    Arrays.sort(A);
    for (int i = 0; i < A.length - 2; i++) {
      if (check(A[i], A[i + 1], A[i + 2])) {
        return 1;
      }
    }
    return 0;
  }

  private boolean check(int p, int q, int r) {
    if (p + q > r && q + r > p && r + p > q) {
      return true;
    }
    return false;
  }
}
