package leetcode;

import java.util.*;

public class Problem1233 {

    public List<String> removeSubfolders(String[] folder) {
        Folder[] folders = new Folder[18279];
        int[] hitLocations = new int[18279];
        int hitLocationIndex = 0;

        outer:
        for (String s : folder) {
            Folder f = new Folder(s);
            int location = f.location();
            Folder f1 = folders[location];
            if (f1 == null) {
                folders[location] = f;
                hitLocations[hitLocationIndex++] = location;
            } else {
                Folder previous = null;
                do {
                    int compareTo = f.compareTo(f1);
                    if (compareTo == Integer.MIN_VALUE) {
                        if (previous == null) {
                            folders[location] = f;
                        } else {
                            previous.next = f;
                        }
                        f.next = f1.next;
                        f1 = f.next;
                    } else if (compareTo == Integer.MAX_VALUE) {
                        continue outer;
                    } else if (compareTo > 0) {
                        if (f1.next == null) {
                            f1.next = f;
                        } else {
                            previous = f1;
                            f1 = f1.next;
                        }
                    } else if (compareTo < 0) {
                        if (previous == null) {
                            folders[location] = f;
                        } else {
                            previous.next = f;
                        }
                        f.next = f1;
                        break;
                    } else {
                        continue outer;
                    }
                } while (f1 != null);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < hitLocationIndex; i++) {
            Folder f = folders[hitLocations[i]];
            result.add(f.s);
            while (f.next != null) {
                f = f.next;
                result.add(f.s);
            }
        }

        return result;
    }

    private int compare(String s1, String s2) {
        char c1, c2;
        for (int i = 1; i < Math.min(s1.length(), s2.length()); i++) {
            c1 = s1.charAt(i);
            c2 = s2.charAt(i);

        }
        return 1;
    }

    private static class Folder {
        private final String s;
        private final String[] path = new String[50];
        private final int realLength;
        private Folder next;

        public Folder(String s) {
            this.s = s;
            int p = 0;
            for (int i = 1; ; ) {
                int j = s.indexOf('/', i);
                if (j == -1) {
                    path[p++] = s.substring(i);
                    break;
                } else {
                    path[p++] = s.substring(i, j);
                    i = j + 1;
                }
            }
            realLength = p;
        }

        public int location() {
            String path0 = path[0];
            int length = path0.length();
            char c = path0.charAt(0);
            int result = 0;
            for (int i = 0; i < 3; ) {
                result = (c - 96) + result * 26;
                if (i + 1 == length) {
                    return result;
                } else {
                    c = path0.charAt(++i);
                }
            }
            return result;
        }

        public int compareTo(Folder another) {
            for (int i = 0; i < Math.min(realLength, another.realLength); i++) {
                int compareTo = this.path[i].compareTo(another.path[i]);
                if (compareTo != 0) {
                    return compareTo;
                }
            }
            return realLength > another.realLength ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        @Override
        public String toString() {
            return s;
        }
    }

    public static void main(String[] args) {
//        Problem1233 problem1233 = new Problem1233();
//        System.out.println(problem1233.removeSubfolders(new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"}));

        System.out.println((int) '/');
    }

}
