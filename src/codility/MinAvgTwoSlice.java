package codility;

public class MinAvgTwoSlice {
	public static void main(String[] args) {
		int[] A = new int[] { 4, 2, 2, 5, 1, 5, 8 };
		System.out.println(new MinAvgTwoSlice().solution(A));
	}

	public int solution(int[] A) {

		double totalMin = Double.MAX_VALUE;
		int minIdx = -1;
		for (int i = 1; i < A.length - 1; i++) {
			double curAvg = getMin(i, A);
			if (totalMin > curAvg) {
				totalMin = curAvg;
				minIdx = i;
			}
		}

		return minIdx;

	}

	private double getMin(int startIdx, int[] A) {
		int cnt = 2;
		int sum = A[startIdx - 1] + A[startIdx];
		double avg = (sum) / cnt;
		startIdx++;
		cnt++;
		while (startIdx < A.length) {
			if (avg > A[startIdx]) {
				sum += A[startIdx];
				avg = sum / cnt;
				
				startIdx++;
				cnt++;
			} else {
				break;
			}
		}

		return avg;
	}
}
