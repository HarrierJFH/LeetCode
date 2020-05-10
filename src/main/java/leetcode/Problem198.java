package leetcode;

public class Problem198 {

    public int rob(int[] nums) {
        int[] sum = new int[2];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            j = j ^ 1;
            sum[j] = Math.max(nums[i] + sum[j], sum[j ^ 1]);
        }
        return Math.max(sum[0], sum[1]);
    }

}
