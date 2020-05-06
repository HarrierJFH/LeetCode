package leetcode;

public class Problem13 {

    public int romanToInt(String s) {
        int rank;
        int lastRank = 0;
        int value;
        int lastValue = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    value = 1;
                    rank = 1;
                    break;
                case 'V':
                    value = 5;
                    rank = 2;
                    break;
                case 'X':
                    value = 10;
                    rank = 2;
                    break;
                case 'L':
                    value = 50;
                    rank = 3;
                    break;
                case 'C':
                    value = 100;
                    rank = 3;
                    break;
                case 'D':
                    value = 500;
                    rank = 4;
                    break;
                case 'M':
                    value = 1000;
                    rank = 4;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            if (rank > lastRank) {
                result -= 2 * lastValue;
            }
            result += value;

            lastRank = rank;
            lastValue = value;
        }
        return result;
    }

    public static void main(String[] args) {
        Problem13 problem = new Problem13();
        System.out.println(problem.romanToInt("III"));
        System.out.println(problem.romanToInt("IV"));
        System.out.println(problem.romanToInt("IX"));
        System.out.println(problem.romanToInt("LVIII"));
        System.out.println(problem.romanToInt("MCMXCIV"));
    }

}
