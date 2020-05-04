package leetcode;

public class Problem476 {

    public int findComplement(int num) {
        for (int i = 0x40000000; i > 0; i = i >> 1) {
            if ((num & i) == i) {
                i = (i << 1) - 1;
                return i - num;
            }
        }
        return 0;
    }

}
