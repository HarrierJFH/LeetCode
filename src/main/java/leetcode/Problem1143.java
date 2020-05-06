package leetcode;

import java.util.Arrays;

public class Problem1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        String[] strings = biFilter(text1, text2);
        text1 = strings[0];
        text2 = strings[1];
        if (text1.isEmpty() || text2.isEmpty()) {
            return 0;
        }
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
        Problem1143 problem = new Problem1143();
//        String l = "fmtclsfaxchgjavqrifqbkzspazw";
//        String s = "nczivetoxqjclwbwtibqvelwxsdaz";
        String l = "cdebbadeacd";
        String s = "acadebb";
        System.out.println(problem.longestCommonSubsequence(l, s));

//        String l = "sxylbpqxfckwxiydioeyttamexpmhgzvxkhrhkkakcraqchmefcridcdivjquvjclnebcb";
//        String s = "yocbauqdqvdvfvgllblqcgcmzzzkyoevteyyiguxmpupxzosu";
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


//        String[] strings = problem.biFilter(l, s);
//        System.out.println(l + "->" + strings[0]);
//        System.out.println(s + "->" + strings[1]);
//        System.out.println(UtilsKt.timeCost(() -> problem.longest(l, 0, s, 0), 1));
//        System.out.println(UtilsKt.timeCost(() -> problem.longest(strings[0], 0, strings[1], 0), 1));
//        UtilsKt.timeCostCompare(() -> problem.longest(l, 0, s, 0), () -> problem.longest(strings[0], 0, strings[1], 0), 1);
//        System.out.println(problem.longest(strings[0], 0, strings[1], 0));
    }

}
