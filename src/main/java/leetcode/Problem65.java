package leetcode;

public class Problem65 {

    public boolean isNumber(String s) {
        Validator validator = new Validator();
        try {
            for (int i = 0; i < s.length(); i++) {
                validator.feed(s.charAt(i));
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return validator.isValid();
    }

    private static class Validator {
        int i = 0;
        boolean sign = false;
        boolean decimalPoint = false;
        boolean exponent = false;
        int digits = 0;
        boolean end = false;

        public boolean isValid() {
            if (digits == 0 && (exponent || decimalPoint)) {
                return false;
            }
            return i != 0;
        }

        public void feed(char c) {
            if (end) {
                if (c == ' ') {
                    return;
                }
                throw new IllegalArgumentException();
            } else if (c == ' ') {
                if (i != 0) {
                    end = true;
                } else {
                    return;
                }
            } else if (c == '+' || c == '-') {
                if (digits != 0 || sign || decimalPoint && !exponent) {
                    throw new IllegalArgumentException();
                }
                sign = true;
            } else if (c == '.') {
                if (decimalPoint || exponent) {
                    throw new IllegalArgumentException();
                } else {
                    decimalPoint = true;
                }
            } else if (c == 'e') {
                if (exponent || digits == 0) {
                    throw new IllegalArgumentException();
                }
                exponent = true;
                sign = false;
                digits = 0;
            } else if (c >= '0' && c <= '9') {
                digits++;
            } else {
                throw new IllegalArgumentException();
            }
            i++;
        }
    }

    public static void main(String[] args) {
        Problem65 problem65 = new Problem65();
        System.out.println(problem65.isNumber("0"));
        System.out.println(problem65.isNumber(" 0.1 "));
        System.out.println(!problem65.isNumber("abc"));
        System.out.println(!problem65.isNumber("1 a"));
        System.out.println(problem65.isNumber("2e10"));
        System.out.println(problem65.isNumber(" -90e3   "));
        System.out.println(!problem65.isNumber(" 1e"));
        System.out.println(!problem65.isNumber("e3"));
        System.out.println(problem65.isNumber(" 6e-1"));
        System.out.println(!problem65.isNumber(" 99e2.5 "));
        System.out.println(problem65.isNumber("53.5e93"));
        System.out.println(!problem65.isNumber(" --6 "));
        System.out.println(!problem65.isNumber("-+3"));
        System.out.println(!problem65.isNumber("95a54e53"));
        System.out.println(problem65.isNumber(".1"));
        System.out.println(!problem65.isNumber("."));
        System.out.println(!problem65.isNumber(" "));
        System.out.println(!problem65.isNumber(".-4"));
    }

}
