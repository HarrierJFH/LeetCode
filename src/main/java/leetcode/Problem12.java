package leetcode;

public class Problem12 {

    private final String[][] romans = new String[][]{
            {"", "I", "II", "III", "VI", "V", "IV", "IIV", "IIIV", "XI"},
            {"", "X", "XX", "XXX", "LX", "L", "XL", "XXL", "XXXL", "CX"},
            {"", "C", "CC", "CCC", "DC", "D", "CD", "CCD", "CCCD", "MC"},
            {"", "M", "MM", "MMM"}
    };

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            sb.append(romans[i++][num % 10]);
            num = num / 10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Problem12 problem12 = new Problem12();
        System.out.println(problem12.intToRoman(1988));
    }

}
