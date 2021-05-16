package codility;

public class TapeEquilibrium {
	public static void main(String[] args) {
		int[] A = new int[] { 3,1,2,4,3 };
		System.out.println(new TapeEquilibrium().solution(A));
	}

	public int solution(int[] A) {
		if (A.length == 0) {
			return 0;
		}

		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}

		int min = Integer.MAX_VALUE;
		int sumLeft = 0;
		int sumRight = sum;
		for (int tape = 1; tape < A.length; tape++) {
			sumLeft += A[tape - 1];
			sumRight -= A[tape - 1];
			min = Math.min(min, Math.abs(sumLeft - sumRight));
		}
		
		return min;
	}

}
