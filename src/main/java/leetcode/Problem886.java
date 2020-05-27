package leetcode;

public class Problem886 {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        int i = dislikes.length;
        if (i-- == 0) {
            return true;
        }
        int[] g = new int[2001];
        g[dislikes[i][0]] = 1;
        g[dislikes[i--][1]] = 2;
        for (; i > -1; i--) {
            if (g[dislikes[i][1]] == 1) {
                if (g[dislikes[i][0]] == 1) {
                    return false;
                } else {
                    g[dislikes[i][0]] = 2;
                }
            } else if (g[dislikes[i][1]] == 2) {
                if (g[dislikes[i][0]] == 2) {
                    return false;
                } else {
                    g[dislikes[i][0]] = 1;
                }
            } else if (g[dislikes[i][0]] == 1) {
                g[dislikes[i][1]] = 2;
            } else if (g[dislikes[i][0]] == 2) {
                g[dislikes[i][1]] = 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem886 problem = new Problem886();
        System.out.println(problem.possibleBipartition(4, new int[][]{{1, 3}, {2, 3}, {2, 4}, {3, 4}}));
        System.out.println(problem.possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}}));
        System.out.println(problem.possibleBipartition(3, new int[][]{{1, 2}, {1, 3}, {2, 3}}));
        System.out.println(problem.possibleBipartition(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}}));
    }

}
