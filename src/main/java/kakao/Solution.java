package kakao;

public class Solution {
    int[] info;
    boolean[] check;
    int sheep = 0;
    int wolf = 0;
    int[][] map;

    public int solution(int[] info, int[][] edges) {
        this.info = info;
        check = new boolean[info.length];
        map = new int[info.length][info.length];

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            map[edge[0]][edge[1]] = 1;
            map[edge[1]][edge[0]] = 1;
        }

        DFS(0);
        return sheep;
    }

    public void DFS(int v) {
        if (v >= info.length) {
            return;
        } else {
            check[v] = true;
            if (info[v] == 0) {
                if (sheep > wolf) {
                    this.sheep++;
                } else if (v == 0) {
                    this.sheep++;
                }
            } else {
                this.wolf++;
            }

            for (int i = 0; i < map[v].length; i++) {
                if (map[v][i] == 1 && !check[i]) {
                    check[i] = true;
                    DFS(i);
                    check[i] = false;
                    DFS(i);
                }
            }
        }
    }
}
