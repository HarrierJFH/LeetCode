package leetcode;

public class Problem1052 {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int length = customers.length, sum0 = 0, sum1 = 0, maxSum1 = 0;
        for (int i = 0; i < length; i++) {
            if (i >= X && grumpy[i - X] == 1) {
                sum1 -= customers[i - X];
            }
            if (grumpy[i] == 0) {
                sum0 += customers[i];
            } else {
                sum1 += customers[i];
                maxSum1 = Math.max(maxSum1, sum1);
            }
        }
        return sum0 + maxSum1;
    }

}
