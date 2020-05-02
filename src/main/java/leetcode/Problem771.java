package leetcode;

public class Problem771 {

    public int numJewelsInStones(String J, String S) {
        boolean[] jewel = new boolean[58];
        int result = 0;
        for (int i = 0; i < J.length(); i++) {
            jewel[J.charAt(i) - 65] = true;
        }
        for (int i = 0; i < S.length(); i++) {
            if (jewel[S.charAt(i) - 65]) {
                result++;
            }
        }
        return result;
    }

}
