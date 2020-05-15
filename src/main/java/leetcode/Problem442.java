package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem442 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int t, s;
        for (int i = 0; i < nums.length; i++) {
            t = nums[i];
            if (t == i + 1) {
                continue;
            }
            nums[i] = 0;
            for (; ; ) {
                s = nums[t - 1];
                if (s == t) {
                    list.add(s);
                    break;
                }
                nums[t - 1] = t;
                if (s == 0) {
                    break;
                }
                t = s;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Problem442 problem442 = new Problem442();
        System.out.println(problem442.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

}
