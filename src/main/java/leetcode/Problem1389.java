package leetcode;

import java.util.LinkedList;

public class Problem1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        LinkedList<Integer> l = new LinkedList<>();
        for (int i = 0; i < index.length; i++) {
            l.add(index[i], nums[i]);
        }
        int[] result = new int[index.length];
        int i = 0;
        for (Integer integer : l) {
            result[i++] = integer;
        }
        return result;
    }
}
