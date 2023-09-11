class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
}

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        Set<String> result = new HashSet<>();
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, trie.root, "", result);
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int x, int y, TrieNode node, String current, Set<String> result) {
        char ch = board[x][y];
        int index = ch - 'a';

        if (ch == '#' || node.children[index] == null) {
            return;
        }

        current += ch;
        TrieNode nextNode = node.children[index];

        if (nextNode.isEnd) {
            result.add(current);
            nextNode.isEnd = false;
        }

        board[x][y] = '#';

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                dfs(board, newX, newY, nextNode, current, result);
            }
        }

        board[x][y] = ch;
    }
}