package leetcode;

import java.util.Random;

public class Problem9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }
        char[] digits = new char[10];
        int length = 0;
        for (int i = 0; i < 10; i++) {
            digits[i] = (char) (x % 10);
            x = x / 10;
            if (x == 0) {
                length = i + 1;
                break;
            }
        }
        for (int i = 0; i < length / 2; i++) {
            if (digits[i] != digits[length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }
        for (int length = 10, j = 1000000000; ; length--, j /= 10) {
            if (x / j > 0) {
                int last = 10;
                for (int i = 0; i < length / 2; i++) {
                    int i1 = x / j;
                    int i2 = x % last;
                    if (i1 != i2) {
                        return false;
                    }
                    x -= i1 * j;
                    x /= 10;
                    j /= 100;
                }
                return true;
            }
        }
    }

    public static void main(String[] args) {
        Problem9 problem9 = new Problem9();
        Random random = new Random();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            problem9.isPalindrome(123454321);
//            problem9.isPalindrome(random.nextInt(Integer.MAX_VALUE));
        }
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            problem9.isPalindrome2(123454321);
//            problem9.isPalindrome2(random.nextInt(Integer.MAX_VALUE));
        }
        System.out.println(System.currentTimeMillis() - start);

    }

}
