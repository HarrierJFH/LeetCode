package leetcode;

public class Problem72 {

    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        } else if (word2.length() == 0) {
            return word1.length();
        }
        int[] min = new int[word2.length()];
        int lastBefore, lastAfter, current, t, i, j, b = 0;
        char c = word1.charAt(0);
        for (j = 0; j < word2.length(); j++) {
            if (b == 0 && c == word2.charAt(j)) {
                b = -1;
            }
            min[j] = j + 1 + b;
        }
        b = word1.charAt(0) == word2.charAt(0) ? -1 : 0;
        for (i = 0; i < word1.length(); ) {
            c = word1.charAt(i);
            if (b == 0 && c == word2.charAt(0)) {
                b = -1;
            }
            current = ++i + b;
            lastBefore = min[0];
            min[0] = lastAfter = current;
            for (j = 1; j < word2.length(); j++) {
                t = min[j];
                if (word2.charAt(j) == c) {
                    current = lastBefore;
                } else {
                    current = Math.min(lastBefore, Math.min(lastAfter, t)) + 1;
                }
                lastBefore = t;
                lastAfter = min[j] = current;
            }
        }
        return min[word2.length() - 1];
    }

    public static void main(String[] args) {
        Problem72 problem72 = new Problem72();
        System.out.println(problem72.minDistance("intention", "execution"));
    }

}
