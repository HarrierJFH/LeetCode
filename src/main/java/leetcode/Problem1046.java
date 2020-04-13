package leetcode;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Problem1046 {

    public int lastStoneWeight(int[] stones) {
        SortedCollection collection = new SortedArrayList();
        for (int stone : stones) {
            collection.add(stone);
        }
        while (collection.size() > 2) {
            int diff = collection.pollMax() - collection.pollMax();
            if (diff > 0) {
                collection.add(diff);
            }
        }
        if (collection.size() == 2) {
            return collection.pollMax() - collection.pollMax();
        } else if (collection.size() == 1) {
            return collection.pollMax();
        } else {
            return 0;
        }
    }

    interface SortedCollection {

        int size();

        void add(int num);

        int pollMax();

    }

    private static class RepeatableSortedSet implements SortedCollection {

        private final TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        private int size = 0;

        public int size() {
            return size;
        }

        public void add(int num) {
            Integer count = treeMap.get(num);
            treeMap.put(num, count != null ? count + 1 : 1);
            size++;
        }

        public int pollMax() {
            Map.Entry<Integer, Integer> entry = treeMap.lastEntry();
            int num = entry.getKey();
            int count = entry.getValue();
            if (count == 1) {
                treeMap.pollLastEntry();
            } else {
                treeMap.put(num, count - 1);
            }
            size--;
            return num;
        }

    }

    private static class SortedArrayList implements SortedCollection {

        private final ArrayList<Integer> list = new ArrayList<>();
        private int offset = 0;

        public int size() {
            return list.size() - offset;
        }

        public int get(int index) {
            return list.get(index + offset);
        }

        private void add(int index, int num) {
            list.add(index + offset, num);
        }

        public void add(int num) {
            if (size() == 0 || num <= get(size() - 1)) {
                list.add(num);
            } else {
                int l = 0;
                int r = size() - 1;
                int middle;
                while (r - l > 1) {
                    middle = (l + r) / 2;
                    int middleNum = get(middle);
                    if (middleNum == num) {
                        add(middle, num);
                        return;
                    } else if (middleNum > num) {
                        l = middle;
                    } else {
                        r = middle;
                    }
                }
                if (num >= get(l)) {
                    add(l, num);
                } else if (num <= get(r)) {
                    if (r + 1 == size()) {
                        list.add(num);
                    } else {
                        add(r + 1, num);
                    }
                } else {
                    add(r, num);
                }
            }
        }

        public int pollMax() {
            return list.get(offset++);
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('[');
            int size = size();
            for (int i = 0; i < size; i++) {
                stringBuilder.append(get(i));
                if (i + 1 != size) {
                    stringBuilder.append(", ");
                }
            }
            stringBuilder.append(']');
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        Problem1046 problem = new Problem1046();
        System.out.println(problem.lastStoneWeight(new int[]{2,7,4,1,8,1}));;
    }

}
