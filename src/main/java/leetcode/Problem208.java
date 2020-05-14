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
            int i = 0, end = word.length() - 1, v;
            Trie trie, cur = this;
            for (; ; ) {
                v = word.charAt(i) - 97;
                trie = cur.tries[v];
                if (trie == null) {
                    trie = new Trie();
                    cur.tries[v] = trie;
                }
                if (i++ == end) {
                    trie.end = true;
                    break;
                } else {
                    cur = trie;
                }
            }
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            int i = 0, end = word.length() - 1;
            Trie trie, cur = this;
            for (; ; ) {
                trie = cur.tries[word.charAt(i) - 97];
                if (trie != null) {
                    if (i++ == end) {
                        return trie.end;
                    } else {
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
            int i = 0, end = prefix.length() - 1;
            Trie trie, cur = this;
            for (; ; ) {
                trie = cur.tries[prefix.charAt(i) - 97];
                if (trie != null) {
                    if (i++ == end) {
                        return true;
                    } else {
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
