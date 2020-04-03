package leetcode;

public class Problem53 {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int maxSum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            if (num + sum <= 0) {
                sum = 0;
            } else {
                sum += num;
                maxSum = Math.max(maxSum, sum);
            }
        }
        return max <= 0 ? max : Math.max(maxSum, max);
    }

    public static void main(String[] args) {
        Problem53 problem53 = new Problem53();
        System.out.println(problem53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
