package leetcode;

public class Problem1232 {

    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        double k = (coordinates[1][1] - y0) / ((double) coordinates[1][0] - x0);
        for (int i = 2; i < coordinates.length; i++) {
            if (coordinates[i][1] - y0 != k * (coordinates[i][0] - x0)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem1232 problem = new Problem1232();
        System.out.println(problem.checkStraightLine(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }

}
