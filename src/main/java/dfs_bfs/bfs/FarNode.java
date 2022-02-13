package dfs_bfs.bfs;

import java.util.*;

class FarNode {
    public int solution(int n, int[][] edge) {
        int[] dist = new int[n + 1];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = -1;
        }
        int answer = 0;
        dist[1] = 0;

        HashMap<Integer, ArrayList<Integer>> edgeMap = new HashMap<>();

        for (int[] e : edge) {
            ArrayList<Integer> list = edgeMap.getOrDefault(e[0], new ArrayList<>());
            list.add(e[1]);
            edgeMap.put(e[0], list);
            list = edgeMap.getOrDefault(e[1], new ArrayList<>());
            list.add(e[0]);
            edgeMap.put(e[1], list);
        }

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = edgeMap.get(1);
        for (int i = 0; i < list.size(); i++) {
            queue.offer(list.get(i));
        }

        int d = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int node = queue.poll();
                if (dist[node] > 0) {
                    continue;
                }
                dist[node] = d;
                ArrayList<Integer> l = edgeMap.get(node);
                for (int e : l) {
                    if (dist[e] < 0) {
                        queue.offer(e);
                    }
                }
            }
            d++;
        }

        int max = Arrays.stream(dist).max().getAsInt();

        for (int x : dist) {
            System.out.println(x);
            if (x == max) {
                answer++;
            }
        }

        return answer;
    }
}