package leetcode;

public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int anchor = 0;
        char[] chars = s.toCharArray();
        int length = chars.length;
        Cache cache = new Cache();
        for (int i = 0; i < length; i++) {
            int size = cache.size;
            if (length - i + size <= result) return result;
            char current = chars[i];
            if (cache.contains(current)) {
                result = Math.max(size, result);
                for (int j = anchor; j < i; j++) {
                    char anchorChar = chars[j];
                    if (anchorChar == current) {
                        anchor = j + 1;
                        break;
                    } else {
                        cache.remove(anchorChar);
                    }
                }
            } else {
                cache.add(current);
            }
        }
        result = Math.max(cache.size(), result);
        return result;
    }

    private static class Cache {
        private long table = 0L;
        private long table2 = 0L;
        private byte size = 0;

        public void add(char c) {
            if (c >= 64) {
                long target = 1L << c - 64;
                if ((target & table2) != target) {
                    table2 = table2 + target;
                    size++;
                }
            } else {
                long target = 1L << c;
                if ((target & table) != target) {
                    table = table + target;
                    size++;
                }
            }
        }

        public void remove(char c) {
            if (c >= 64) {
                long target = 1L << c - 64;
                if ((target & table2) == target) {
                    table2 = table2 - target;
                    size--;
                }
            } else {
                long target = 1L << c;
                if ((target & table) == target) {
                    table = table - target;
                    size--;
                }
            }
        }

        public boolean contains(char c) {
            if (c >= 64) {
                long target = 1L << c - 64;
                return (target & table2) == target;
            } else {
                long target = 1L << c;
                return (target & table) == target;
            }
        }

        public int size() {
            return size;
        }
    }

    public int calc(String s) {
        int result = 0;
        int anchor = 0;
        char[] chars = s.toCharArray();
        int[] charIndexes = new int[128];
        for (int index = 0; index < chars.length; index++) {
            char current = chars[index];
            anchor = Math.max(anchor, charIndexes[current]);
            charIndexes[current] = index + 1;
            result = Math.max(result, index - anchor + 1);
        }
        return result;
    }
}
