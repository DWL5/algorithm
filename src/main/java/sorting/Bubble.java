package sorting;

import java.util.Scanner;

public class Bubble {
    public int[] solution(int n, int[] arr) {
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1]  = temp;
                }
            }
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
