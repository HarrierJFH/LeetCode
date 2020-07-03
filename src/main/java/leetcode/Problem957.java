package leetcode;

import java.util.*;

public class Problem957 {

    public int[] prisonAfterNDays(int[] cells, int N) {
        int c = 0, i = 7;
        for (int a = 1; i >= 0; a = a << 1) {
            if (cells[i--] == 0) {
                c = c | a;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        map.put(c, 0);
        list.add(c);
        i = 1;
        for (; ; ) {
            c = (c << 1 ^ c >> 1) & 255 | 129;
            if (map.containsKey(c)) {
                int o = map.get(c);
                o = (N - o) % (i - o) + o;
                return destruct(list.get(o));
            } else {
                map.put(c, i);
                list.add(c);
            }
            if (i++ == N) {
                return destruct(c);
            }
        }
    }

    private int[] destruct(int c) {
        c = ~c;
        int[] cells = new int[8];
        for (int i = 1, a = 64; i < 7; i++, a = a >> 1) {
            if ((c & a) == a) {
                cells[i] = 1;
            }
        }
        return cells;
    }

    public static void main(String[] args) {
        int[] cells = {0, 1, 0, 1, 1, 0, 0, 1};
        Problem957 problem = new Problem957();
        for (int i = 1; i < 100; i++) {
            System.out.println(Arrays.toString(problem.prisonAfterNDays(cells, i)));
        }
    }

}
