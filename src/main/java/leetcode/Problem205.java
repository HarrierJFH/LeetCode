package leetcode;

public class Problem205 {

    public boolean isIsomorphic(String s, String t) {
        char[] mappings = new char[128];
        boolean[] notAvailable = new boolean[128];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            char mapping = mappings[cs];
            if (mapping != 0) {
                if (ct != mapping) {
                    return false;
                }
            } else {
                if (!notAvailable[ct]) {
                    mappings[cs] = ct;
                    notAvailable[ct] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
