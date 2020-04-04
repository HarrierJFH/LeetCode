package leetcode;

import java.util.*;

public class Problem1233 {

    public List<String> removeSubfolders(String[] folder) {
        Folder[] folders = new Folder[18279];
        int[] hitLocations = new int[32];
        int hitLocationIndex = 0;

        outer:
        for (String s : folder) {
            Folder f = new Folder(s);
            int location = f.location();
            Folder f1 = folders[location];
            if (f1 == null) {
                folders[location] = f;
                if (hitLocationIndex == hitLocations.length) {
                    hitLocations = Arrays.copyOf(hitLocations, hitLocationIndex * 2);
                }
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
            result.add(f.toString());
            while (f.next != null) {
                f = f.next;
                result.add(f.toString());
            }
        }

        return result;
    }

    private static class Folder {
        private String[] path = new String[8];
        private final int realLength;
        private Folder next;

        public Folder(String s) {
            int p = 0;
            for (int i = 1; ; ) {
                if (p == path.length) {
                    path = Arrays.copyOf(path, p * 2);
                }
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
            String[] anotherPath = another.path;
            for (int i = 0; i < Math.min(realLength, another.realLength); i++) {
                int compareTo = this.path[i].compareTo(anotherPath[i]);
                if (compareTo != 0) {
                    return compareTo;
                }
            }
            return realLength > another.realLength ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < realLength; i++) {
                stringBuilder.append('/').append(path[i]);
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        Problem1233 problem1233 = new Problem1233();
        System.out.println(problem1233.removeSubfolders(new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"}));
    }

}
