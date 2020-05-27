package leetcode;

public class Problem886 {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        int l = dislikes.length;
        if (l == 0) {
            return true;
        }
        int i = l - 1;
        boolean[] g1 = new boolean[2001];
        boolean[] g2 = new boolean[2001];
        g1[dislikes[i][0]] = true;
        g2[dislikes[i][1]] = true;
        for (i = l - 2; i > -1; i--) {
            if (g1[dislikes[i][1]]) {
                if (g1[dislikes[i][0]]) {
                    return false;
                } else {
                    g2[dislikes[i][0]] = true;
                }
            } else if (g2[dislikes[i][1]]) {
                if (g2[dislikes[i][0]]) {
                    return false;
                } else {
                    g1[dislikes[i][0]] = true;
                }
            } else if (g1[dislikes[i][0]]) {
                g2[dislikes[i][1]] = true;
            } else if (g2[dislikes[i][0]]) {
                g1[dislikes[i][1]] = true;
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
