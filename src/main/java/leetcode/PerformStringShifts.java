package leetcode;

public class PerformStringShifts {

    public String stringShift(String s, int[][] shift) {
        if (s.length() == 1) {
            return s;
        }
        int offset = 0;
        for (int[] ints : shift) {
            if (ints[0] == 0) {
                offset -= ints[1];
            } else {
                offset += ints[1];
            }
        }
        offset = offset % s.length();
        if (offset == 0) {
            return s;
        } else if (offset < 0) {
            offset += s.length();
        }
        return s.substring(s.length() - offset) + s.substring(0, s.length() - offset);
    }

}
