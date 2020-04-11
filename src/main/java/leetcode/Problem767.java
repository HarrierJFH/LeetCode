package leetcode;

public class Problem767 {

    public String reorganizeString(String S) {
        int[] counts = new int[26];
        int length = S.length();
        int max = 0;
        for (int i = 0; i < length; i++) {
            max = Math.max(max, ++counts[S.charAt(i) - 97]);
        }
        if (2 * max - 1 > length) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder(length);
        int appended = 0;

        int previous = -1;
        int index = 0;
        while (appended < length) {
            max = 0;
            for (int i = 0; i < 26; i++) {
                int count = counts[i];
                if (i != previous && count > max) {
                    max = count;
                    index = i;
                }
            }
            assert max != 0;
            stringBuilder.append((char) (index + 97));
            previous = index;
            counts[index]--;
            appended++;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Problem767 problem767 = new Problem767();
        System.out.println(problem767.reorganizeString("aab"));
        System.out.println(problem767.reorganizeString("aaab"));
    }


}
