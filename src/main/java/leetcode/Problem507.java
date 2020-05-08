package leetcode;

public class Problem507 {

    public boolean checkPerfectNumber(int num) {
        if (num < 4) {
            return false;
        }
        int sum = 1, max = num / 2 + 1;
        for (int i = 2; ; i++) {
            if (i >= max) {
                break;
            }
            if (num % i == 0) {
                max = num / i;
                if (max == i) {
                    return sum + i == num;
                }
                sum += i + max;
                if (sum > num) {
                    return false;
                }
            } else if (i * i > num) {
                break;
            }
        }
        return sum == num;
    }

    public static void main(String[] args) {
        Problem507 problem507 = new Problem507();
        System.out.println(problem507.checkPerfectNumber(496));
    }
}
