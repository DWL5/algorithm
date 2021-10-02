package slidingwindow;

import java.util.Scanner;

public class MaxSales {

    public int solution(int n, int k, int[] arr) {
        int temp = 0;
        int last = k;
        int first = 0;

        for (int i = 0; i < k; i++) {
            temp += arr[i];
        }
        int answer = temp;
        while (last < arr.length) {
            temp -= arr[first++];
            temp += arr[last++];

            if (temp > answer) {
                answer = temp;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        MaxSales maxSales = new MaxSales();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr= new int[n];

        for (int i = 0; i < n ; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(maxSales.solution(n, k, arr));
    }
}
