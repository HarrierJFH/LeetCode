package leetcode;

public class Problem844 {

    public boolean backspaceCompare(String S, String T) {
        int sLastIndex = S.length() - 1;
        int tLastIndex = T.length() - 1;
        char sc = 0;
        char tc = 0;
        int backspace;

        for (; ; ) {
            backspace = 0;
            while (backspace >= 0 && sLastIndex >= 0) {
                sc = S.charAt(sLastIndex--);
                backspace += sc == '#' ? 1 : -1;
            }
            sc = backspace == -1 ? sc : 0;

            backspace = 0;
            while (backspace >= 0 && tLastIndex >= 0) {
                tc = T.charAt(tLastIndex--);
                backspace += tc == '#' ? 1 : -1;
            }
            tc = backspace == -1 ? tc : 0;

            if (sc == 0) {
                return tc == 0;
            } else if (tc == 0) {
                return false;
            }
            if (sc != tc) {
                return false;
            }
            if (sLastIndex < 0 && tLastIndex < 0) {
                return true;
            }
        }
    }

}
