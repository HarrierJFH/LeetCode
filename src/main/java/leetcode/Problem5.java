package leetcode;

import java.util.*;

public class Problem5 {
    private Object[] charIndices;
    private char[] chars;

    public String longestPalindrome(String s) {
        String result = "";
        int resultLength = 0;
        chars = s.toCharArray();
        charIndices = new Object[128];
        for (int i = chars.length - 1; i >= 0; i--) {
            addToCharIndices(chars[i], i);
        }
        charLoop:
        for (int i = 0; i < chars.length; i++) {
            if (chars.length - i <= resultLength) {
                break;
            }
            char c = chars[i];
            List<Integer> indices = getCharIndices(c);
            for (int j : indices) {
                int expect = j - i + 1;
                if (expect <= resultLength) {
                    continue charLoop;
                }
                boolean validate = j - i <= 2 || validate(i + 1, j - 1);
                if (validate) {
                    result = String.valueOf(chars, i, expect);
                    resultLength = expect;
                    continue charLoop;
                }
            }
        }
        return result;
    }

    private boolean validate(int i, int j) {
        if (chars[i] == chars[j]) {
            if (i + 1 == j || i + 2 == j) {
                return true;
            }
            return validate(i + 1, j - 1);
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    private void addToCharIndices(char c, int index) {
        if (charIndices[c] == null) {
            charIndices[c] = new LinkedList<Integer>();
        }
        ((List<Integer>) charIndices[c]).add(index);
    }

    @SuppressWarnings("unchecked")
    private List<Integer> getCharIndices(char c) {
        return (List<Integer>) charIndices[c];
    }

    public static void main(String[] args) {
        Problem5 problem5 = new Problem5();
        System.out.println(problem5.longestPalindrome("a"));
    }

}
