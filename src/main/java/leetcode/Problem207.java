package leetcode;

import java.util.*;

public class Problem207 {

    @SuppressWarnings("unchecked")
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set[] sets = new Set[numCourses];
        Set set;
        boolean[] searched;
        List<Integer> list;
        for (int[] prerequisite : prerequisites) {
            list = new ArrayList<>();
            list.add(prerequisite[1]);
            searched = new boolean[numCourses];
            for (int i = 0; i < list.size(); i++) {
                Integer integer = list.get(i);
                if (searched[integer]) {
                    continue;
                }
                if (integer == prerequisite[0]) {
                    return false;
                }
                searched[integer] = true;
                if (sets[integer] != null) {
                    list.addAll(sets[integer]);
                }
            }
            set = sets[prerequisite[0]];
            if (set == null) {
                set = (sets[prerequisite[0]] = new HashSet<Integer>());
            }
            set.add(prerequisite[1]);
        }
        return true;
    }

}
