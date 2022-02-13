package dfs_bfs;

public class BinaryTree {
    Node root;
    public void DFS(Node root) {
        if (root == null) return;
        else {
            System.out.println(root.data); //전위순회
            DFS(root.left);
            System.out.println(root.data); //중위순회
            DFS(root.right);
            System.out.println(root.right); //후위순회
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(3);
        binaryTree.root.left.left = new Node(4);
        binaryTree.root.left.right = new Node(5);
        binaryTree.root.right.left = new Node(6);
        binaryTree.root.right.right = new Node(7);
        binaryTree.DFS(binaryTree.root);
    }
}

class Node {
    int data;
    Node left, right;
    public Node(int data) {
        this.data = data;
        left=right=null;
    }
}
