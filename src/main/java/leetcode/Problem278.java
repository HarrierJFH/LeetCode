package leetcode;

import java.util.Random;

public class Problem278 {

    private final int firstBadVersion;

    public Problem278(int firstBadVersion) {
        this.firstBadVersion = firstBadVersion;
    }

    public int firstBadVersion(int n) {
        if (n == 1) {
            return 1;
        }
        int l = 1;
        int r = n;
        int middle;
        for (; ; ) {
            if (r - l == 1) {
                return isBadVersion(l) ? l : r;
            }
            middle = (r - l + 1) / 2 + l;
            if (isBadVersion(middle)) {
                r = middle;
            } else {
                l = middle;
            }
        }
    }

    private boolean isBadVersion(int version) {
        return version >= firstBadVersion;
    }

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int firstBadVersion = random.nextInt(10000) + 1;
            System.out.println(i + " " + firstBadVersion);
            Problem278 problem278 = new Problem278(firstBadVersion);
            int firstBadVersion1 = problem278.firstBadVersion(firstBadVersion + random.nextInt(10000));
            assert firstBadVersion == firstBadVersion1;
        }
    }

}
