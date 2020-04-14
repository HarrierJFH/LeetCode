package leetcode;

import util.UtilsKt;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContiguousArray2 {

    public int findMaxLength(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        List<Counter> counters = new LinkedList<>();

        int result = 0;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            for (Iterator<Counter> iterator = counters.iterator(); iterator.hasNext(); ) {
                Counter counter = iterator.next();
                int j = 2 * counter.start - i - 1;
                if (j == 0) {
                    iterator.remove();
                } else if (j < 0) {
                    iterator.remove();
                    continue;
                }
                counter.sum += val(num);
                counter.sum += val(nums[j]);
                if (counter.sum == 0) {
                    result = Math.max(result, i - counter.start + 1);
                }

            }

            if (num != last) {
                result = Math.max(result, 2);
                Counter counter = new Counter();
                counter.start = i;
                counters.add(counter);
            }
            last = num;
        }
        return result;
    }

    private int val(int num) {
        return num == 0 ? -1 : 1;
    }

    private static class Counter {
        private int start;
        private int sum = 0;
    }


    public static void main(String[] args) {
        ContiguousArray2 contiguousArray = new ContiguousArray2();
        System.out.println(contiguousArray.findMaxLength(new int[]{0, 1}));
        System.out.println(contiguousArray.findMaxLength(new int[]{0, 1, 0}));
        System.out.println(contiguousArray.findMaxLength(new int[]{1, 0, 1, 0, 1, 1, 0}));
        System.out.println(contiguousArray.findMaxLength(new int[]{1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(contiguousArray.findMaxLength(new int[]{1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1}));

        int[] ints = new int[50000];
        ints[5456] = 1;
        ints[5458] = 1;
        System.out.println(UtilsKt.timeCost(() -> contiguousArray.findMaxLength(ints), 1));
    }

}
