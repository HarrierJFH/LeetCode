package leetcode;

public class Problem463 {

    public int islandPerimeter(int[][] grid) {
        int land = 0, dup = 0, last;
        for (int j = 0; j < grid.length; j++) {
            last = 0;
            for (int i = 0; i < grid[0].length; i++) {
                if (grid[j][i] == 1) {
                    land++;
                    if (j != 0 && grid[j - 1][i] == 1) {
                        dup++;
                    }
                    if (last == 1) {
                        dup++;
                    } else {
                        last = 1;
                    }
                } else {
                    last = 0;
                }
            }
        }
        return (land << 2) - (dup << 1);
    }

}
