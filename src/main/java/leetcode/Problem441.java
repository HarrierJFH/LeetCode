package leetcode;

public class Problem441 {

    public int arrangeCoins(int n) {
        if (n >= 2147450880) {
            return 65535;
        }
        int l = 1, r = 65535, m, sm;
        long ml;
        for (;;) {
            ml = m = (r + l) >> 1;
            sm = (int) (ml * (ml + 1) / 2);
            if (n > sm) {
                l = m + 1;
            } else if (n < sm) {
                r = m - 1;
            } else {
                return m;
            }
            if (r <= l) {
                ml = r;
                sm = (int) (ml * (ml + 1) / 2);
                if (sm <= n) {
                    return r;
                } else {
                    return --r;
                }
            }
        }
    }

}
