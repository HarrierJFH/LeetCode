package leetcode;

public class _Problem11 {

    public int maxArea(int[] height) {
        int length = height.length;
        int ir = length / 2;
        int il = ir - 1;
        int area = (ir - il) * Math.min(height[il], height[ir]);
        if (height[il] >= height[ir]) {
            for (int i = il; i >= 0; i--) {

            }
            for (int i = ir; i < length; i++) {

            }
        }

        return Math.abs(il - ir) * Math.min(height[il], height[ir]);
    }

    public static void main(String[] args) {
        System.out.println(0^2^2^8^7^4^4^7^8^5^5^3);
    }


}
