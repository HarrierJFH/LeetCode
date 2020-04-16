package leetcode;

public class Problem191 {

    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 1; i != 0; i = i << 1) {
            if ((n & i) == i) {
                count++;
            }
        }
        return count;
    }

}
