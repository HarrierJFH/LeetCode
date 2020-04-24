package leetcode;

public class Problem200 {

    public int numIslands(char[][] grid) {
        int height = grid.length;
        if (height == 0) {
            return 0;
        }
        int width = grid[0].length;
        if (width == 0) {
            return 0;
        }
        int[] lastRow = new int[width];
        int island = 1, left, up, combined = 0;
        int[] parents = new int[width * height / 2 + 2];
        for (char[] row : grid) {
            left = 0;
            for (int w = 0; w < width; w++) {
                if (row[w] == '1') {
                    up = lastRow[w];
                    if (left != 0 && up != 0) {
                        if (left != up) {
                            while (parents[left] != 0) {
                                left = parents[left];
                            }
                            while (parents[up] != 0) {
                                up = parents[up];
                            }
                            if (left < up) {
                                parents[up] = left;
                                combined++;
                            } else if (left > up) {
                                parents[left] = up;
                                left = up;
                                combined++;
                            }
                            lastRow[w] = left;
                        }
                    } else if (left != 0) {
                        lastRow[w] = left;
                    } else if (up != 0) {
                        left = up;
                    } else {
                        lastRow[w] = island;
                        left = island++;
                    }
                } else {
                    lastRow[w] = 0;
                    left = 0;
                }
            }
        }
        return island - 1 - combined;
    }

}
