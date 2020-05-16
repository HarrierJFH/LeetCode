package leetcode;

public class Problem918 {

    public int maxSubarraySumCircular(int[] A) {
        int length = A.length;
        if (length == 0) {
            return 0;
        }
        int c = A[0], sum = c, p = Math.min(0, sum), mq = 0, qr = 0, max = Integer.MIN_VALUE, i = 1;
        while (i < length) {
            c = A[i++];
            sum += c;
            if (sum - p > max) {
                max = sum - p;
            }
            if (sum < p) {
                p = sum;
            }
            qr += c;
            if (qr > 0) {
                qr = 0;
            } else if (qr < mq) {
                mq = qr;
            }
        }
        return Math.max(max, sum - mq);
    }

    public static void main(String[] args) {
        Problem918 problem = new Problem918();
        System.out.println(problem.maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
        System.out.println(problem.maxSubarraySumCircular(new int[]{5, -3, 5}));
        System.out.println(problem.maxSubarraySumCircular(new int[]{3, -1, 2, -1}));
        System.out.println(problem.maxSubarraySumCircular(new int[]{3, -2, 2, -3}));
        System.out.println(problem.maxSubarraySumCircular(new int[]{-2, -3, -1}));
        System.out.println(problem.maxSubarraySumCircular(new int[]{-5, 4, -6}));
    }

}
