package leetcode;

import java.util.Arrays;

public class Problem238 {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int i;
        int times = nums.length - 1;
        int product = 1;
        int zeroIndex = -1;
        for (i = 0; i < times; i++) {
            int num = nums[i];
            if (num == 0) {
                if (zeroIndex != -1) {
                    return result;
                }
                zeroIndex = i;
            } else {
                product *= num;
            }
        }
        if (zeroIndex != -1) {
            result[zeroIndex] = product * nums[i];
            return result;
        }
        for (; ; ) {
            result[i] = product;
            if (i == 0) {
                break;
            }
            product = product * nums[i] / nums[--i];
        }
        return result;
    }

    public static void main(String[] args) {
        Problem238 p = new Problem238();
        System.out.println(Arrays.toString(p.productExceptSelf(new int[]{9, 0, -2})));
    }

}
