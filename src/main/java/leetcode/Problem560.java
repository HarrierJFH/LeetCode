package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem560 {

    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Integer count;
        for (int num : nums) {
            sum += num;
            if (sum == k) {
                result++;
            }
            count = map.get(sum - k);
            if (count != null) {
                result += count;
            }
            count = map.get(sum);
            if (count == null) {
                map.put(sum, 1);
            } else {
                map.put(sum, count + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem560 problem560 = new Problem560();
        System.out.println(problem560.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(problem560.subarraySum(new int[]{-1, -1, 1}, 0));
    }
}
