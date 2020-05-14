package leetcode;

public class Problem208 {

    private static class Trie {

        private Boolean end;
        private final Trie[] tries;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            end = false;
            tries = new Trie[26];
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            char[] chars = word.toCharArray();
            int start = 0, end = word.length(), i;
            Trie trie, cur = this;
            for (; ; ) {
                i = chars[start] - 97;
                trie = cur.tries[i];
                if (trie == null) {
                    trie = new Trie();
                    cur.tries[i] = trie;
                }
                if (end - start == 1) {
                    trie.end = true;
                    break;
                } else {
                    start++;
                    cur = trie;
                }
            }
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            char[] chars = word.toCharArray();
            int start = 0, end = word.length();
            Trie trie, cur = this;
            for (; ; ) {
                trie = cur.tries[chars[start] - 97];
                if (trie != null) {
                    if (end - start == 1) {
                        return trie.end;
                    } else {
                        ++start;
                        cur = trie;
                    }
                } else {
                    return false;
                }
            }
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            char[] chars = prefix.toCharArray();
            int start = 0, end = prefix.length();
            Trie trie, cur = this;;
            for (; ; ) {
                trie = cur.tries[chars[start] - 97];
                if (trie != null) {
                    if (end - start == 1) {
                        return true;
                    } else {
                        ++start;
                        cur = trie;
                    }
                } else {
                    return false;
                }
            }
        }

    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }

}
