package two_pointer;

import java.util.Scanner;

public class ContinuousSequence {

    private int solve(int n, int m, int[] arr) {
        int answer = 0;
        int left = 0;
        int right = 0;
        int sum = arr[right];

        while (right < n) {
            System.out.println("left : " + left + " right : " + right + " sum : " + sum);
            if (sum == m) {
                answer++;
                sum -= arr[left++];
                sum += arr[right++];
            } else if (sum < m) {
                right++;
                if (right >= n) break;
                sum += arr[right];
            } else {
                sum -= arr[left++];
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        ContinuousSequence continuousSequence = new ContinuousSequence();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(continuousSequence.solve(n, m, arr));
    }
}
