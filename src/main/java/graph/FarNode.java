package graph;

import java.util.Arrays;

public class FarNode {

    int[] unf;
    int[] dist;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        unf =  new int[n + 1];
        dist =  new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < edge.length; i++) {
            int[] pair = edge[i];
            union(pair[0], pair[1]);
        }

        for (int i = 1; i < n+1; i++) {
            find(i, i, 0);
        }

        int max = Arrays.stream(dist).max().getAsInt();
        for (int i = 2; i < dist.length; i++) {
            if (dist[i] == max) {
                answer++;
            }
        }
        return answer;
    }

    public int find(int v, int origin, int cnt) {
        if (v == unf[v]) {
            if (v==1) {
                if (dist[origin] > cnt) {
                    dist[origin] = cnt;
                }
            }
            return v;
        }
        else return unf[v] = find(unf[v], origin, cnt+1);
    }

    public void union(int a, int b) {
        int findA = find(a, a, 0);
        int findB = find(b, b, 0);

        if (findA != findB) {
            if (findA <= findB) {
                unf[findB] = findA;
            } else {
                unf[findA] = findB;
            }
        }
    }
}
