package leetcode;

import java.io.*;
import java.util.*;

public class Problem49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Long, Integer> map = new HashMap<>();
        List<List<String>> groups = new ArrayList<>();
        int groupSize = 0;
        for (String str : strs) {
            long sum = 0;
            long xor = 0;
            int product = 1;
            long length = str.length();
            for (int i = 0; i < length; i++) {
                int value = str.charAt(i) - 80;
//                value = value == 0 ? -14 : value;
                sum += value;
                xor = xor ^ value;
                product *= value;
            }
            long key = product + (sum << 32) + (length << 48) + (xor << 59);
            Integer groupIndex = map.get(key);
            if (groupIndex != null) {
                groups.get(groupIndex).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                groups.add(list);
                map.put(key, groupSize++);
            }
        }
        return groups;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("/data/d.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String s = reader.readLine();
        String[] strs = s.split(",");
        System.out.println(Arrays.toString(strs));
        reader.close();
        Problem49 problem49 = new Problem49();
        List<List<String>> x = problem49.groupAnagrams(strs);
        System.out.println(x);
        for (List<String> list : x) {
            int size = list.size();
            if (size > 1) {
                int[] array = new int[26];
                for (String str : list) {
                    for (int i = 0; i < str.length(); i++) {
                        array[str.charAt(i) - 97]++;
                    }
                }
                for (int i : array) {
                    if (i % size != 0) {
                        System.out.println(list);
                        break;
                    }
                }
            }
        }

//        for (char c = 'a'; c <= 'z'; c++) {
//            int i = c - 110;
//            i = i == 0 ? -14 : i;
//            System.out.print(i + " ");
//        }
//
//        calc("transition");
//        calc("journalist");
    }

    private static void calc(String str) {
        long sum = 0;
        long xor = 0;
        long product = 1;
        long length = str.length();
        for (int i = 0; i < length; i++) {
            int value = str.charAt(i) - 110;
//            value = value == 0 ? -14 : value;
            sum += value;
            xor = xor ^ value;
            product *= value;
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.println(sum);
        System.out.println(xor);
        System.out.println(product);
        System.out.println(length);
    }

}
