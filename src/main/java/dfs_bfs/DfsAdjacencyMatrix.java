package dfs_bfs;

import java.util.Scanner;

/**
 * 방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요.
 * 모든 경로를 구하려면 ch를 풀어줘야함
 * 백트래킹
 */

public class DfsAdjacencyMatrix {
    static int n, m, answer = 0;
    static int[][] graph;
    static int[] ch;

    public void DFS(int v) {
        if (v == n) {
            answer++;
        } else {
            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();

        graph = new int[n + 1][n + 1];
        ch = new int[n+1];
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph[a][b] = 1;
        }

        ch[1] = 1;
        DfsAdjacencyMatrix dfsAdjacencyMatrix = new DfsAdjacencyMatrix();
        dfsAdjacencyMatrix.DFS(1);
        System.out.println(answer);
    }
}
