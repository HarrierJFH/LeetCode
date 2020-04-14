package leetcode;

import util.UtilsKt;

public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return 0;
        }
        Counter firstCounter = new Counter();
        firstCounter.start = 0;
        firstCounter.sum = nums[0] == 1 ? 1 : -1;
        boolean skip = false;
        boolean skipNext;
        int val;
        Counter counter;
        int result = 0;
        int remain;
        for (int i = 1; i < nums.length; i++) {
            val = nums[i] == 1 ? 1 : -1;
            remain = length - i - 1;

            skipNext = false;
            counter = firstCounter;
            while (counter != null) {
                counter.sum += val;
                if (counter.sum == 0) {
                    skipNext = true;
                    counter.length = i - counter.start + 1;
                    result = Math.max(result, counter.length);
                    if (result % 2 != 0) {
                        System.out.println();
                    }
                } else {
                    if (Math.abs(counter.sum) > remain) {
                        if (counter.previous != null) {
                            counter.previous.next = counter.next;
                        }
                        if (counter.next != null) {
                            counter.next.previous = counter.previous;
                        }
                    }
                }
                counter = counter.next;
            }

            if (!skip && remain + 1 > result) {
                counter = new Counter();
                counter.start = i;
                counter.sum = val;
                counter.length = 0;
                counter.next = firstCounter;
                firstCounter.previous = counter;
                firstCounter = counter;
            }
            skip = skipNext;
        }
        return result;
    }

    private static class Counter {
        private int start;
        private int sum;
        private int length = 0;
        private Counter previous;
        private Counter next;
    }

    public static void main(String[] args) {
        ContiguousArray contiguousArray = new ContiguousArray();
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
