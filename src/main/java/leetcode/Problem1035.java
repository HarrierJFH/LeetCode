package leetcode;

public class Problem1035 {

    public int maxUncrossedLines(int[] A, int[] B) {
        int[] longest = new int[A.length];
        int lastBefore, lastAfter, current, t, c;
        for (int i = B.length - 1; i >= 0; i--) {
            c = B[i];
            lastBefore = 0;
            lastAfter = 0;
            for (int j = A.length - 1; j >= 0; j--) {
                t = longest[j];
                current = Math.max(t, lastAfter);
                if (A[j] == c) {
                    current = Math.max(1 + lastBefore, current);
                }
                lastBefore = t;
                lastAfter = current;
                longest[j] = current;
            }
        }
        return longest[0];
    }

    public static void main(String[] args) {
        Problem1035 problem = new Problem1035();
        System.out.println(problem.maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));
        System.out.println(problem.maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}));
    }

}
