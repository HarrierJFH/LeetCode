package leetcode;

public class Problem696 {

    public int countBinarySubstrings(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int result = 0;
        char lastNum = s.charAt(0);
        int acc = 1;
        int lastAcc = 0;
        char num;
        for (int i = 1; i < length; i++) {
            num = s.charAt(i);
            if (num != lastNum) {
                result += Math.min(lastAcc, acc);
                lastAcc = acc;
                lastNum = num;
                acc = 1;
            } else {
                acc++;
            }
        }
        result += Math.min(lastAcc, acc);
        return result;
    }

    public static void main(String[] args) {
        Problem696 problem696 = new Problem696();
        System.out.println(problem696.countBinarySubstrings("00110011"));
        System.out.println(problem696.countBinarySubstrings("0001110011"));
        System.out.println(problem696.countBinarySubstrings("10101"));
    }

}
