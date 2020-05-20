package leetcode;

public class Problem11 {

    public int maxArea(int[] height) {
        int max = 0, e = height.length - 1, wm;
        for (int i = 0; i < e; i++) {
            wm = e - i;
            int hi = height[i];
            if (hi * wm <= max) {
                continue;
            }
            for (int j = e, w = wm; j > i; ) {
                int hj = height[j--];
                max = Math.max(max, Math.min(hj, hi) * w);
                if (max >= w * hj) {
                    e = j;
                }
                if (hj >= hi) {
                    break;
                }
                if (--w * hi <= max) {
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Problem11 problem11 = new Problem11();
        System.out.println(problem11.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(problem11.maxArea(new int[]{6, 14, 2, 11, 2, 7, 0, 9, 12, 7}));
    }


}
