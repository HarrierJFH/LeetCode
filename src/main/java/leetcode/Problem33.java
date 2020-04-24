package leetcode;

public class Problem33 {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        if (r == -1) {
            return -1;
        }
        if (nums[l] > nums[r]) {
            return searchInRotated(nums, target, l, r);
        } else {
            return searchInNotRotated(nums, target, l, r);
        }
    }

    private int searchInRotated(int[] nums, int target, int l, int r) {
        if (r - l < 2) {
            return nums[l] == target ? l : nums[r] == target ? r : -1;
        }
        int m = (l + r) / 2;
        int nm = nums[m];
        if (nm == target) {
            return m;
        } else if (nm < target) {
            if (nm < nums[r]) {
                if (target > nums[r]) {
                    if (target > nums[l]) {
                        return searchInRotated(nums, target, l, m);
                    } else {
                        return target == nums[l] ? l : -1;
                    }
                } else {
                    return searchInNotRotated(nums, target, m + 1, r);
                }
            } else {
                return searchInRotated(nums, target, m, r);
            }
        } else {
            if (nm < nums[r]) {
                return searchInRotated(nums, target, l, m);
            } else {
                if (target < nums[l]) {
                    if (target < nums[r]) {
                        return searchInRotated(nums, target, m, r);
                    } else {
                        return target == nums[r] ? r : -1;
                    }
                } else {
                    return searchInNotRotated(nums, target, l, m - 1);
                }
            }
        }
    }

    private int searchInNotRotated(int[] nums, int target, int l, int r) {
        if (r - l < 2) {
            return nums[l] == target ? l : nums[r] == target ? r : -1;
        }
        int m = (l + r) / 2;
        if (nums[m] == target) {
            return m;
        } else if (nums[m] < target) {
            return searchInNotRotated(nums, target, m + 1, r);
        } else {
            return searchInNotRotated(nums, target, l, m - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        Problem33 problem = new Problem33();
        System.out.println(problem.search(nums, 0));
        System.out.println(problem.search(nums, 3));
        System.out.println(problem.search(nums, 5));
    }
}
