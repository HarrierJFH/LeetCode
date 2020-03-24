package leetcode;

import java.util.*;

public class Problem5 {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        Random random = new Random();
        int count = 10000;
        for (int i = 0; i < count; i++) {
            int length = random.nextInt(1000);
            StringBuilder sb = new StringBuilder(length);
            for (int j = 0; j < length; j++) {
                sb.append((char) (random.nextInt(26) + 97));
            }
            strings.add(sb.toString());
        }

        long start = System.currentTimeMillis();
//        Solution1 solution1 = new Solution1();
//        for (int i = 0; i < count; i++) {
//            if (i % 1000 == 0) {
//                System.out.print(i + " ");
//            }
//            solution1.longestPalindrome(strings.get(i));
//        }
        Solution2 solution2 = new Solution2();
        for (int i = 0; i < count; i++) {
            solution2.longestPalindrome(strings.get(i));
        }
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();


        System.out.println(System.currentTimeMillis() - start);
//        Solution2 solution2 = new Solution2();
//        System.out.println(solution2.longestPalindrome("abcdedcbbcdedcbxax"));
    }

    /*
    * 2020-03-23
    * cost = 256 ms 41.3 MB
    * */
    private static class Solution1 {
        private Object[] charIndices = new Object[128];
        private char[] chars;

        public String longestPalindrome(String s) {
            String result = "";
            int resultLength = 0;
            chars = s.toCharArray();
            int length = chars.length;
            charIndices = new Object[128];

            for (int i = length - 1; i >= 0; i--) {
                addToCharIndices(chars[i], i);
            }

            charLoop:
            for (int i = 0; i < length; i++) {
                if (length - i <= resultLength) {
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
    }

    /*
     * 2020-03-24
     * cost = 63 ms 42.2 MB
     * */
    private static class Solution2 {

        public String longestPalindrome(String s) {
            char[] chars = s.toCharArray();
            int length = chars.length;
            if (length == 0) {
                return "";
            }
            int start = 0;
            int resultLength = 1;
            List<EvenPalindrome> evenPalindromes = new LinkedList<>();
            List<OddPalindrome> oddPalindromes = new LinkedList<>();


            for (int i = 0; i < length; i++) {
                char c = chars[i];
                Iterator<EvenPalindrome> evenIterator = evenPalindromes.iterator();
                while (evenIterator.hasNext()) {
                    EvenPalindrome evenPalindrome = evenIterator.next();
                    if (evenPalindrome.valid) {
                        evenPalindrome.feed(c, i);
                    } else {
                        evenIterator.remove();
                        if (evenPalindrome.length() > resultLength) {
                            start = evenPalindrome.start;
                            resultLength = evenPalindrome.length();
                        }
                    }
                }
                Iterator<OddPalindrome> oddIterator = oddPalindromes.iterator();
                while (oddIterator.hasNext()) {
                    OddPalindrome oddPalindrome = oddIterator.next();
                    if (oddPalindrome.valid) {
                        oddPalindrome.feed(c, i);
                    } else {
                        oddIterator.remove();
                        if (oddPalindrome.length() > resultLength) {
                            start = oddPalindrome.start;
                            resultLength = oddPalindrome.length();
                        }
                    }
                }

                if (i == length - 1) {
                    evenIterator = evenPalindromes.iterator();
                    while (evenIterator.hasNext()) {
                        EvenPalindrome evenPalindrome = evenIterator.next();
                        if (evenPalindrome.length() > resultLength) {
                            start = evenPalindrome.start;
                            resultLength = evenPalindrome.length();
                        }
                    }
                    oddIterator = oddPalindromes.iterator();
                    while (oddIterator.hasNext()) {
                        OddPalindrome oddPalindrome = oddIterator.next();
                        if (oddPalindrome.length() > resultLength) {
                            start = oddPalindrome.start;
                            resultLength = oddPalindrome.length();
                        }
                    }
                } else {
                    evenPalindromes.add(new EvenPalindrome(chars, c, i));
                    oddPalindromes.add(new OddPalindrome(chars, c, i));
                }
            }
            return String.valueOf(chars, start, resultLength);
        }

        private static class EvenPalindrome {

            private EvenPalindrome(char[] chars, char c, int index) {
                this.chars = chars;
                this.toMatchChar = c;
                this.toMatchIndex = index;
                this.start = index;
                this.end = index;
            }

            private char[] chars;
            private int start;
            private int end;
            private char toMatchChar;
            private int toMatchIndex;

            private boolean valid = true;

            private void feed(char c, int index) {
                if (toMatchChar == c) {
                    start = toMatchIndex;
                    end = index;
                    toMatchIndex = toMatchIndex - 1;
                    if (toMatchIndex >= 0) {
                        toMatchChar = chars[toMatchIndex];
                        return;
                    }
                }
                valid = false;
            }

            private int length() {
                return end - start + 1;
            }

        }

        private static class OddPalindrome {

            private OddPalindrome(char[] chars, char c, int index) {
                this.chars = chars;
                this.toMatchChar = c;
                this.toMatchIndex = index;
                this.start = index;
                this.end = index;
            }

            private char[] chars;
            private int start;
            private int end;
            private char toMatchChar;
            private int toMatchIndex;

            private boolean valid = true;

            private void feed(char c, int index) {
                if (index == start + 1) {
                    //ignore middle point
                    return;
                }
                if (toMatchChar == c) {
                    start = toMatchIndex;
                    end = index;
                    toMatchIndex = toMatchIndex - 1;
                    if (toMatchIndex >= 0) {
                        toMatchChar = chars[toMatchIndex];
                        return;
                    }
                }
                valid = false;
            }

            private int length() {
                return end - start + 1;
            }

        }
    }
}
