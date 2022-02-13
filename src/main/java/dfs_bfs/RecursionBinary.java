package dfs_bfs;

public class RecursionBinary {

    public static void main(String[] args) {
        DFS(4);
    }

    public static void DFS(int n) {
        if (n == 0) return;
        else {
            DFS(n/2);
            System.out.print(n % 2);
        }
    }
}
