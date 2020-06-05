package leetcode;

import java.io.*;
import java.util.*;

public class Problem1013 {

    public boolean canThreePartsEqualSum(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, z = 0;
        for (int i = 0; i < A.length; i++) {
            map.put(sum += A[i], i);
            if (sum == 0) {
                z++;
            }
        }
        if (sum == 0 && z > 2) {
            return true;
        }
        if (sum % 3 == 0) {
            Integer i1 = map.get(sum / 3);
            Integer i2 = map.get(sum / 3 * 2);
            return i1 != null && i2 != null && i1 < i2;
        }
        return false;
    }

    public boolean canThreePartsEqualSum2(int[] A) {
        Set<Integer> d = new HashSet<>();
        Set<Integer> t = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < A.length; ) {
            sum += A[i++];
            if ((sum & 1) == 0 && d.contains(sum)) {
                if (sum == 0 && i == A.length) {
                    break;
                }
                t.add(sum / 2 * 3);
            }
            d.add(sum * 2);
        }
        return t.contains(sum);
    }

    public boolean canThreePartsEqualSum3(int[] A) {
        HashSet<Integer> triple = new HashSet<>();
        int l = 0, r = A.length - 1, sumL = 0, sumR = 0;
        while (r > l) {
            if ((sumL += A[l++]) == (sumR += A[r--]) && r - l > 1) {
                triple.add(sumL * 3);
            }
        }
        if (l == r) {
            return triple.contains(sumL + sumR + A[l]);
        } else {
            return triple.contains(sumL + sumR);
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/data/a.txt")));
        String s = bufferedReader.readLine();
        bufferedReader.close();
        String[] strings = s.split(",");

        int[] a = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            a[i] = Integer.parseInt(strings[i]);
        }

//        int sum = 0;
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("/data/b.txt")));
//        for (int i : a) {
//            sum += i;
//            bufferedWriter.write(String.valueOf(sum));
//            bufferedWriter.newLine();
//        }
//        bufferedWriter.flush();
//        bufferedWriter.close();

        Problem1013 problem1013 = new Problem1013();
//        a = new int[]{1, -1, 1, -1};
//        a = new int[]{10, -10, 10, -10, 10, -10, 10, -10};
//        a = new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
//        a = new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1};
        a = new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4};
//        System.out.println(problem1013.canThreePartsEqualSum(a));
        System.out.println(problem1013.canThreePartsEqualSum2(a));
        System.out.println(problem1013.canThreePartsEqualSum3(a));
    }

}
