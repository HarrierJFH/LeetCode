package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem728 {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList();
        for (int i = left; i <= right; i++) {
            if (validate(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean validate(int n) {
        //assert n > 0;
        if (n < 10) {
            return true;
        }
        int i = n, j;
        while (i > 0) {
            j = i % 10;
            if (j == 0 || n % j != 0) {
                return false;
            }
            i = i / 10;
        }
        return true;
    }

}
