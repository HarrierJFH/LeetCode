package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>(numRows);
        int last, n, i, j;
        for (i = 1; i <= numRows; i++) {
            lists.add(new ArrayList<>(i));
        }
        int[] lastColumn = new int[numRows];
        for (i = 0; i < numRows; i++) {
            n = 1;
            for (j = i; j < numRows; j++) {
                lists.get(j).add(n);
                last = lastColumn[j];
                lastColumn[j] = n;
                n += last;
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        /*1;
          1, 1;
          1, 2, 1;
          1, 3, 3, 1;
          1, 4, 6, 4, 1;
          1, 5, 10, 10, 5, 1;
          1, 6, 15, 20, 15, 6, 1;
          1, 7, 21, 35, 35, 21, 7, 1;*/
        Problem118 problem = new Problem118();
        List<List<Integer>> lists = problem.generate(8);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
