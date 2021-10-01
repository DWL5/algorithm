package two_pointer;

import java.util.ArrayList;
import java.util.Scanner;

public class MixTwoArray {

    private ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
        int p1 = 0;
        int p2 = 0;

        ArrayList<Integer> answer = new ArrayList<>();

        while (p1 < n && p2 < m) {
            if (a[p1] > b[p2]) {
                answer.add(b[p2++]);
            } else {
                answer.add(a[p1++]);
            }
        }

        while (p1 < n) answer.add(a[p1++]);
        while (p2 < n) answer.add(b[p2++]);
        return answer;
    }

    public static void main(String[] args) {
        MixTwoArray mixTwoArray = new MixTwoArray();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];

        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        for (int x : mixTwoArray.solution(n, m, a, b)) {
            System.out.print(x + " ");
        }
    }
}
