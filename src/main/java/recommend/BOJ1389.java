package recommend;

import java.util.Scanner;

/**
 * 플로이드와샬
 * 케빈 베이컨의 6단계 법칙
 * https://www.acmicpc.net/group/workbook/view/11689/36394
 */
public class BOJ1389 {
    private static int n; //유저의 수
    private static int m; //친구관계의 수
    private static int[] answer; // 정답 친구 번호
    private static int[] minDistance; // 친구 최단경로
    private static int[][] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        distance = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) distance[i][j] = 0;
                else distance[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            distance[start][end] = 1;
            distance[end][start] = 1;
        }

        floyd();

        int[] answerArr = new int[n + 1];
        int min = Integer.MAX_VALUE;
        int minIdx = 0;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                sum += distance[i][j];
            }
            answer[i] = sum;
            if (sum < min) {
                min = sum;
            }
        }

    }

    private static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]);
                }
            }
        }
    }
}
