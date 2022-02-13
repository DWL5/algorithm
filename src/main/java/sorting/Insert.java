package sorting;

import java.util.Scanner;

public class Insert {
    public int[] solution(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            int temp = arr[i], j;
            for (j =  i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        Selection main = new Selection();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int x : main.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
