package kakao;

/**
 * 플로이드 와샬
 * 모든 지점에 대해
 * 경유지를 정하고
 * 경유지로 부터 B와 A 최단 경로 값을 더하기
 * 결국은 완전탐색
 */
public class Taxi {
    //플로이드 와샬에서 사용할 dist 배열
    int[][] dist = new int[201][201];

    public int solution(int n, int s, int a, int b, int[][] fares) {

        //dist 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = 200 * 1000000;
                }
            }
        }

        for (int[] edge : fares) {
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }

        //플로이드 와샬 알고리즘
        floyd(n);
        int answer = Integer.MAX_VALUE;

        //합승해서 갈 지점
        for (int k = 1; k <= n; k++) {
            // 합승해서 갈 지점 + 합승지점에서 a 거리 + 합승지점에서 b 거리
            answer = Math.min(answer, dist[s][k] + dist[k][a] + dist[k][b]);
        }
        return answer;
    }

    void floyd(int n) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }
}
