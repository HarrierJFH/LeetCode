package leetcode;

public class _Problem10 {

    private static abstract class Pattern {

        public abstract boolean isMatch(char[] chars, int index, int length);

    }

    private static class FixedLengthPattern extends Pattern {
        private final char[] value;

        public FixedLengthPattern(char[] chars) {
            this.value = chars;
        }

        public FixedLengthPattern(char[] chars, int start, int length) {
            this.value = new char[length];
            System.arraycopy(chars, start, value, 0, length);
        }

        public char[] chars() {
            return value;
        }

        private boolean isMatch(char c, char pattern) {
            return pattern == '.' || c == pattern;
        }

        @Override
        public boolean isMatch(char[] chars, int index, int length) {
            if (value.length != length) {
                return false;
            }
            for (int i = 0; i < length; i++) {
                if (!isMatch(chars[index + i], value[i])) {
                    return false;
                }
            }
            return true;
        }

    }

    private static class VariableLengthPattern extends Pattern {
        private final char value;

        public VariableLengthPattern(char c) {
            this.value = c;
        }

        public char getChar() {
            return value;
        }

        @Override
        public boolean isMatch(char[] chars, int index, int length) {
            if (value == '.') {
                return true;
            }
            for (int i = index; i < index + length; i++) {
                if (chars[i] != value) {
                    return false;
                }
            }
            return true;
        }

    }

    public boolean isMatch(String s, String p) {
        char[] chars = s.toCharArray();
        char[] pattern = p.toCharArray();

        if (pattern.length == 0) {
            return chars.length == 0;
        }

        char current = pattern[0];
        int index = 0;
        while (current > 0) {
//            char next =



        }

        return isMatch(chars, 0, chars.length, pattern, 0, pattern.length);
    }

    private boolean isMatch(char[] chars, int ci, int cl, char[] pattern, int pi, int pl) {
        return false;
    }

    public static void main(String[] args) {
        _Problem10 problem10 = new _Problem10();

//        assert problem10.isMatch("abcd", "abc*d");
//        assert problem10.isMatch("abccd", "abc*d");
//        assert problem10.isMatch("abd", "abc*d");
//        assert !problem10.isMatch("abcdc", "abc*d");
//        assert problem10.isMatch("abcd", ".*d");
//        assert !problem10.isMatch("abc", ".*d");

//        System.out.println("success");
    }

}
