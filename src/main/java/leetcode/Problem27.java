package leetcode;

public class Problem27 {

    public int removeElement(int[] nums, int val) {
        int end = nums.length - 1;
        if (end == -1) {
            return 0;
        }
        int i = 0;
        while (i < end) {
            if (nums[i] == val) {
                while (i < end) {
                    int num = nums[end--];
                    if (num != val) {
                        nums[i] = num;
                        break;
                    }
                }
            }
            i++;
        }
        return nums[end] == val ? end : end + 1;
    }

}
