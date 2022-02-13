package dfs_bfs;

import java.util.Scanner;

public class Island {
    static int[] xArr = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] yArr = {0, 1, 0, -1, 1, -1, 1, -1};
    static int n;
    static int[][] arr;
    static int count = 0;
    static int check = 2;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    count++;
                    dfs(i, j);
                    check++;
                }
            }
        }

        System.out.println(count);
    }

    public static void dfs(int x, int y) {
        if (arr[x][y] != 1) {
            return;
        } else {
            arr[x][y] = check;
            for (int i = 0; i < xArr.length; i++) {
                int nextX = x + xArr[i];
                int nextY = y + yArr[i];
                if (nextX >= 0 && nextX < n
                        && nextY >= 0 && nextY < n) {
                    dfs(nextX, nextY);
                }
            }
        }
    }
}
