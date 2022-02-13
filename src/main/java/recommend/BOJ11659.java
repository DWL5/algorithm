package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구간합
 * 구간 합 구하기 4
 * https://www.acmicpc.net/problem/11659
 */
public class BOJ11659 {
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        array = new int[n + 1];

        for (int i = 1; i <=n; i++) {
            array[i]=array[i-1]+Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
           st=new StringTokenizer(br.readLine());
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           System.out.println(array[b] - array[a-1]);
        }
    }
}
