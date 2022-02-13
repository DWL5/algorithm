package dfs_bfs;

import java.util.Scanner;

/**
 * 조합수
 * 메모이제이션
 */
public class CombinationCount {
    int[][] arr = new int[35][35];

    public int DFS(int n, int r) {
        if (arr[n][r] > 0) return arr[n][r];
        if (n == r || r == 0) return 1;
        else return arr[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
    }


    public static void main(String[] args) {
        CombinationCount combinationCount = new CombinationCount();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        System.out.println(combinationCount.DFS(n, r));
    }
}
