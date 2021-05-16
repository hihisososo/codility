package codility;

public class FrogJmp {
	public static void main(String[] args) {
		int X = 10;
		int Y = 85;
		int D = 30;

		System.out.println(new FrogJmp().solution(X, Y, D));

	}

	public int solution(int X, int Y, int D) {
		int distance = Y - X;
		if(distance % D > 0) {
			return distance / D + 1;
		}else {
			return distance / D;
		}
	}
}
