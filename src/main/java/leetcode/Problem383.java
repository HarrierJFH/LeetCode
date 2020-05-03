package leetcode;

public class Problem383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] unused = new int[26];
        int i = 0, j = 0, c, d;
        loop:
        for (; i < ransomNote.length(); i++) {
            c = ransomNote.charAt(i) - 97;
            if (unused[c] > 0) {
                unused[c]--;
            } else {
                while (j < magazine.length()) {
                    d = magazine.charAt(j++) - 97;
                    if (d == c) {
                        continue loop;
                    } else {
                        unused[d]++;
                    }
                }
                return false;
            }
        }
        return true;
    }

}
