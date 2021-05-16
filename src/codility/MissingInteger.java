package codility;

public class MissingInteger {
	public static void main(String[] args) {
		int[] A = new int[] { 1, 3, 6, 4, 1, 2 };
		System.out.println(new MissingInteger().solution(A));
	}

	public int solution(int[] A) {
		int[] array = new int[1000000];
		for (int i = 0; i < A.length; i++) {
			if(A[i] > 0) {
				array[A[i] - 1]++;
			}
			
		}

		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				return i + 1;
			}
		}
		return -1;
	}

}
