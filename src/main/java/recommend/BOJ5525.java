package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문자열, DP
 * IOIOI
 * https://www.acmicpc.net/problem/5525
 */
public class BOJ5525 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int answer = 0;
        int[] dp = new int[m];

        for (int i = 2; i < m; i++) {
            String temp = s.substring(i - 2, i + 1);
            if (temp.equals("IOI")) {
                dp[i] = dp[i - 2] + 1;
            }

            if (dp[i] >= n) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
