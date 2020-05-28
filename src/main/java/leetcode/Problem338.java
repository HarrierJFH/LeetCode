package leetcode;

import java.util.Arrays;

public class Problem338 {

    public int[] countBits(int num) {
        int[] array = new int[num + 1];
        array[0] = 0;
        int i = 1, l = 1, j = 0;
        while (i <= num) {
            if ((array[i++] = array[j++] + 1) == l) {
                l++;
                j = 0;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Problem338().countBits(64)));
    }

}
