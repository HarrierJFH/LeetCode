package leetcode;

import java.util.Arrays;

public class Problem986 {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int la = A.length, lb = B.length;
        int[][] result = new int[la + lb][2];
        int m, n, ia = 0, ib = 0, ir = 0;
        while (ia < la && ib < lb) {
            m = Math.max(A[ia][0], B[ib][0]);
            n = Math.min(A[ia][1], B[ib][1]);
            if (m <= n) {
                result[ir++] = new int[]{m, n};
            }
            if (A[ia][1] > B[ib][1]) {
                ib++;
            } else if (A[ia][1] < B[ib][1]) {
                ia++;
            } else {
                ia++;
                ib++;
            }
        }
        return Arrays.copyOf(result, ir);
    }

    public static void main(String[] args) {
        Problem986 problem = new Problem986();
        System.out.println(Arrays.deepToString(problem.intervalIntersection(
                new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}})));
    }

}
