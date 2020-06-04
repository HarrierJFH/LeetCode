package leetcode;

import java.util.Arrays;

public class Problem88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int i1 = m - 1, i2 = n - 1, i = nums1.length - 1;
        while (i1 > -1 && i2 > -1) {
            if (nums1[i1] > nums2[i2]) {
                nums1[i--] = nums1[i1--];
            } else {
                nums1[i--] = nums2[i2--];
            }
        }
        if (i1 < 0) {
            System.arraycopy(nums2, 0, nums1, 0, i2 + 1);
        }
    }

    public static void main(String[] args) {
        Problem88 problem = new Problem88();
        int[] nums1 = {2, 3, 4, 0, 0, 0};
        problem.merge(nums1, 3, new int[]{1, 5, 6}, 3);
        System.out.println(Arrays.toString(nums1));
    }

}
