package leetcode;

public class Problem50 {

    public double myPow(double x, int n) {
        if (x == 0.0) {
            return 0.0;
        } else if (x == 1.0) {
            return 1.0;
        } else if (x == -1.0) {
            return n % 2 == 0 ? 1 : -1;
        }
        if (n >= 2) {
            double result = 1.0;
            double product = x;
            int j = 1;
            if ((n & j) != 0) {
                result *= product;
            }
            for (int i = 1; i < 31; i++) {
                j = j << 1;
                if (j > n) {
                    break;
                }
                product *= product;
                if ((n & j) != 0) {
                    result *= product;
                }
            }
            return result;
        } else if (n == 1) {
            return x;
        } else if (n == 0) {
            return 1.0;
        } else {
            if (n == Integer.MIN_VALUE) {
                double d = myPow(x, 0x40000000);
                return 1 / (d * d);
            } else {
                return 1 / myPow(x, -n);
            }
        }
    }

}
