package leetcode;

public class Problem567 {

    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if (l2 < l1) {
            return false;
        }
        if (l1 == 1) {
            return s2.indexOf(s1.charAt(0)) != -1;
        }
        int[] a = new int[123];
        for (int i = 0; i < l1; i++) {
            a[s1.charAt(i)]++;
            a[s2.charAt(i)]--;
        }
        int d = 0, v;
        for (int i = 97; i < 123; i++) {
            if (a[i] != 0) {
                d++;
            }
        }
        if (d == 0) {
            return true;
        }
        for (int i = l1, j = 0; i < l2; i++, j++) {
            v = --a[s2.charAt(i)];
            if (v == 0) {
                d--;
            } else if (v == -1) {
                d++;
            }
            v = ++a[s2.charAt(j)];
            if (v == 0) {
                d--;
            } else if (v == 1) {
                d++;
            }
            if (d == 0) {
                return true;
            }
        }
        return false;
    }

}
