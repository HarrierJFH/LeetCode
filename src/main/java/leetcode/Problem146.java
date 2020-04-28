package leetcode;

import java.util.LinkedHashMap;

public class Problem146 {

    private static class LRUCache {

        private final LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        private final int[] values;
        private int size = 0;

        public LRUCache(int capacity) {
            if (capacity < 1) {
                throw new IllegalArgumentException();
            }
            this.values = new int[capacity];
        }

        public int get(int key) {
            Integer index = map.remove(key);
            if (index != null) {
                map.put(key, index);
                return values[index];
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            Integer index = map.get(key);
            if (index != null) {
                map.remove(key);
                map.put(key, index);
                values[index] = value;
            } else {
                if (size < values.length) {
                    map.put(key, size);
                    values[size++] = value;
                } else {
                    index = map.remove(map.keySet().iterator().next());
                    map.put(key, index);
                    values[index] = value;
                }
            }
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }

}
