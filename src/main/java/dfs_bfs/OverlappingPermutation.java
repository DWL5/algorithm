package dfs_bfs;

import java.util.Scanner;

public class OverlappingPermutation {
    static int n;
    static int m;
    static int[] pick;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        pick = new int[m];
        dfs(0);
    }

    public static void dfs(int cnt) {
        if (cnt == m) {
            for (int i = 0; i < pick.length; i++) {
                System.out.print(pick[i] + " ");
            }
            System.out.println(" ");
            return;
        } else {
            for (int i = 1; i <= n; i++) {
                pick[cnt] = i;
                dfs(cnt + 1);
            }
        }
    }
}
