package dfs_bfs;

public class Binary {
    public void DFS(int n) {
        if (n == 0) return;
        else {
            DFS(n/2);
            System.out.println(n % 2+ " ");
        }
    }

    public static void main(String[] args) {
        Binary binary = new Binary();
        binary.DFS(11);
    }
}
