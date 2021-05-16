package codility;

public class FrogRiverOne {
	public static void main(String[] args) {
		int X = 1;
		int[] A = new int[] { 1};
		System.out.println(new FrogRiverOne().solution(X, A));
	}

	public int solution(int X, int[] A) {
		boolean[] jumpPositions = new boolean[X];
		int positionCnt = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[i] - 1 < X && jumpPositions[A[i] - 1] == false) {
				jumpPositions[A[i] - 1] = true;
				positionCnt++;
				if (positionCnt == X) {
					return i;
				}
			}
		}

		return -1;
	}

}
