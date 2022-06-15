package codility;

public class NumberOfDiscIntersections {

  public static void main(String[] args) {
    int[] A = new int[]{1, 5, 2, 1, 4, 0};
    System.out.println(new NumberOfDiscIntersections().solution(A));
  }

  public int solution(int[] A) {
    int cnt = 0;
    for (int i = 0; i < A.length; i++) {
      for (int j = i+1; j < A.length; j++) {
        int distance = j - i;
        if (A[i] + A[j] >= distance) {
          cnt++;
        }
      }
    }
    return cnt;
  }
}
