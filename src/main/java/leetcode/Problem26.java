package leetcode;

public class Problem26 {

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return length;
        }
        int last = nums[0];
        int c = 1;
        int i = 1;
        while (i < length) {
            int num = nums[i++];
            if (num != last) {
                last = num;
                nums[c++] = last;
            }
        }
        return c;
    }

}
