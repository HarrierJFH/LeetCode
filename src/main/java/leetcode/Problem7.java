package leetcode;

public class Problem7 {
    public int reverse(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        boolean negative = chars[0] == 45;
        if (negative) {
            int digitLength = chars.length - 1;
            for (int i = 0; i < digitLength / 2; i++) {
                swap(chars, i + 1, digitLength - i);
            }
            long result = 0;
            for (int i = 0; i < digitLength; i++) {
                result = result * 10 + (chars[i + 1] - 48);
            }
            result = -result;
            return result < Integer.MIN_VALUE ? 0 : (int) result;
        } else {
            int digitLength = chars.length;
            for (int i = 0; i < digitLength / 2; i++) {
                swap(chars, i, digitLength - i - 1);
            }
            long result = 0;
            for (int i = 0; i < digitLength; i++) {
                result = result * 10 + (chars[i] - 48);
            }
            return result > Integer.MAX_VALUE ? 0 : (int) result;
        }
    }

    private void swap(char[] chars, int index, int anotherIndex) {
        char temp = chars[anotherIndex];
        chars[anotherIndex] = chars[index];
        chars[index] = temp;
    }

}
