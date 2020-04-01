package leetcode;

import java.util.*;

public class Problem5 {

    public static void main(String[] args) {
//        List<String> strings = new ArrayList<>();
//        Random random = new Random();
//        int count = 10;
//        for (int i = 0; i < count; i++) {
//            int length = random.nextInt(100000);
//            StringBuilder sb = new StringBuilder(length);
//            for (int j = 0; j < length; j++) {
//                sb.append((char) (random.nextInt(26) + 97));
//            }
//            strings.add(sb.toString());
//        }
//
//        long start = System.currentTimeMillis();
//        Solution1 solution1 = new Solution1();
//        for (int i = 0; i < count; i++) {
//            if (i % 1 == 0) {
//                System.out.print(i + " ");
//            }
//            solution1.longestPalindrome(strings.get(i));
//        }
//        System.out.println(System.currentTimeMillis() - start);
//        start = System.currentTimeMillis();
//        Solution2 solution2 = new Solution2();
//        for (int i = 0; i < count; i++) {
//            solution2.longestPalindrome(strings.get(i));
//        }
//
//
//        System.out.println(System.currentTimeMillis() - start);
        Solution2 solution2 = new Solution2();
//        System.out.println(solution2.longestPalindrome("abcdedcbbcdedcbee"));
        System.out.println(solution2.longestPalindrome("babad"));
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
     * cost = 56 ms 41.8 MB
     *
     * 2020-04-01
     * cost = 22 ms 39.5 MB
     * */
    private static class Solution2 {

        public String longestPalindrome(String s) {
            char[] chars = s.toCharArray();
            int length = chars.length;
            if (length == 0) {
                return "";
            } else if (length == 1) {
                return s;
            }
            int resultStart = 0;
            int resultLength = 1;
            char first = chars[0];
            EvenPalindrome lastEvenPalindrome = new EvenPalindrome(chars, first, 0, null);
            OddPalindrome lastOddPalindrome = new OddPalindrome(chars, first, 0, null);

            int evenMaxPossibleLength = 0;
            int oddMaxPossibleLength = 0;
            boolean skipEven = false;
            boolean skipOdd = false;
            for (int i = 1; i < length; i++) {
                char c = chars[i];

                if (lastEvenPalindrome != null) {
                    EvenPalindrome evenPalindrome = lastEvenPalindrome;
                    EvenPalindrome next = null;
                    while (evenPalindrome != null) {
                        evenPalindrome.forward(c, i);
                        if (evenPalindrome.valid) {
                            if (evenPalindrome.length() > resultLength) {
                                resultStart = evenPalindrome.start;
                                resultLength = evenPalindrome.length();
                            }
                        } else {
                            if (evenPalindrome == lastEvenPalindrome) {
                                lastEvenPalindrome = evenPalindrome.previous;
                            } else {
                                next.previous = evenPalindrome.previous;
                            }
                        }
                        next = evenPalindrome;
                        evenPalindrome = evenPalindrome.previous;
                    }
                }

                if (lastOddPalindrome != null) {
                    OddPalindrome oddPalindrome = lastOddPalindrome;
                    OddPalindrome next = null;
                    while (oddPalindrome != null) {
                        oddPalindrome.forward(c, i);
                        if (oddPalindrome.valid) {
                            if (oddPalindrome.length() > resultLength) {
                                resultStart = oddPalindrome.start;
                                resultLength = oddPalindrome.length();
                            }
                        } else {
                            if (oddPalindrome == lastOddPalindrome) {
                                lastOddPalindrome = oddPalindrome.previous;
                            } else {
                                next.previous = oddPalindrome.previous;
                            }
                        }
                        next = oddPalindrome;
                        oddPalindrome = oddPalindrome.previous;
                    }
                }

                if (!skipEven) {
                    int evenPossibleLength = EvenPalindrome.possibleLength(i, length);
                    if (evenPossibleLength > resultLength) {
                        lastEvenPalindrome = new EvenPalindrome(chars, c, i, lastEvenPalindrome);
                    } else {
                        if (evenPossibleLength < evenMaxPossibleLength) {
                            skipEven = true;
                        } else {
                            evenMaxPossibleLength = evenPossibleLength;
                        }
                    }
                }

                if (!skipOdd) {
                    int oddPossibleLength = OddPalindrome.possibleLength(i, length);
                    if (oddPossibleLength > resultLength) {
                        lastOddPalindrome = new OddPalindrome(chars, c, i, lastOddPalindrome);
                    } else {
                        if (oddPossibleLength < oddMaxPossibleLength) {
                            skipOdd = true;
                        } else {
                            oddMaxPossibleLength = oddPossibleLength;
                        }
                    }
                }

                if (lastEvenPalindrome == null && lastOddPalindrome == null && skipEven && skipOdd) {
                    break;
                }
            }

            return String.valueOf(chars, resultStart, resultLength);
        }

        private static class EvenPalindrome {

            private EvenPalindrome(char[] chars, char c, int index, EvenPalindrome previous) {
                this.chars = chars;
                this.toMatchChar = c;
                this.toMatchIndex = index;
                this.start = index;
                this.end = index;
                this.possibleLength = possibleLength(start, chars.length);
                this.previous = previous;
            }

            private static int possibleLength(int start, int charLength) {
                return charLength > 1 ? Math.min(charLength - start, start + 1) * 2 : 1;
            }

            private final char[] chars;
            private int start;
            private int end;
            private char toMatchChar;
            private int toMatchIndex;
            private int possibleLength;
            private boolean valid = true;
            private EvenPalindrome previous;

            private void forward(char c, int index) {
                if (toMatchChar == c) {
                    start = toMatchIndex;
                    end = index;
                    toMatchIndex = toMatchIndex - 1;
                    if (toMatchIndex >= 0) {
                        toMatchChar = chars[toMatchIndex];
                    } else {
                        toMatchChar = (char) -1;
                    }
                } else {
                    valid = false;
                }
            }

            private int length() {
                return end - start + 1;
            }

        }

        private static class OddPalindrome {

            private OddPalindrome(char[] chars, char c, int index, OddPalindrome previous) {
                this.chars = chars;
                this.toMatchChar = c;
                this.toMatchIndex = index;
                this.start = index;
                this.end = index;
                this.possibleLength = possibleLength(start, chars.length);
                this.previous = previous;
            }

            private static int possibleLength(int start, int charLength) {
                return charLength >= 3 ? Math.min(charLength - start - 2, start + 1) * 2 + 1 : 1;
            }

            private final char[] chars;
            private int start;
            private int end;
            private char toMatchChar;
            private int toMatchIndex;
            private int possibleLength;
            private boolean valid = true;
            private OddPalindrome previous;

            private void forward(char c, int index) {
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
                    } else {
                        toMatchChar = (char) -1;
                    }
                } else {
                    valid = false;
                }
            }

            private int length() {
                return end - start + 1;
            }

        }
    }

}
