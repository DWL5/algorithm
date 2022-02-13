package dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 간선수
 */
public class BfsShortest {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;

    public void bfs(int v) {
        Queue<Integer> queue = new LinkedList();
        ch[v] = 1;
        dis[v] = 0;

        queue.offer(v);

        while (!queue.isEmpty()) {
            int cv = queue.poll();
            for (int nv: graph.get(cv)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    queue.offer(nv);
                    dis[nv] = dis[cv] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();

        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        ch = new int[n+1];
        dis = new int[n+1];

        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }

        ch[1] = 1;
        BfsShortest bfsShortest = new BfsShortest();
        bfsShortest.bfs(1);
        
        for (int i = 2; i <= n; i++) {
            System.out.println( i + " : " + dis[i]);
        }
    }

}
