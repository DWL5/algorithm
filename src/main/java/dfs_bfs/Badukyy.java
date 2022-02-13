package dfs_bfs;

import java.util.Scanner;

public class Badukyy {
    static int n;
    static int c;
    static int[] w;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        c = scanner.nextInt();
        n = scanner.nextInt();
        w = new int[n];

        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }

        dfs(0, 0);
        System.out.println(max);
    }

    public static void dfs(int idx, int accum) {
        if (accum > c) {
            return;
        }
        if (idx == n) {
            if (max < accum) {
                max = accum;
            }
        } else {
            dfs(idx + 1, accum + w[idx]);
            dfs(idx + 1, accum);
        }
    }
}
