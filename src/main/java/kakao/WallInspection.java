package kakao;

import java.util.Arrays;

/**
 * 외벽점검
 * 완전탐색 원형배
 */
public class WallInspection {
    int N, MinCnt;
    int[] Weak;
    int[] Dist;
    public int solution(int n, int[] weak, int[] dist) {
        //오름차순 정렬
        Arrays.sort(dist);
        int answer = 0;

        N = n;
        Weak = weak;
        Dist = dist;
        MinCnt = Dist.length + 3;

        for (int i = 0; i < Weak.length; i++) {
            solve(1, i, 0);
        }

        if (MinCnt == dist.length + 3) {
            return -1;
        }

        return MinCnt;
    }

    // cnt - 현재 사용된 친구
    // pos - 시작점
    // visited - 취약점 방문했는지
    void solve(int cnt, int pos, int visited) {
        if (cnt > Dist.length) return;
        if (cnt >= MinCnt) return;
        for (int i = 0; i < Weak.length; i++) {
            // 시작 위치에서 부터 모든 취약점을 돈다.
            int nextPos = (pos + i) % Weak.length;
            int diff = Weak[nextPos] - Weak[pos];

            if (nextPos < pos) {
                diff += N;
            }

            if (diff > Dist[Dist.length - cnt]) {
                break;
            }

            visited |= 1 << nextPos;
        }

        if (visited == (1 << Weak.length) - 1) {
            MinCnt = cnt;
        }

        for (int i = 0; i < Weak.length; i++) {
            //&연산 둘다 1이면 1 -> 방문 햇음
            if((visited & (1 << i)) != 0) continue;

            solve(cnt + 1, i, visited);
        }
    }
}
