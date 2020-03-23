package leetcode;

import java.util.*;

public class Problem1 {
    public int[] solution(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length, 1);
        map.put(nums[0], 0);
        Integer another;
        for (int index = 1; index < nums.length; index++) {
            another = map.get(target - nums[index]);
            if (another != null) {
                return new int[]{another, index};
            } else {
                map.put(nums[index], index);
            }
        }
        throw new RuntimeException("no available solution");
    }

    public int[] lowMemoryCost(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new RuntimeException("no available solution");
    }
}
