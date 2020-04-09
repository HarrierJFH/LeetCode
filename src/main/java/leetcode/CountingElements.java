package leetcode;

public class CountingElements {

    public int countElements(int[] arr) {
        int result = 0;
        int[] found = new int[1001];
        for (int i : arr) {
            found[i]++;
            if (found[i] == 1 && i > 0) {
                result += found[i - 1];
            }
            if (i < 1000 && found[i + 1] > 0) {
                result++;
            }
        }
        return result;
    }

}
