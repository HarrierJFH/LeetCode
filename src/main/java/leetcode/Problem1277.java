package leetcode;

public class Problem1277 {

    public int countSquares(int[][] matrix) {
        int height = matrix.length;
        if (height == 0) {
            return 0;
        }
        int width = matrix[0].length;
        if (width == 0) {
            return 0;
        }
        int count = 0, i;
        if (height-- == 1) {
            for (i = 0; i < width; i++) {
                if (matrix[0][i] == 1) {
                    count++;
                }
            }
            return count;
        }
        if (width-- == 1) {
            for (i = 0; i < height; i++) {
                if (matrix[i][0] == '1') {
                    count++;
                }
            }
            return count;
        }
        for (i = 0; i <= width; i++) {
            count += matrix[height][i];
        }
        for (i = 0; i < height; i++) {
            count += matrix[i][width];
        }
        while (--width > -1 && --height > -1) {
            for (i = width; i >= 0; i--) {
                if (matrix[height][i] == 1) {
                    count += matrix[height][i] = Math.min(matrix[height + 1][i + 1],
                            Math.min(matrix[height + 1][i], matrix[height][i + 1])) + 1;
                }
            }
            for (i = height - 1; i >= 0; i--) {
                if (matrix[i][width] == 1) {
                    count += matrix[i][width] = Math.min(matrix[i + 1][width + 1],
                            Math.min(matrix[i + 1][width], matrix[i][width + 1])) + 1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Problem1277 problem1277 = new Problem1277();
        System.out.println(problem1277.countSquares(new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        }));
        System.out.println(problem1277.countSquares(new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        }));
    }


}
