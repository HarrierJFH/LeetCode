package leetcode;

public class Problem201 {

    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }
        int or = m | n;
        int xor = m ^ n;
        int result = 0;
        for (int i = 0x40000000; i > 0; i = i >> 1) {
            if ((i & xor) == i) {
                break;
            }
            result += i & or;
        }
        return result;
    }

    public static void main(String[] args) {
        Problem201 problem201 = new Problem201();
        System.out.println(problem201.rangeBitwiseAnd(5,7));
        System.out.println(problem201.rangeBitwiseAnd(0,1));
        System.out.println(problem201.rangeBitwiseAnd(0B1100000,0B1111111));
    }

}
