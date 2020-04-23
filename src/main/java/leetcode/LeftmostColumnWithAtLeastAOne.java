package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeftmostColumnWithAtLeastAOne {

    interface BinaryMatrix {

        int get(int x, int y);

        List<Integer> dimensions();

    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int height = dimensions.get(0);
        int width = dimensions.get(1);
        int l, r, t;
        int leftMost = -1;
        for (int h = 0; h < height; h++) {
            l = 0;
            r = leftMost > 0 ? leftMost - 1 : width - 1;
            t = indexOf1(binaryMatrix, h, l, r);
            if (t > 0) {
                leftMost = t;
            } else if (t == 0) {
                return 0;
            }
        }
        return leftMost;
    }

    private int indexOf1(BinaryMatrix binaryMatrix, int h, int l, int r) {
        if (l == r) {
            return binaryMatrix.get(h, l) == 1 ? l : -1;
        } else if (l + 1 == r) {
            return binaryMatrix.get(h, l) == 1 ? l : binaryMatrix.get(h, r) == 1 ? r : -1;
        }
        int m = (l + r) / 2;
        if (binaryMatrix.get(h, m) == 1) {
            int t = indexOf1(binaryMatrix, h, l, m - 1);
            return t >= 0 ? t : m;
        } else {
            return indexOf1(binaryMatrix, h, m + 1, r);
        }
    }

    private static class BinaryMatrixImpl implements BinaryMatrix {

        private final int[][] matrix;

        private BinaryMatrixImpl(int[][] matrix) {
            this.matrix = matrix;
        }

        @Override
        public int get(int x, int y) {
            return matrix[x][y];
        }

        @Override
        public List<Integer> dimensions() {
            List<Integer> list = new ArrayList<>();
            list.add(matrix.length);
            list.add(matrix[0].length);
            return list;
        }
    }


    public static void main(String[] args) {
        LeftmostColumnWithAtLeastAOne problem = new LeftmostColumnWithAtLeastAOne();
        int[][] matrix = new int[][]{{0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1}};
        BinaryMatrix binaryMatrix = new BinaryMatrixImpl(matrix);
        System.out.println(problem.leftMostColumnWithOne(binaryMatrix));
    }

}
