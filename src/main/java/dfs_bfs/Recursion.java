package dfs_bfs;

/**
 * 자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하세요.
 */
public class Recursion {
    public void DFS(int n) {
        if (n == 0) return;
        else {
            System.out.println(n);
            DFS(n-1);
        }
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        recursion.DFS(3);
    }
}
