package kakao;

public class LyricsSearch {

    Trie[] tries = new Trie[100001];
    Trie[] reverseTries = new Trie[100001];

    public int[] solution(String[] words, String[] query) {
        int[] answer = new int[query.length];
        int ansIdx = 0;

        for (String str : words) {
            int len = str.length();
            if (tries[len] == null) {
                tries[len] = new Trie();
                reverseTries[len] = new Trie();
            }

            tries[len].insert(str);
            str = new StringBuilder(str).reverse().toString();
            reverseTries[len].insert(str);
        }

        for (String str : query) {
            int idx = str.length();
            if (tries[idx] == null) {
                answer[ansIdx++] = 0;
                continue;
            }

            if (str.charAt(0) != '?') {
                //정방향
                answer[ansIdx++] = tries[idx].search(str);
            } else {
                //역방향
                str = new StringBuilder(str).reverse().toString();
                answer[ansIdx++] = reverseTries[idx].search(str);
            }
        }
        return answer;
    }

    class Trie {
        Trie[] child = new Trie[26];
        int count;

        void insert(String str) {
            Trie curr = this;
            for (char ch : str.toCharArray()) {
                curr.count++;
                int idx = Character.getNumericValue(ch) - Character.getNumericValue('a');
                if (curr.child[idx] == null) {
                    curr.child[idx] = new Trie();
                }
                curr = curr.child[idx];
            }

            curr.count++;
        }

        int search(String str) {
            Trie curr = this;
            for (char ch : str.toCharArray()) {
                if (ch == '?') return curr.count;

                curr = curr.child[Character.getNumericValue(ch) - Character.getNumericValue('a')];
                if (curr == null) {
                    return 0;
                }
            }
            return curr.count;
        }
    }
}
