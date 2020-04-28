package leetcode;

import java.util.*;

public class FirstUniqueNumber {

    private static class FirstUnique {

        private final HashSet<Integer> duplicated = new HashSet<>();
        private final LinkedHashSet<Integer> unique = new LinkedHashSet<>();

        public FirstUnique(int[] nums) {
            for (int num : nums) {
                add(num);
            }
        }

        public int showFirstUnique() {
            if (unique.isEmpty()) {
                return -1;
            }
            return unique.iterator().next();
        }

        public void add(int value) {
            if (duplicated.contains(value)) {
                return;
            }
            if (unique.contains(value)) {
                duplicated.add(value);
                unique.remove(value);
            } else {
                unique.add(value);
            }
        }
    }

    public static void main(String[] args) {
        FirstUnique firstUnique = new FirstUnique(new int[]{2, 3, 5});
        System.out.println(firstUnique.showFirstUnique()); // return 2
        firstUnique.add(5);           // the queue is now [2,3,5,5]
        System.out.println(firstUnique.showFirstUnique()); // return 2
        firstUnique.add(2);            // the queue is now [2,3,5,5,2]
        System.out.println(firstUnique.showFirstUnique()); // return 3
        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
        System.out.println(firstUnique.showFirstUnique()); // return -1
    }

}
