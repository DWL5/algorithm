package kakao;

import java.util.*;


public class MenuRenewal {
    Map<String, Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
       ArrayList<String> answer = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            String temp = orders[i];
            for (int c : course) {
                if (temp.length() < c) {
                    continue;
                }
                char[] chars = new char[c];
                char[] tempChars = temp.toCharArray();
                Arrays.sort(tempChars);
                combination(tempChars, chars, temp.length(), c, 0,0);
            }
        }

        for (int c : course) {
            int max = 0;
            ArrayList<String> result = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getKey().length() == c && entry.getValue() >=2) {
                    if (entry.getValue() > max) {
                        max = entry.getValue();
                        result.clear();
                        result.add(entry.getKey());
                    } else if(entry.getValue() == max) {
                        result.add(entry.getKey());
                    }
                }
            }
            answer.addAll(result);
        }
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    private void combination(char[] origin, char[] comArr, int n, int r, int index, int target) {
        if (r==0) {
            String s = "";
            for (char c : comArr) {
                s += c;
            }

            map.put(s, map.getOrDefault(s, 0) + 1);
            return;
        }
        if (target == n) return;

        comArr[index] = origin[target];
        combination(origin, comArr, n, r-1, index + 1, target + 1); //뽑는 경우
        combination(origin, comArr, n, r, index, target + 1); // 안뽑는 경우
    }
}
