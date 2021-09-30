package array;

import java.util.Scanner;

/**
 * 2차원 배열 로테이션을 구현해 본다.
 */
public class ArrayRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        int k = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = k++;
            }
        }

        System.out.println("회전 하기 전");
        print(n, arr);

        System.out.println("시계 방향 90도 회전");
        print(n, rotate90(n, arr));

        System.out.println("시계 방향 180도 회전");
        print(n, rotate180(n, arr));

        System.out.println("시계 방향 270도 회전");
        print(n, rotate270(n, arr));
    }

    public static int[][] rotate90(int n, int[][] arr) {
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[j][n - i - 1] = arr[i][j];
            }
        }

        return arr;
    }

    public static int[][] rotate180(int n, int[][] arr) {
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[n - i - 1][n - j - 1] = arr[i][j];
            }
        }
        return temp;
    }

    public static int[][] rotate270(int n, int[][] arr) {
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[n - j - 1][i] = arr[i][j];
            }
        }
        return temp;
    }

    public static void print(int n, int[][] arr){
        // print
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
