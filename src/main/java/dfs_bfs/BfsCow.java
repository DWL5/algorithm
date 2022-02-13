package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 상태트리 탐색
 */

public class BfsCow {
    int answer = 0;
    int[] dist = {1, -1, 5};
    int[] ch;
    Queue<Integer> queue = new LinkedList();

    public int BFS(int s, int e) {
        ch = new int[10001];
        ch[s] = 1;
        queue.offer(s);
        int level = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int d = queue.poll();
                if (d == e) return level;
                for (int j = 0; j < dist.length; j++) {
                    int nx = d + dist[j];
                    if (nx>= 1 && nx<= 10000 && ch[j] == 0) {
                        ch[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            level++;
        }

        return level;
    }

    public static void main(String[] args) {
        BfsCow bfsCow = new BfsCow();
        System.out.println(bfsCow.BFS(5, 14));
    }
}
