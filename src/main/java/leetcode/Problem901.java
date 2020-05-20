package leetcode;

import java.util.Arrays;

public class Problem901 {

    private static class StockSpanner {

        private int cap = 16;
        private int size = 0;
        private int[] lp = new int[cap];
        private int[] lc = new int[cap];

        public StockSpanner() {
        }

        public int next(int price) {
            int result = 1;
            int index = locate(price);
            for (int i = size; i > index; ) {
                result += lc[--i];
            }
            if (index == cap) {
                cap += 10;
                lp = Arrays.copyOf(lp, cap);
                lc = Arrays.copyOf(lc, cap);
            }
            lp[index] = price;
            lc[index] = result;
            size = ++index;
            return result;
        }

        private int locate(int price) {
            int l = 0, r = size - 1, m, p;
            while (r >= l) {
                m = (l + r) >>> 1;
                p = lp[m];
                if (price > p) {
                    r = m - 1;
                } else if (price < p) {
                    l = m + 1;
                } else {
                    return m;
                }
            }
            return l;
        }
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }

}
