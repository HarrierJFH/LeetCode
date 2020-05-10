package leetcode;

public class Problem125 {

    public boolean isPalindrome(String s) {
        if (s.length() < 2) {
            return true;
        }
        int l = 0, r = s.length() - 1, vl, vr;
        for (; ; ) {
            if (l >= r) {
                return true;
            }
            vl = s.charAt(l);
            if (vl < 48 || vl > 57 && vl < 65 || vl > 90 && vl < 97 || vl > 122) {
                l++;
                continue;
            } else if (vl > 96) {
                vl -= 32;
            }
            for (; ; ) {
                if (l == r) {
                    return true;
                }
                vr = s.charAt(r);
                if (vr < 48 || vr > 57 && vr < 65 || vr > 90 && vr < 97 || vr > 122) {
                    r--;
                    continue;
                } else if (vr > 96) {
                    vr -= 32;
                }
                if (vl != vr) {
                    return false;
                }
                r--;
                break;
            }
            l++;
        }
    }

    public static void main(String[] args) {
        Problem125 problem125 = new Problem125();
        System.out.println(problem125.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(problem125.isPalindrome("race a car"));
    }
}
