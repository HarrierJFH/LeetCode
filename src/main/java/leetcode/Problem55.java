package leetcode;

public class Problem55 {

    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i <= farthest; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if (farthest >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

}
