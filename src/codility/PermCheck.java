package codility;

public class PermCheck {
	public static void main(String[] args) {
		int[] A = new int[] { 4, 1, 3, 2 };
		System.out.println(new PermCheck().solution(A));
	}

	public int solution(int[] A) {
		int[] numArr = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			if (A[i] <= A.length) {
				numArr[A[i] - 1]++;
			}
		}

		for (int i = 0; i < numArr.length; i++) {
			if (numArr[i] == 0) {
				return 0;
			}
		}

		return 1;
	}
}
