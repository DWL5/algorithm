package dfs_bfs;

public class Factorial {

    public static int DFS(int n) {
        if (n == 1) return 1;
        else return n * DFS(n - 1);
    }

    public static void main(String[] args) {

        System.out.println(DFS(5));

    }
}
