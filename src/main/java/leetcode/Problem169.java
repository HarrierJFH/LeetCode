package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem169 {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int target = nums.length / 2;
        if (nums.length <= 2) {
            return nums[0];
        }
        for (int num : nums) {
            Integer count = map.get(num);
            if (count != null) {
                if (count == target) {
                    return num;
                } else {
                    map.put(num, count + 1);
                }
            } else {
                map.put(num, 1);
            }
        }
        return 0;
    }

}
