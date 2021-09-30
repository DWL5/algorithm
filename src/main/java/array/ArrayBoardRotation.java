package array;

import java.util.Scanner;

/**
 * 2차원 배열 테두리 회전 시계방향
 */
public class ArrayBoardRotation {
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

        print(n, arr);
        System.out.println();
        rotateBoard(n, arr);
        print(n, arr);
    }

    /**
     * 회전을 위해 첫 숫자를 임시 저장한 뒤
     * 회전할 테두리의 왼쪽, 아래, 오른쪽, 윗변을 회전
     * @param n
     * @param arr
     */
    public static void rotateBoard(int n, int[][] arr) {
        int temp = arr[0][0];

        for (int i = 0; i < n - 1; i++) {
            arr[i][0] = arr[i + 1][0];
        }

        for (int i = 0; i < n - 1; i++) {
            arr[n - 1][i] = arr[n - 1][i + 1];
        }

        for (int i = n - 1; i > 0; i--) {
            arr[i][n - 1] = arr[i - 1][n - 1];
        }

        for (int i = n - 1; i > 1; i--) {
            arr[0][i] = arr[0][i - 1];
        }

        arr[0][1] = temp;
    }

    public static void print(int n, int[][] arr){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
