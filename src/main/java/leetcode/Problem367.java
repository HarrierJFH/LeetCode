package leetcode;

public class Problem367 {

    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        } else if (num < 2) {
            return true;
        } else if (num >= 2147395600) {
            return num == 2147395600;
        }
        int l = 2, r = 46339, m, square;
        for (; ; ) {
            m = (l + r) / 2;
            square = m * m;
            if (square == num) {
                return true;
            } else if (square > num) {
                r = m;
                if (r - l == 1) {
                    return l * l == num;
                }
            } else {
                l = m;
                if (r - l == 1) {
                    return r * r == num;
                }
            }
        }
    }

    public static void main(String[] args) {
        Problem367 problem = new Problem367();
        for (int i = 0; i < 100; i++) {
            System.out.println(i + ":" + problem.isPerfectSquare(i * i + 1));
        }
    }

}
