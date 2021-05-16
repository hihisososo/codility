package codility;

public class MaxCounters {
	public static void main(String[] args) {
		int N = 5;
		int[] A = new int[] { 3, 4, 4, 6, 1, 4, 4 };

		int[] result = new MaxCounters().solution(N, A);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	public int[] solution(int N, int[] A) {
		int lastNSetIdx = -1;
		for (int i = A.length - 1; i >= 0; i--) {
			if (A[i] == N + 1) {
				lastNSetIdx = i;
				break;
			}
		}

		int[] counters = new int[N];
		int max = 0;
		int lastMax = 0;

		if (lastNSetIdx == -1) {
			for (int i = 0; i < A.length; i++) {
				counters[A[i] - 1]++;
				max = Math.max(max, counters[A[i] - 1]);
			}

		} else {
			for (int i = 0; i <= lastNSetIdx; i++) {
				if (A[i] == N + 1) {
					lastMax = max;
				} else {
					if (counters[A[i] - 1] <= lastMax) {
						counters[A[i] - 1] = lastMax + 1;
					} else {
						counters[A[i] - 1]++;
					}
					max = Math.max(max, counters[A[i] - 1]);
				}
			}

			for (int i = 0; i < counters.length; i++) {
				counters[i] = lastMax;
			}
			for (int i = lastNSetIdx + 1; i < A.length; i++) {
				counters[A[i] - 1]++;
			}
		}

		return counters;
	}
}
