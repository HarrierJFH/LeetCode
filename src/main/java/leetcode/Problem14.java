package leetcode;

public class Problem14 {

    public String longestCommonPrefix(String[] strs) {
        int i, j, l = strs.length;
        if (l == 0) {
            return "";
        }
        Character c, last;
        loop:for (i = 0; ; i++) {
            last = null;
            for (j = 0; j < l; j++) {
                if (strs[j].length() == i) {
                    break loop;
                }
                c = strs[j].charAt(i);
                if (last != null && c != last) {
                    break loop;
                }
                last = c;
            }
        }
        return strs[0].substring(0, i);
    }

}
