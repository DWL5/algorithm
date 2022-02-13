package graph;

import java.util.Scanner;

public class FloydWarshall {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = sc.nextInt();
                if (i != j && d[i][j] == 0) { //자기 자신으로의 인접이 아니고, 갈 수 없다면
                    d[i][j] = INF;
                }
            }
        }

        for (int k = 0; k < n; k++) { //경유지
            for (int i = 0; i < n; i++) { //출발지
                if (i == k) continue;
                for (int j = 0; j < n; j++) { // 도착지
                    if (j==k || i==j) continue; // 경유지와 도착지가 같거나 출발지와 도착지가 같다면 패스
                    if (d[i][k] + d[k][j] < d[i][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }
    }
}
