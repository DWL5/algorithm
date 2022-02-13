package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BfsBinaryTreeSearch {
    static Node root;
    public static void main(String[] args) {
        BfsBinaryTreeSearch bfsBinaryTreeSearch = new BfsBinaryTreeSearch();
        bfsBinaryTreeSearch.root = new Node(1);
        bfsBinaryTreeSearch.root.left = new Node(2);
        bfsBinaryTreeSearch.root.right = new Node(3);
        bfsBinaryTreeSearch.root.left.left = new Node(4);
        bfsBinaryTreeSearch.root.left.right = new Node(5);
        bfsBinaryTreeSearch.root.right.left = new Node(6);
        bfsBinaryTreeSearch.root.right.right = new Node(7);
        BFS(root);
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int l = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            System.out.print("level : " + l + " - ");
            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            l++;
            System.out.println("");
        }
    }
}
