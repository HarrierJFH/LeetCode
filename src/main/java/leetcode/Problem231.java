package leetcode;

public class Problem231 {

    public boolean isPowerOfTwo(int n) {
        if (n > 0) {
            for (; ; ) {
                if ((n & 1) == 1) {
                    return n >> 1 == 0;
                } else {
                    n = n >> 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem231 problem = new Problem231();
        for (int num = 1; num > 0; num *= 2) {
            System.out.println(num + " " + problem.isPowerOfTwo(num));
        }
        for (int num = 1; num > 0; num *= 6) {
            System.out.println(num + " " + problem.isPowerOfTwo(num));
        }
    }

}
