package dfs_bfs;

public class BinaryTreeSearch {

    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public void DFS(Node root) {
        if (root == null) return;
        else {
            System.out.println(root.data + " "); // 전위순회
            DFS(root.left);
            //System.out.println(root.data + " "); // 중위순회
            DFS(root.right);
            //System.out.println(root.data + " "); // 후위순회
        }
    }
}
