package leetcode;

public class Problem50 {

    public double myPow(double x, int n) {
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1 / (myPow(x, Integer.MAX_VALUE) * x);
            } else {
                return 1 / myPow(x, -n);
            }
        } else if (n == 0) {
            return 1.0;
        } else if (n == 1) {
            return x;
        } else if (n == 2) {
            return x * x;
        } else {
            int l = n / 2;
            int r = n - l;
            if (l == r) {
                double d = myPow(x, l);
                return d * d;
            } else {
                return myPow(x, l) * myPow(x, r);
            }
        }
    }
}
