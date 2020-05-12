package leetcode;

public class Problem540 {

    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1, m;
        for (;;) {
            if (l == r) {
                return nums[r];
            } else if (r - l == 2) {
                return nums[r] == nums[r - 1] ? nums[l] : nums[r];
            }
            m = (l + r) / 2;
            if ((m - l) % 2 == 0) {
                if (nums[m] == nums[m - 1]) {
                    r = m - 2;
                } else if (nums[m] == nums[m + 1]) {
                    l = m + 2;
                } else {
                    return nums[m];
                }
            } else {
                if (nums[m] == nums[m - 1]) {
                    l = m + 1;
                } else if (nums[m] == nums[m + 1]) {
                    r = m - 1;
                } else {
                    return nums[m];
                }
            }
        }
    }

}
