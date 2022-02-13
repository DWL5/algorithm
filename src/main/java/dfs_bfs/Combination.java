package dfs_bfs;

import java.util.Scanner;

public class Combination {
    static int[] ch;
    static int[] arr;
    static int n;
    static int m;

    public void dfs(int level, int start) {
        if (level == m) {
            for (int x : arr) {
                System.out.print(x + " ");
            }

            System.out.println(" ");
        }
        else {
            for (int i = start; i <= n; i++) {
                arr[level] = i;
                dfs(level + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        arr = new int[m];
        ch = new int[n  + 1];

        Combination combination = new Combination();
        combination.dfs(0, 1);
    }
}
