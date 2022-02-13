package kakao;

import java.util.ArrayList;
import java.util.List;

public class FindRoad {
    int idx = 0;
    List<Node> nodeList = new ArrayList<>();
    class Node {
        int index;
        int x, y;
        Node left;
        Node right;

        public Node(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }
    }

    public void addNode(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                addNode(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                addNode(parent.right, child);
            }
        }
    }

    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};

        for (int i = 0; i < nodeinfo.length; i++) {
            int[] xy = nodeinfo[i];
            nodeList.add(new Node(i + 1, xy[0], xy[1]));
        }

        nodeList.sort((o1, o2) -> {
            if (o1.y > o2.y) {
                return -1;
            } else if (o1.y < o2.y) {
                return 1;
            } else {
                return o1.x - o2.x;
            }
        });

        Node root = nodeList.get(0);
        for (int i = 1; i < nodeinfo.length; i++) {
            addNode(root, nodeList.get(i));
        }

        answer = new int[2][nodeinfo.length];
        preOrder(answer, root);
        idx = 0;
        postOrder(answer, root);

        return answer;
    }


    private void preOrder(int[][] answer, Node root) {
        if (root == null) {
            return;
        }

        answer[0][idx++] = root.index;
        preOrder(answer, root.left);
        preOrder(answer, root.right);
    }

    private void postOrder(int[][] answer, Node root) {
        if (root == null) {
            return;
        }

        postOrder(answer, root.left);
        postOrder(answer, root.right);
        answer[1][idx++] = root.index;
    }
}
