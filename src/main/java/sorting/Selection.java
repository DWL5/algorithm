package sorting;

import java.util.Scanner;

/*
선택 정렬
제자리 정렬 알고리즘의 하나
입력 배열 이외에 다른 추가 메모리를 요구하지 않는 정렬방법
해당 순서에 원소를 넣을 위치는 이미 정해져 있고, 어떤 원소를 넣을지 선택하는 알고리즘
 */
public class Selection {

    public int[] solution(int n, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[idx]) {
                    idx = j;
                }
            }
            if (idx == i) {
                continue;
            }

            int temp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = temp;
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
