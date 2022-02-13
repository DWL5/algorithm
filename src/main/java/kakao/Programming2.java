package kakao;

import java.math.BigInteger;

class Programming2 {

    public int solution(int n, int k) {
        int answer = 0;
        String str = conversion(n, k);
        StringBuilder sb = new StringBuilder();
        boolean zero = false;
        for (char c : str.toCharArray()) {
            if (c == '0') {
                if (zero) {
                    continue;
                }
                zero = true;
            } else {
                zero = false;
            }
            sb.append(c);
        }

        String[] split = sb.toString().split("0");
        for (String s : split) {
            if (BigInteger.valueOf(Long.parseLong(s.trim())).isProbablePrime(10)) {
                answer++;
            }
        }

        return answer;
    }

    public String conversion(int number, int N){
        StringBuilder sb = new StringBuilder();
        int current = number;
        while(current > 0){
            if(current % N < 10){
                sb.append(current % N);
            } else {
                sb.append((char)(current % N - 10 + 'A'));
            }
            current /= N;
        }

        return sb.reverse().toString();
    }
}