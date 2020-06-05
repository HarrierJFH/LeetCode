package leetcode;

import java.util.Arrays;
import java.util.Random;

public class Problem528 {

    private static class Solution {

        private final int[] a;
        private final int sum;
        private final Random random;

        public Solution(int[] w) {
            a = new int[w.length];
            int sum = 0;
            for (int i = 0; i < w.length; i++) {
                a[i] = sum += w[i];
            }
            this.sum = sum;
            this.random = new Random();
        }

        public int pickIndex() {
            return locate(random.nextInt(sum) + 1);
        }

        private int locate(int n) {
            int l = 0, r = a.length - 1, m;
            while (r > l) {
                m = (l + r) / 2;
                if (n > a[m]) {
                    l = m + 1;
                } else if (n < a[m]) {
                    r = m - 1;
                } else {
                    return m;
                }
            }
            return n > a[l] ? l + 1 : l;
        }
    }

    public static void main(String[] args) {
        int[] w = {1, 2, 3, 4, 5};
        Solution solution = new Solution(w);
        int[] ints = new int[w.length];
        for (int i = 0; i < 15000000; i++) {
            ints[solution.pickIndex()]++;
        }
        System.out.println(Arrays.toString(ints));
        for (int i = 1; i <= 15; i++) {
            System.out.println(solution.locate(i));
        }
    }

}
