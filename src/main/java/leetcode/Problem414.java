package leetcode;

public class Problem414 {
    public int thirdMax(int[] nums) {
        int length = nums.length;
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (length == 1) {
            return nums[0];
        }
        Integer first = null;
        Integer second = null;
        Integer third = null;
        for (int num : nums) {
            if (first == null || num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num < first) {
                if (second == null || num > second) {
                    third = second;
                    second = num;
                } else if (num < second) {
                    if (third == null || num > third) {
                        third = num;
                    }
                }
            }
        }
        return third == null ? first : third;
    }
}
