package leetcode;

import util.UtilsKt;

import java.util.Random;

public class Problem392 {

    public boolean isSubsequence(String s, String t) {
        char[] sChars = s.toCharArray();
        if (sChars.length == 0) {
            return true;
        }
        char[] tChars = t.toCharArray();
        int sIndex = 0;
        int sCurrent = sChars[sIndex++];
        for (int i = 0; i < tChars.length; i++) {
            if (tChars.length - i <= sChars.length - sIndex) {
                return false;
            }
            if (tChars[i] == sCurrent) {
                if (sIndex == sChars.length) {
                    return true;
                } else {
                    sCurrent = sChars[sIndex++];
                }
            }
        }
        return false;
    }

    public boolean other(String s, String t) {
        if (t == null) {
            return false;
        }
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() > t.length()) {
            return false;
        }

        int idx = -1;
        for (int i = 0; i < s.length(); i++) {
            idx = t.indexOf(s.charAt(i), idx + 1);
            if (idx == -1) {
                return false;
            }
        }

        return true;
    }

    public boolean optimized(String s, String t) {
        int sLength = s.length();
        if (sLength == 0) {
            return true;
        }
        int sIndex = 0;
        int sCurrent = s.charAt(sIndex);
        int tLength = t.length();
        for (int i = 0; i < tLength; i++) {
            if (tLength - i < sLength - sIndex) {
                return false;
            }
            if (t.charAt(i) == sCurrent) {
                if (++sIndex == sLength) {
                    return true;
                } else {
                    sCurrent = s.charAt(sIndex);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem392 problem392 = new Problem392();
        Random random = new Random();

        char[] tc = new char[100000];
        for (int i = 0; i < 100000; i++) {
            tc[i] = (char) (random.nextInt(26) + 97);
        }

        char[] sc = new char[100];
        for (int i = 0; i < 100; i++) {
            tc[i] = (char) (random.nextInt(26) + 97);
        }

        String t = new String(tc);
        String s = new String(sc);

        UtilsKt.timeCostCompare(() -> problem392.optimized(s, t), () -> problem392.other(s, t), 100000);
        System.out.println();
        UtilsKt.timeCostCompare(() -> problem392.other(s, t), () -> problem392.optimized(s, t), 100000);

    }

}
