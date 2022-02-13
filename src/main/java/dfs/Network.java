package dfs;

public class Network {
    boolean[] visit;
    int[][] computers;
    public void dfs(int node) {
        if (visit[node] == true) return;
        visit[node] = true;
        for (int i = 0; i < computers[node].length; i++) {
            if (node == i) continue;
            if (computers[node][i] == 1) {
                dfs(i);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.computers = computers;
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
}
