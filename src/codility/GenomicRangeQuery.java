package codility;

import java.util.HashMap;

public class GenomicRangeQuery {

	public static void main(String[] args) {
		String S = "CAGCCTA ";
		int[] P = new int[] { 2,5,0 };
		int[] Q = new int[] { 4,5,6 };

		int[] result = new GenomicRangeQuery().solution(S, P, Q);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	public int[] solution(String S, int[] P, int[] Q) {
		int[] result = new int[P.length];
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 1);
		map.put('C', 2);
		map.put('G', 3);
		map.put('T', 4);

		int[] A = new int[S.length()+1];
		int[] C = new int[S.length()+1];
		int[] G = new int[S.length()+1];
		int[] T = new int[S.length()+1];
		int ACnt = 0;
		int CCnt = 0;
		int GCnt = 0;
		int TCnt = 0;
		for (int i = 0; i < S.length(); i++) {
			switch (S.charAt(i)) {
			case 'A':
				ACnt++;
				break;
			case 'C':
				CCnt++;
				break;
			case 'G':
				GCnt++;
				break;
			case 'T':
				TCnt++;
				break;
			}

			A[i+1] = ACnt;
			C[i+1] = CCnt;
			G[i+1] = GCnt;
			T[i+1] = TCnt;

		}

		for (int i = 0; i < P.length; i++) {
			int start = P[i];
			int end = Q[i];
			
			if(start == end) {
				result[i] = map.get(S.charAt(start));
				continue;
			}

			if (A[end+1] - A[start] > 0) {
				result[i] = 1;
			} else if (C[end+1] - C[start] > 0) {
				result[i] = 2;
			} else if (G[end+1] - G[start] > 0) {
				result[i] = 3;
			} else {
				result[i] = 4;
			}
		}

		return result;
	}
}
