package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Problem448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new LinkedList<>();
        int t, s, d = 0;
        for (int i = 0; i < nums.length; ) {
            t = nums[i++];
            if (t == i) {
                continue;
            }
            nums[i - 1] = 0;
            list.add(i);
            for (; ; ) {
                s = nums[t - 1];
                if (s == t) {
                    d++;
                    break;
                }
                nums[t - 1] = t;
                if (s == 0) {
                    break;
                }
                t = s;
            }
        }
        Iterator<Integer> iterator = list.iterator();
        while (list.size() > d && iterator.hasNext()) {
            if (nums[iterator.next() - 1] != 0) {
                iterator.remove();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Problem448 problem448 = new Problem448();
        System.out.println(problem448.findDisappearedNumbers(new int[]{2, 2, 3, 4, 5, 6, 7, 8}));
    }

}
