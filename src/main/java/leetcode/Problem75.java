package leetcode;

import java.util.Arrays;

public class Problem75 {

    public void sortColors(int[] nums) {
        int i0 = 0, i2 = nums.length - 1, i = 0;
        while (i <= i2) {
            if (nums[i] == 2) {
                while (nums[i2] == 2) {
                    if (i2-- == i) {
                        return;
                    }
                }
                if (nums[i2] == 0) {
                    nums[i0] = 0;
                    if (i0++ == i) {
                        i++;
                        nums[i2--] = 2;
                        continue;
                    }
                }
                nums[i++] = 1;
                nums[i2--] = 2;
            } else if (nums[i] == 0) {
                if (i0 == i) {
                    i0 = ++i;
                } else {
                    nums[i0++] = 0;
                    nums[i++] = 1;
                }
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Problem75 problem = new Problem75();
        int[] nums = {2, 0, 2, 1, 1, 0};
        problem.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
