package leetcode;

public class Problem342 {

    public boolean isPowerOfFour(int num) {
        if (num > 0) {
            for (; ; ) {
                if ((num & 1) == 1) {
                    return num >> 1 == 0;
                } else if ((num & 2) == 0) {
                    num = num >> 2;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem342 problem = new Problem342();
        for (int num = 1; num > 0; num *= 2) {
            System.out.println(num + " " + problem.isPowerOfFour(num));
        }
    }

}
