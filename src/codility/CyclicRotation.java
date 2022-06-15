package codility;

import java.util.Arrays;

class CyclicRotation {
    public static void main(String[] args) {
        int[] A = new int[]{3, 8, 9, 7, 6};
        int k = 20;
        System.out.println(Arrays.toString(new CyclicRotation().solution(A, k)));
    }

    public int[] solution(int[] A, int K) {
        if(A.length == 0 || A.length == 1){
            return A;
        }
        int mod = K % A.length;
        int currIdx = 0;
        int prevValue = A[0];
        int orgIdxValue = 0;
        for (int i = 0; i < A.length; i++) {
            int rotateIdx = getRotateIdx(currIdx, mod, A.length);
            orgIdxValue = A[rotateIdx];
            A[rotateIdx] = prevValue;
            prevValue = orgIdxValue;
            currIdx = rotateIdx;
        }

        return A;
    }

    private int getRotateIdx(int currIdx, int rotateSize, int length) {
        if (currIdx + rotateSize >= length) {
            return (currIdx + rotateSize) - length;
        } else {
            return currIdx + rotateSize;
        }
    }
}
