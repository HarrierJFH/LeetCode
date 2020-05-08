package leetcode;

import java.util.Arrays;
import java.util.Random;

public class Problem384 {

    private static class Solution {

        private int[] nums;
        private int[] ori;

        public Solution(int[] nums) {
            this.nums = nums;
            this.ori = nums;
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return ori;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            int length = nums.length;
            if (length == 0) {
                return nums;
            }
            Random random = new Random();
            int[] shuffled = new int[length];
            int remain = length;
            while (remain > 0) {
                int i = random.nextInt(remain);
                System.arraycopy(nums, i, shuffled, length - remain, remain - i);
                remain = i;
            }
            nums = shuffled;
            return nums;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(Arrays.toString(solution.reset()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
    }

}
