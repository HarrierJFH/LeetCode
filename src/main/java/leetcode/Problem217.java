package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Problem217 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        Problem217 problem = new Problem217();
        System.out.println(problem.containsDuplicate(new int[]{1, 2, 3, 1}));
    }

}
