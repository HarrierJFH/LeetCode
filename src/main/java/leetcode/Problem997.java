package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem997 {

    public int findJudge(int N, int[][] trust) {
        if (N == 1) {
            return 1;
        }
        boolean[] invalid = new boolean[N + 1];
        int[] counts = new int[N + 1];
        List<Integer> list = new ArrayList<>();
        for (int[] t : trust) {
            invalid[t[0]] = true;
            if (++counts[t[1]] == N - 1 && !invalid[t[1]]) {
                list.add(t[1]);
            }
        }
        for (int i : list) {
            if (!invalid[i]) {
                return i;
            }
        }
        return -1;
    }

}
