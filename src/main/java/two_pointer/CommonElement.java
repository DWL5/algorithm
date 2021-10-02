package two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 공통원소 구하기
 * 두 배열을 오름차순 정렬한다.
 * 두 개의 포인터를 비교하며 작은 값의 포인터를 증가
 * 두 개의 포인터가 가르키는 값이 같으면 공통원소
 * 이 때는 두 포인터의 값을 모두 증가 시킨다.
 */
public class CommonElement {

    private ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
        int p1 =0, p2 = 0;
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);

        while (p1 < n && p2 < m) {
            if (a[p1] > b[p2]) {
                p2++;
            } else if (a[p1] < b[p2]) {
                p1++;
            } else {
                result.add(a[p1]);
                p1++;
                p2++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        CommonElement commonElement = new CommonElement();
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

        for (int x : commonElement.solution(n, m, a, b)) System.out.println(x + " ");
    }
}
