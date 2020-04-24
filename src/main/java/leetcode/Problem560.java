package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem560 {

    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int[] sums = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
            if (sum == k) {
                result++;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(sums[0], 1);
        Integer count;
        for (int i = 1; i < sums.length; i++) {
            sum = sums[i];
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
        System.out.println(problem560.subarraySum(new int[]{-1, -1, 1}, 0));
    }
}
