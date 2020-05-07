package leetcode;

public class Problem1009 {

    public int bitwiseComplement(int N) {
        for (int i = 0x40000000; i > 0; i = i >> 1) {
            if ((N & i) == i) {
                i = (i << 1) - 1;
                return i - N;
            }
        }
        return 1;
    }

}
