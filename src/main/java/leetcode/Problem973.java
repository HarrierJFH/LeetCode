package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Problem973 {

    public int[][] kClosest(int[][] points, int K) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        int i;
        List<Integer> list;
        for (i = 0; i < points.length; i++) {
            int key = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            list = map.get(key);
            if (list == null) {
                list = new ArrayList<>();
                list.add(i);
                map.put(key, list);
            } else {
                list.add(i);
            }
        }
        int[][] result = new int[K][];
        i = 0;
        while (i < K) {
            list = map.pollFirstEntry().getValue();
            for (Integer index : list) {
                result[i++] = points[index];
            }
        }
        return result;
    }

}
