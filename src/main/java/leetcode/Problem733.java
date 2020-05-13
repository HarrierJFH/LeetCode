package leetcode;

import java.util.Arrays;

public class Problem733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }
        image[sr][sc] = newColor;
        if (sr > 0 && image[sr - 1][sc] == oldColor) {
            floodFill(image, sr - 1, sc, newColor);
        }
        if (sr < image.length - 1 && image[sr + 1][sc] == oldColor) {
            floodFill(image, sr + 1, sc, newColor);
        }
        if (sc > 0 && image[sr][sc - 1] == oldColor) {
            floodFill(image, sr, sc - 1, newColor);
        }
        if (sc < image[0].length - 1 && image[sr][sc + 1] == oldColor) {
            floodFill(image, sr, sc + 1, newColor);
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = new int[][]{
                {0, 0, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 1, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 1},
                {0, 1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0, 1, 0, 1},
                {0, 1, 0, 1, 1, 0, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 1}
        };
        Problem733 problem = new Problem733();
        image = problem.floodFill(image, 3, 4, 2);
        for (int[] row : image) {
            System.out.println(Arrays.toString(row));
        }
    }

}
