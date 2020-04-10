package leetcode;

public class Problem35 {

    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        } else if (length == 1) {
            return target <= nums[0] ? 0 : 1;
        }
        int l = 0;
        int r = length - 1;
        if (target <= nums[l]) {
            return l;
        }
        int numR = nums[r];
        if (target > numR) {
            return length;
        } else if (target == numR) {
            return r;
        }
        for (; ; ) {
            if (length == 2) {
                return r;
            }
            if (target <= nums[l]) {
                return l;
            }
            numR = nums[r];
            if (target > numR) {
                return length;
            } else if (target == numR) {
                return r;
            }
            int middle = length / 2 + l;
            int numM = nums[middle];
            if (numM == target) {
                return middle;
            } else if (numM < target) {
                l = middle;
            } else {
                r = middle;
            }
            length = r - l + 1;
        }
    }

    public static void main(String[] args) {
        Problem35 problem35 = new Problem35();
        System.out.println(problem35.searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(problem35.searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(problem35.searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(problem35.searchInsert(new int[]{1,3,5,6}, 0));
    }
}
