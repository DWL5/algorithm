package dfs_bfs;

import java.util.Scanner;

public class PermutationGuessingSequence {
    static int n;
    static int f;
    static int[] b;
    static int[] p;
    static int[] ch;
    boolean flag = false;
    int[][] arr = new int[35][35];

    public int combination(int n, int r) {
        if (arr[n][r] > 0) return arr[n][r];
        if (n == r || r == 0) return 1;
        else return arr[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }

    public void dfs(int l, int sum) {
        if (flag) return;
        if (l == n) {
            if (sum == f) {
                for (int x : p) {
                    System.out.print(x + " ");
                    flag = true;
                }
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    p[l] = i;
                    dfs(l + 1, sum + (p[l] * b[l]));
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        PermutationGuessingSequence guessingSequence = new PermutationGuessingSequence();
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        f = scanner.nextInt();
        b = new int[n];
        p = new int[n];
        ch = new int[n + 1];

        for (int i = 0; i < n; i++) {
            b[i] = guessingSequence.combination(n - 1, i);
        }

        guessingSequence.dfs(0, 0);
    }
}
