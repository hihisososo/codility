package codility;

public class CountDiv {
	public static void main(String[] args) {
		int A = 6;
		int B = 12;
		int K = 2;
		System.out.println(new CountDiv().solution(A, B, K));
	}

	public int solution(int A, int B, int K) {
		int firstDivisibleNum = findFirstDivisibleNum(A, B, K);
		if (firstDivisibleNum < 0) {
			return 0;
		}

		int distance = B - firstDivisibleNum;
		return distance / K + 1;

	}

	private int findFirstDivisibleNum(int A, int B, int K) {

		int remnant = A % K;
		if (remnant == 0) {
			return A;
		}
		int result = A + K - remnant;
		if (result > B) {
			return -1;
		} else {
			return result;
		}
	}
}
