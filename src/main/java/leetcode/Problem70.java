package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem70 {

    private final List<Integer> list = new ArrayList<>(46);

    {
        list.add(1);
        list.add(1);
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n >= list.size()) {
            for (int i = list.size(); i <= n; i++) {
                list.add(list.get(i - 1) + list.get(i - 2));
            }
        }
        return list.get(n);
    }

    public static void main(String[] args) {
        Problem70 problem = new Problem70();
        for (int i = 1; i < 46; i++) {
            System.out.println(problem.climbStairs(i));
        }
    }

}
