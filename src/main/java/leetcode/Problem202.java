package leetcode;

public class Problem202 {
    public boolean isHappy(int n) {
        int temp;
        int sum;
        boolean[] reached = new boolean[731];
        for (; ; ) {
            temp = n;
            sum = 0;
            for (; ; ) {
                int remainder = temp % 10;
                sum += remainder * remainder;
                temp /= 10;
                if (temp == 0) {
                    break;
                }
            }
            if (sum == 1) {
                return true;
            } else if (reached[sum]) {
                return false;
            } else {
                reached[sum] = true;
                n = sum;
            }
        }
    }

    public static void main(String[] args) {
        Problem202 problem202 = new Problem202();
        System.out.println(problem202.isHappy(19));
    }
}
