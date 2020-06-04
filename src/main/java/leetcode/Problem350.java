package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class Problem350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] a, b;
        if (nums1.length < nums2.length) {
            a = nums1;
            b = nums2;
        } else {
            a = nums2;
            b = nums1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        Integer count;
        int size = 0;
        for (int i : a) {
            count = map.get(i);
            if (count == null) {
                map.put(i, 1);
            } else {
                map.put(i, ++count);
            }
        }
        for (int i : b) {
            count = map.get(i);
            if (count != null && count > 0) {
                map.put(i, --count);
                a[size++] = i;
            }
        }
        return Arrays.copyOf(a, size);
    }

    public static void main(String[] args) {
        Problem350 problem = new Problem350();
        System.out.println(Arrays.toString(problem.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(problem.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

}
