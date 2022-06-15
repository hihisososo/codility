package codility;

import java.util.HashMap;
import java.util.Map;
class OddOccurrencesInArray {
    public static void main(String[] args) {
        int[] A = new int[]{9, 3, 9, 3, 9, 7, 9};
        System.out.println(new OddOccurrencesInArray().solution(A));
    }

    public int solution(int[] A) {
        HashMap<Integer, Integer> cntMap = new HashMap<>();
        for (int i : A) {
            cntMap.merge(i, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> e : cntMap.entrySet()) {
            if (e.getValue() % 2 == 1) {
                return e.getKey();
            }
        }
        return -1;
    }
}

