package leetcode;

public class Problem387 {

    public int firstUniqChar(String s) {
        int[] count = new int[26];
        int[] indices = new int[26];
        int j = 0;
        int val;
        int i;
        for (i = 0; i < s.length(); i++) {
            val = s.charAt(i) - 97;
            if (count[val]++ == 0) {
                indices[j++] = i;
            }
        }
        for (i = 0; i < j; i++) {
            val = indices[i];
            if (count[s.charAt(val) - 97] == 1) {
                return val;
            }
        }
        return -1;
    }

}
