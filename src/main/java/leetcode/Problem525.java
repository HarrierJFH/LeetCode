package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem525 {

    public int findMaxLength(int[] nums) {
        int sum = 0;
        int[] first = new int[100001];
        int f;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += (num == 0) ? -1 : 1;
            if (sum == 0) {
                result = i + 1;
            } else {
                f = first[sum + 50000];
                if (f > 0) {
                    result = Math.max(result, i - f + 1);
                } else {
                    first[sum + 50000] = i + 1;
                }
            }
        }
        return result;
    }

    public int findMaxLength2(int[] nums) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Integer f;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += (num == 0) ? -1 : 1;
            if (sum == 0) {
                result = i + 1;
            } else {
                f = map.get(sum);
                if (f != null) {
                    result = Math.max(result, i - f);
                } else {
                    map.put(sum, i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem525 p = new Problem525();
        System.out.println(p.findMaxLength2(new int[]{0, 0, 1, 0, 0, 0, 1, 1}));
    }

}
