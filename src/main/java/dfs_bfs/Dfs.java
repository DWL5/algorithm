package dfs_bfs;

/**
 * Tree 말단노드 까지 가장 깗은 경로
 */
public class Dfs {
    class Node {
        int data;
         Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void main(String[] args) {
    }

    public int dfs(int l, Node root) {
        if (root.left == null && root.right == null) {
            return l;
        } else {
            return Math.min(dfs(l + 1, root.left), dfs(l + 1, root.right));
        }
    }
}
