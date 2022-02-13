package permutation_combination;

import java.util.Scanner;

public class TwoSum {
    static int N;
    static int[] Arr = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            Arr[i] = sc.nextInt();
        }

        System.out.println(solve());
    }

    static int solve() {
        int ret = 0;
        for (int i = 0; i < 1 << N; i++) {
            if (Integer.bitCount(i) != 2) {
                // 두수의 합만 경우의 수로 세어야 하기 때문
                continue;
            }

            int sum = 0;
            for (int j = 0; j < N; j++) {
                if ((i & 1 << j) != 0) {
                    sum += Arr[j];
                }
            }

            if (sum == 7) ret++;
        }

        return ret;
    }
}
