package leetcode;

public class CountingElements {

    public int countElements(int[] arr) {
        int result = 0;
        int[] require = new int[1001];
        boolean[] found = new boolean[1001];
        for (int i : arr) {
            if (!found[i] && i > 0) {
                found[i] = true;
                result += require[i - 1];

            }
            if (i < 1000 && found[i + 1]) {
                result++;
            } else {
                require[i]++;
            }
        }
        return result;
    }

}
