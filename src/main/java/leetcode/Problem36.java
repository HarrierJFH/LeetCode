package leetcode;

public class Problem36 {

    public boolean isValidSudoku(char[][] board) {
        boolean[][][] flags = new boolean[3][9][9];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                int num = board[r][c];
                if (num == '.') {
                    continue;
                }
                num = num - 49;
                if (flags[0][r][num]) {
                    return false;
                } else {
                    flags[0][r][num] = true;
                }
                if (flags[1][c][num]) {
                    return false;
                } else {
                    flags[1][c][num] = true;
                }
                int g = (r / 3) * 3 + c / 3;
                if (flags[2][g][num]) {
                    return false;
                } else {
                    flags[2][g][num] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem36 problem36 = new Problem36();
        char[][] chars = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(problem36.isValidSudoku(chars));
    }

}
