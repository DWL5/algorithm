package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Tree 말단노드 까지 가장 깗은 경로
 */
public class Bfs {
    static Node root;
    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
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
            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                if (node.right == null && node.left == null) {
                    System.out.println("level : " + l);
                    return;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            l++;
        }
    }
}
