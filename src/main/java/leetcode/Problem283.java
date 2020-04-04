package leetcode;

public class Problem283 {
    public void moveZeroes(int[] nums) {
        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                if (j == -1) {
                    j = i;
                }
            } else {
                if (j > -1) {
                    nums[j] = num;
                    nums[i] = 0;
                    j++;
                }
            }

        }
    }
}
