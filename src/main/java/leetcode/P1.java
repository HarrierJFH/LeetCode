package leetcode;

import java.util.HashMap;

public class P1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length, 1);
        for (int index = 0; index < nums.length; index++) {
            int num = nums[index];
            int require = target - num;
            Integer anotherIndex = map.get(require);
            if (anotherIndex != null) {
                return new int[]{anotherIndex, index};
            } else {
                map.put(num, index);
            }
        }
        throw new RuntimeException("no available solution");
    }
}
