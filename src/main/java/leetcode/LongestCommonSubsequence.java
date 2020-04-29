package leetcode;

import util.UtilsKt;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        String s, l;
        if (text1.length() < text2.length()) {
            s = text1;
            l = text2;
        } else {
            l = text1;
            s = text2;
        }

        int i;
        int c;
        int[] index = new int[26];
        for (i = 0; i < s.length(); i++) {
            index[s.charAt(i) - 97] = i;
        }

        List<Integer>[] lists = new List[26];
        for (i = 0; i < l.length(); i++) {
            c = l.charAt(i) - 97;
            if (index[c] > 0) {
                if (lists[c] == null) {
                    lists[c] = new ArrayList<>();
                }
                lists[c].add(i);
            }
        }

        for (i = 0; i < 26; i++) {
            index[i] = 0;
        }


        return 0;
    }

    private String[] biFilter(String text1, String text2) {
        boolean[][] appear = new boolean[26][2];
        int i, c;
        for (i = 0; i < text1.length(); i++) {
            appear[text1.charAt(i) - 97][0] = true;
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (i = 0; i < text2.length(); i++) {
            c = text2.charAt(i);
            appear[c - 97][1] = true;
            if (appear[c - 97][0]) {
                sb2.append(text2.charAt(i));
            }
        }
        for (i = 0; i < text1.length(); i++) {
            c = text1.charAt(i);
            if (appear[c - 97][1]) {
                sb1.append(text1.charAt(i));
            }
        }
        return new String[]{sb1.toString(), sb2.toString()};
    }

    public int longest(String text1, int offset1, String text2, int offset2) {
        String t1 = text1.substring(offset1);
        String t2 = text2.substring(offset2);
//        System.out.println("calculating: " + t1 + " " + t2);
        if (text1.length() == offset1 || text2.length() == offset2) {
            return 0;
        }
        if (text1.length() - offset1 == 1) {
            int i = text2.indexOf(text1.charAt(offset1), offset2) >= offset2 ? 1 : 0;
//            System.out.println("calculated: " + t1 + " " + t2 + " -> " + i);
            return i;
        }
        if (text2.length() - offset2 == 1) {
            int i = text1.indexOf(text2.charAt(offset2), offset1) >= offset1 ? 1 : 0;
//            System.out.println("calculated: " + t1 + " " + t2 + " -> " + i);
            return i;
        }
        int longest = longest(text1, offset1, text2, offset2 + 1);
        int index = text1.indexOf(text2.charAt(offset2), offset1);
        if (index >= 0) {
            longest = Math.max(longest, 1 + longest(text1, index + 1, text2, offset2 + 1));
        }
//        System.out.println("calculated: " + t1 + " " + t2 + " -> " + longest);
        return longest;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence problem = new LongestCommonSubsequence();
//        String l = "fmtclsfaxchgjavqrifqbkzspazw";
//        String s = "nczivetoxqjclwbwtibqvelwxsdaz";

        String l = "sxylbpqxfckwxiydioeyttamexpmhgzvxkhrhkkakcraqchmefcridcdivjquvjclnebcb";
        String s = "yocbauqdqvdvfvgllblqcgcmzzzkyoevteyyiguxmpupxzosu";
//        System.out.println(problem.longest("mhunuzqrkzsnidwbun", 0, "szulspmhwpazoxijwbq", 0));
//        System.out.println(problem.longest("hofubmnylkra", 0, "pqhgxgdofcvmr", 0));
//        System.out.println(problem.longest("fmtclsfaxchgjavqrifqbkzspazw", 0, "nczivetoxqjclwbwtibqvelwxsdaz", 0));

//        System.out.println(problem.longest(l, 0, s, 0));
//        System.out.println("----------------------------------------------------------------------");

//        int length = 40;
//        StringBuilder sb = new StringBuilder(length);
//        Random random = new Random();
//        for (int i = 0; i < length; i++) {
//            sb.append((char) (random.nextInt(26) + 97));
//        }
//        System.out.println(sb);


        String[] strings = problem.biFilter(l, s);
        System.out.println(l + "->" + strings[0]);
        System.out.println(s + "->" + strings[1]);
//        System.out.println(UtilsKt.timeCost(() -> problem.longest(l, 0, s, 0), 1));
//        System.out.println(UtilsKt.timeCost(() -> problem.longest(strings[0], 0, strings[1], 0), 1));
        UtilsKt.timeCostCompare(() -> problem.longest(l, 0, s, 0), () -> problem.longest(strings[0], 0, strings[1], 0), 1);
//        System.out.println(problem.longest(strings[0], 0, strings[1], 0));
    }

}
