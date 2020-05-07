package leetcode;

public class Problem326 {

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return true;
    }

    public boolean calc(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

}
