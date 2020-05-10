package leetcode;

import java.util.Arrays;

public class Problem189 {

    public void rotate(int[] nums, int k) {
        int l = nums.length;
        if (l == 1) {
            return;
        }
        k = k % l;
        if (k == 0) {
            return;
        }
        int j, m, n, s, t;
        t = Math.min(k, l - k);
        j = l % t == 0 ? t : 1;
        for (int i = 0; i < j; i++) {
            m = i;
            for (; ; ) {
                s = nums[m];
                nums[m] = t;
                n = m + k;
                if (n >= l) {
                    n -= l;
                }
                t = s;
                m = n;
                if (m == i) {
                    nums[m] = t;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Problem189 problem = new Problem189();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, t;
        for (int i = 0; i < nums.length; i++) {
            t = new int[nums.length];
            System.arraycopy(nums, 0, t, 0, nums.length);
            System.out.print(Arrays.toString(t) + " -> ");
            problem.rotate(t, i);
            System.out.println(Arrays.toString(t));
        }
    }

}
