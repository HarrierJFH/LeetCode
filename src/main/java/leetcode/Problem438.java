package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem438 {

    public List<Integer> findAnagrams(String s, String p) {
        int lp = p.length(), ls = s.length();
        if (ls < lp) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> list = new ArrayList<>();
        if (lp == 1) {
            char c = p.charAt(0);
            for (int i = 0; i < ls; i++) {
                if (s.charAt(i) == c) {
                    list.add(i);
                }
            }
            return list;
        }
        int[] a = new int[123];
        for (int i = 0; i < p.length(); i++) {
            a[p.charAt(i)]++;
            a[s.charAt(i)]--;
        }
        int d = 0, v;
        for (int i = 97; i < 123; i++) {
            if (a[i] != 0) {
                d++;
            }
        }
        if (d == 0) {
            list.add(0);
        }
        for (int i = lp, j = 0; i < ls; i++, j++) {
            v = --a[s.charAt(i)];
            if (v == 0) {
                d--;
            } else if (v == -1) {
                d++;
            }
            v = ++a[s.charAt(j)];
            if (v == 0) {
                d--;
            } else if (v == 1) {
                d++;
            }
            if (d == 0) {
                list.add(j + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Problem438 problem = new Problem438();
        System.out.println(problem.findAnagrams("nozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumhnozscgakjrpdeifylbqtxvwumh",
                "bqtxvwumh"));
    }

}
