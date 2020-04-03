package leetcode;

public class Problem42 {

    public int trap(int[] height) {
        int length = height.length;
        if (length <= 2) {
            return 0;
        }
        int sum = 0;
        int previous = height[0];
        boolean trapping = false;
        int maxHeight = 0;
        for (int i = 1; i < length; i++) {
            int h = height[i];
            if (h < previous && !trapping) {
                trapping = true;
                maxHeight = previous;
            } else if (h > previous && trapping) {
                if (h >= maxHeight) {
                    trapping = false;
                } else if (i < length - 1 && height[i + 1] > h) {
                    continue;
                }
                int waterLevel = Math.min(maxHeight, h);
                for (int j = i - 1; ; j--) {
                    int h2 = height[j];
                    if (h2 >= waterLevel) {
                        break;
                    } else {
                        sum += waterLevel - h2;
                        height[j] = waterLevel;
                    }
                }
            }
            previous = h;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Problem42 problem42 = new Problem42();
        System.out.println(problem42.trap(height));

    }

}
