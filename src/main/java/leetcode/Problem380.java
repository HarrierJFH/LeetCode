package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Problem380 {

    private static class RandomizedSet {

        private final HashMap<Integer, Integer> map;
        private int[] array;
        private int size;
        private final Random random;

        public RandomizedSet() {
            this.map = new HashMap<>();
            this.array = new int[16];
            this.random = new Random();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (map.putIfAbsent(val, size) == null) {
                if (array.length == size) {
                    array = Arrays.copyOf(array, array.length * 2);
                }
                array[size++] = val;
                return true;
            }
            return false;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            Integer index = map.remove(val);
            if (index == null) {
                return false;
            } else if (index == size - 1) {
                size--;
                return true;
            } else {
                map.put(array[index] = array[--size], index);
                return true;
            }
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return array[random.nextInt(size)];
        }
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        System.out.println(set.remove(0));
        System.out.println(set.remove(0));
        System.out.println(set.insert(0));
        System.out.println(set.getRandom());
        System.out.println(set.remove(0));
        System.out.println(set.insert(0));
    }

}
