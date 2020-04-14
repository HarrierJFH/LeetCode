package leetcode;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Problem215 {

    private static class Solution1 {
        public int findKthLargest(int[] nums, int k) {
            if (k == 1) {
                int max = Integer.MIN_VALUE;
                for (int num : nums) {
                    if (num > max) {
                        max = num;
                    }
                }
                return max;
            }

            MySet mySet = new MySet(k);
            for (int i = 0; i < nums.length; i++) {
                mySet.add(((long) nums[i] << 32) + i);
            }
            return mySet.min();
        }

        private static class MySet {
            private final TreeSet<Long> treeSet = new TreeSet<>();
            private final int target;

            public MySet(int target) {
                this.target = target;
            }

            public int size() {
                return treeSet.size();
            }

            public int min() {
                return (int) (treeSet.first() >> 32);
            }

            public void add(long num) {
                if (size() == target) {
                    if (treeSet.first() < num) {
                        treeSet.pollFirst();
                        treeSet.add(num);
                    }
                } else {
                    treeSet.add(num);
                }
            }
        }
    }

    private static class Solution2 {
        public int findKthLargest(int[] nums, int k) {
            if (k == 1) {
                int max = Integer.MIN_VALUE;
                for (int num : nums) {
                    if (num > max) {
                        max = num;
                    }
                }
                return max;
            }

            MySet mySet = new MySet(k);
            for (int num : nums) {
                mySet.add(num);
            }
            return mySet.min();
        }

        private static class MySet {

            private final TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            private final int target;
            private int size = 0;

            public MySet(int target) {
                this.target = target;
            }

            public int size() {
                return size;
            }

            public int min() {
                return treeMap.firstKey();
            }

            public void add(int num) {
                if (size() == target) {
                    if (treeMap.firstKey() < num) {
                        Map.Entry<Integer, Integer> firstEntry = treeMap.firstEntry();
                        if (firstEntry.getValue() == 1) {
                            treeMap.pollFirstEntry();
                        } else {
                            treeMap.put(firstEntry.getKey(), firstEntry.getValue() - 1);
                        }
                        add0(num);
                    }
                } else {
                    add0(num);
                    size++;
                }
            }

            private void add0(int num) {
                Integer count = treeMap.get(num);
                treeMap.put(num, count == null ? 1 : count + 1);
            }
        }
    }

    private static class Solution3 {
        public int findKthLargest(int[] nums, int k) {
            if (k == 1) {
                int max = Integer.MIN_VALUE;
                for (int num : nums) {
                    if (num > max) {
                        max = num;
                    }
                }
                return max;
            }

            MySet mySet = new MySet(k);
            for (int num : nums) {
                mySet.add(num);
            }
            return mySet.min();
        }

        private static class MySet {

            private final LinkedList<Integer> list = new LinkedList<>();
            private final int target;

            public MySet(int target) {
                this.target = target;
            }

            public int size() {
                return list.size();
            }

            public int min() {
                return list.getFirst();
            }

            public int max() {
                return list.get(size() - 1);
            }

            public void add(int num) {
                if (size() == target) {
                    if (min() < num) {
                        list.remove(0);
                        add0(num);
                    }
                } else {
                    add0(num);
                }
            }

            private void add0(int num) {
                if (size() > 0 && num >= max()) {
                    list.add(size(), num);
                    return;
                }
                int i;
                for (i = 0; i < list.size(); i++) {
                    if (num <= list.get(i)) {
                        list.add(i, num);
                        return;
                    }
                }
                list.add(i, num);
            }
        }
    }


    public static void main(String[] args) {
        Problem215.Solution3 s = new Problem215.Solution3();
        System.out.println(s.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(s.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));

        int size = 5000;
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = i;
        }
        long start = System.currentTimeMillis();
        System.out.println(s.findKthLargest(nums, size));
        System.out.println(System.currentTimeMillis() - start);
    }
}
