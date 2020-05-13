package leetcode;

public class Problem48 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n-- < 2) {
            return;
        }
        int x, y, v, t;
        for (int i = 0, j = n; j > 0; i++, j = j - 2) {
            for (int k = 0; k < j; k++) {
                v = matrix[i][i + k];
                for (int l = 0; l < 4; l++) {
                    if (l == 0) {
                        x = i + k;
                        y = n - i;
                    } else if (l == 1) {
                        x = n - i;
                        y = n - i - k;
                    } else if (l == 2) {
                        x = n - i - k;;
                        y = i;
                    } else {
                        x = i;
                        y = i + k;
                    }
                    t = matrix[x][y];
                    matrix[x][y] = v;
                    v = t;
                }
            }
        }
    }

}
