package dfs_bfs;

import java.util.Scanner;

public class SameSumSubset {
    static int n;
    static int[] numbers = new int[n];
    static int[] ch = new int[n];
    static String answer = "NO";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        numbers = new int[n];
        ch = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int start) {
        if (start == n) {
            int selected = 0;
            int unSelected = 0;
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == 1) {
                    selected += numbers[i];
                } else {
                    unSelected += numbers[i];
                }
            }

            if (selected == unSelected) {
                answer = "YES";
                System.out.println(answer);
                System.exit(0);
            }
        } else {
            ch[start] = 1;
            dfs(start + 1);
            ch[start] = 0;
            dfs(start + 1);
        }
    }
}
