package greedy;

import java.util.ArrayList;
import java.util.Collections;

public class BigNumber {
    public String solution(String number, int k) {
        String answer = "";
        int len = number.length();
        int remain = k;
        ArrayList<Integer> arr = new ArrayList<>();

        for (char c : number.toCharArray()) {
            arr.add(c - '0');
        }

        arr.sort(Collections.reverseOrder());
        int idx = 0;
        while (remain > 0) {
            int max = arr.get(idx);
            int maxIdx = number.indexOf(String.valueOf(max));
            if (maxIdx <= remain) {
                answer += max;
                number = number.substring(maxIdx + 1);
                arr.remove(idx);
                idx = 0;
                remain -= maxIdx;
                if (answer.length() >= len - k) {
                    return answer;
                }
                continue;
            }
            idx++;
        }
        return answer + number;
    }

    public static void main(String[] args) {
        System.out.println(new BigNumber().solution("11111111", 2));
    }
}
