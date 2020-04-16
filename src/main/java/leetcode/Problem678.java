package leetcode;

public class Problem678 {

    public boolean checkValidString(String s) {
        int sum = 0;
        int any = 0;
        int limited = 0;
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '(') {
                sum++;
            } else if (c == ')') {
                sum--;
            } else if (c == '*') {
                any++;
            } else {
                return false;
            }
            if (sum < 0 && -sum > any + limited) {
                return false;
            } else if (sum < any) {
                limited++;
                any--;
            }
        }
        if (sum > 0) {
            return sum <= any;
        } else if (sum < 0) {
            return -sum <= any + limited;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Problem678 problem678 = new Problem678();
        System.out.println(problem678.checkValidString("(())(())(((()*()()()))()((()()(*()())))(((*)()"));
        System.out.println(problem678.checkValidString(")(((*)()"));
        System.out.println(problem678.checkValidString("(((*))(((*)))(((*)"));
    }
}
