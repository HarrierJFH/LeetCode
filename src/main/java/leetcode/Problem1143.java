package leetcode;

import java.util.Arrays;

public class Problem1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        int[] longest = new int[text1.length()];
        int lastBefore, lastAfter, current, t;
        char c;
        for (int i = text2.length() - 1; i >= 0; i--) {
            c = text2.charAt(i);
            lastBefore = 0;
            lastAfter = 0;
            for (int j = text1.length() - 1; j >= 0; j--) {
                t = longest[j];
                current = Math.max(t, lastAfter);
                if (text1.charAt(j) == c) {
                    current = Math.max(1 + lastBefore, current);
                }
                lastBefore = t;
                lastAfter = current;
                longest[j] = current;
            }
            System.out.println(Arrays.toString(longest));
        }
        return longest[0];
    }

    public static void main(String[] args) {
        Problem1143 problem = new Problem1143();
//        String l = "fmtclsfaxchgjavqrifqbkzspazw";
//        String s = "nczivetoxqjclwbwtibqvelwxsdaz";
//        String l = "cdebbadeacd";
//        String s = "acadebb";
        String l = "sxylbpqxfckwxiydioeyttamexpmhgzvxkhrhkkakcraqchmefcridcdivjquvjclnebcb";
        String s = "yocbauqdqvdvfvgllblqcgcmzzzkyoevteyyiguxmpupxzosu";
        System.out.println(problem.longestCommonSubsequence(l, s));
    }

}
