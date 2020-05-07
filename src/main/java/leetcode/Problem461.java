package leetcode;

public class Problem461 {

    public int hammingDistance(int x, int y) {
        int n = x ^ y, result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                result++;
            }
            n = n >>> 1;
        }
        return result;
    }

}
