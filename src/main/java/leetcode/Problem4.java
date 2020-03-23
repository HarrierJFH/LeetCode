package leetcode;

import java.util.*;

public class Problem4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length1 == 0) {
            return findMedianSortedArrays(nums2);
        } else {
            if (length2 == 0) {
                return findMedianSortedArrays(nums1);
            }
        }
        int totalLength = length1 + length2;
        int trimTimes = totalLength % 2 == 0 ? totalLength / 2 : totalLength / 2 + 1;
        int nums1Remain = length1;
        int nums2Remain = length2;
        int nums1L = 0;
        int nums1R = length1 - 1;
        int nums2L = 0;
        int nums2R = length2 - 1;
        int targetL = 0;
        int targetR = 0;
        for (int i = 0; i < trimTimes; i++) {
            if (nums1Remain == 0) {
                return findMedianSortedArrays(Arrays.copyOfRange(nums2, nums2L, nums2R + 1));
            }
            if (nums2Remain == 0) {
                return findMedianSortedArrays(Arrays.copyOfRange(nums1, nums1L, nums1R + 1));
            }
            if (nums1[nums1L] > nums2[nums2L]) {
                nums2Remain--;
                targetL = nums2[nums2L++];
            } else {
                nums1Remain--;
                targetL = nums1[nums1L++];
            }
            if (nums1Remain == 0) {
                nums2Remain--;
                targetR = nums2[nums2R--];
                continue;
            }
            if (nums2Remain == 0) {
                nums1Remain--;
                targetR = nums1[nums1R--];
                continue;
            }
            if (nums1[nums1R] < nums2[nums2R]) {
                nums2Remain--;
                targetR = nums2[nums2R--];
            } else {
                nums1Remain--;
                targetR = nums1[nums1R--];
            }
        }
        return (targetL + targetR) / 2.0;
    }

    private double findMedianSortedArrays(int[] nums) {
        int length = nums.length;
        int half = length / 2;
        if (length % 2 == 1) {
            return nums[half];
        } else {
            return (nums[half - 1] + nums[half]) / 2.0;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        Set<Integer> set = new HashSet<>(16, 1);
        for (int i = 0; i < 16; i++) {
            set.add(random.nextInt(100));
        }
        List<Integer> list = new ArrayList<>(set);
        int cutPoint = random.nextInt(list.size());
        List<Integer> list1 = new ArrayList<>(list.subList(0, cutPoint));
        List<Integer> list2 = new ArrayList<>(list.subList(cutPoint, list.size()));
        list1.sort(Integer::compareTo);
        list2.sort(Integer::compareTo);
        System.out.println(set);
        System.out.println("list1=" + list1);
        System.out.println("list2=" + list2);
        list.sort(Integer::compareTo);
        System.out.println(list);
        int[] nums = toArray(list);

        Problem4 problem4 = new Problem4();
        System.out.println(problem4.findMedianSortedArrays(nums));
        int[] nums1 = toArray(list1);
        int[] nums2 = toArray(list2);
//        int[] nums1 = new int[]{1, 2};
//        int[] nums2 = new int[]{3, 4};
        System.out.println(problem4.findMedianSortedArrays(nums1, nums2));
    }

    private static int[] toArray(List<Integer> list) {
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}
