package leetcode;

public class Problem6 {
    private char[] chars;
    private int numRows;
    private int length;
    private int cycle;
    private char[] result;
    private int cursor;

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        chars = s.toCharArray();
        this.numRows = numRows;
        length = chars.length;
        cycle = (numRows - 1) * 2;
        result = new char[length];
        cursor = 0;

        int r = 0;
        appendSingleRow(r);
        for (r = 1; r < numRows - 1; r++) {
            appendDoubleRow(r);
        }
        appendSingleRow(r);

        return new String(result);
    }

    private void appendSingleRow(int r) {
        for (int i = 0; ; i++) {
            int index = r + cycle * i;
            if (index >= length) {
                break;
            }
            result[cursor++] = chars[index];
        }
    }

    private void appendDoubleRow(int r) {
        int secondPosition = r + (numRows - 1 - r) * 2;
        for (int i = 0; ; i++) {
            int index = r + cycle * i;
            if (index >= length) {
                break;
            }
            result[cursor++] = chars[index];
            index = secondPosition + cycle * i;
            if (index >= length) {
                break;
            }
            result[cursor++] = chars[index];
        }
    }

    public static void main(String[] args) {
        Problem6 problem6 = new Problem6();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            if (i % 10000000 == 0) {
                System.out.print(i + " ");
            }
            problem6.convert("PAYPALISHIRING", 3);
        }
        System.out.println();
        System.out.println(System.currentTimeMillis() - start);
    }
}
