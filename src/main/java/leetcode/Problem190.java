package leetcode;

public class Problem190 {

    public int reverseBits(int n) {
        int i = 0, reverse = 0;
        for (; ; ) {
            if ((n & 1) == 1) {
                reverse = reverse | 1;
            }
            if (++i == 32) {
                break;
            }
            n = n >>> 1;
            reverse = reverse << 1;
        }
        return reverse;
    }

    public static void main(String[] args) {
        Problem190 problem = new Problem190();
        System.out.println(problem.reverseBits(0B11111111111111111111111111111101));
        System.out.println(0B10111111111111111111111111111111);
    }

}
