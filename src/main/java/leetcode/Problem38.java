package leetcode;

public class Problem38 {

    public String countAndSay(int n) {
        int i = 1;
        String result = "1";
        for (; i < n; i++) {
            result = countAndSay(result);
        }
        return result;
    }

    private String countAndSay(String s) {
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        int last = s.charAt(0) - 48;
        int count = 1;
        for (int i = 1; i < length; i++) {
            int current = s.charAt(i) - 48;
            if (last != current) {
                sb.append(count).append(last);
                last = current;
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(count).append(last);
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem38 problem38 = new Problem38();
        for (int i = 1; i < 31; i++) {
            System.out.println(problem38.countAndSay(i));
        }
    }

}
