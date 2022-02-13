package dfs_bfs;

import java.util.Scanner;

public class MaxScore {
    static int n;
    static int m;
    static int[] score;
    static int[] time;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        score = new int[n];
        time = new int[n];

        for (int i = 0; i < n; i++) {
            score[i] = scanner.nextInt();
            time[i] = scanner.nextInt();
        }

        dfs(0, 0, 0);
        System.out.println(max);
    }

    public static void dfs(int idx, int sumScore, int sumTime) {
        if (sumTime > m) {
            return;
        }
        if (idx == n) {
            if (sumScore > max) {
                max = sumScore;
            }
        } else {
            dfs(idx + 1, sumScore + score[idx], sumTime  + time[idx]);
            dfs(idx + 1, sumScore, sumTime);
        }
    }
}
