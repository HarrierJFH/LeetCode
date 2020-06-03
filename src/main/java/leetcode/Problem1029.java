package leetcode;

import java.util.Map;
import java.util.TreeMap;

public class Problem1029 {

    public int twoCitySchedCost(int[][] costs) {
        int a = 0, b, e = 0, l = 0;
        Integer count;
        TreeMap<Integer, Integer> map0 = new TreeMap<>();
        TreeMap<Integer, Integer> map1 = new TreeMap<>();
        TreeMap<Integer, Integer> map;
        for (int[] cost : costs) {
            if (cost[0] < cost[1]) {
                a += cost[0];
                b = cost[1] - cost[0];
                l++;
                map = map0;
            } else if (cost[1] < cost[0]) {
                a += cost[1];
                b = cost[0] - cost[1];
                l--;
                map = map1;
            } else {
                a += cost[0];
                e++;
                continue;
            }
            count = map.get(b);
            if (count != null) {
                map.put(b, ++count);
            } else {
                map.put(b, 1);
            }
        }
        map = l > 0 ? map0 : map1;
        l = (Math.abs(l) - e) >> 1;
        while (l > 0) {
            Map.Entry<Integer, Integer> entry = map.pollFirstEntry();
            if (entry.getValue() >= l) {
                a += entry.getKey() * l;
                break;
            } else {
                a += entry.getKey() * entry.getValue();
                l -= entry.getValue();
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Problem1029 problem = new Problem1029();
        System.out.println(problem.twoCitySchedCost(new int[][]{{1000, 998}, {300, 299}, {400, 500}, {399, 275}}));
        System.out.println(problem.twoCitySchedCost(new int[][]{{518, 518}, {71, 971}, {121, 862}, {967, 607}, {138, 754}, {513, 337}, {499, 873}, {337, 387}, {647, 917}, {76, 417}}));
    }

}
