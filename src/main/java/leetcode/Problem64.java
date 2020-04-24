package leetcode;

public class Problem64 {

    public int minPathSum(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int h = height - 1;
        int w = width - 1;
        int ht, wt;
        for (; ; ) {
            ht = h;
            wt = w;
            do {
                if (ht + 1 == height) {
                    if (wt + 1 < width) {
                        grid[ht][wt] += grid[ht][wt + 1];
                    }
                } else if (wt + 1 == width) {
                    grid[ht][wt] += grid[ht + 1][wt];
                } else {
                    grid[ht][wt] += Math.min(grid[ht + 1][wt], grid[ht][wt + 1]);
                }
            } while (--ht >= 0 && ++wt != width);
            if (w == 0) {
                if (h == 0) {
                    break;
                } else {
                    h--;
                }
            } else {
                w--;
            }
        }
        return grid[0][0];
    }

    public static void main(String[] args) {
        Problem64 problem = new Problem64();
//        int[][] grid = new int[][]{
//                {1, 3, 1},
//                {1, 5, 1},
//                {4, 2, 1}
//        };
        int[][] grid = new int[][]{{0}};
        System.out.println(problem.minPathSum(grid));
    }

}
