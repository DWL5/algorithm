package str;
import java.util.*;

/*
* https://programmers.co.kr/learn/courses/30/lessons/81301
*/
public class NumberStr {
    String[] arr = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    HashMap<String, Integer> map = new HashMap();
    public int solution(String s) {
        String answer = "";

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        String temp = "";
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                answer += (c - 48);
                temp = "";
                continue;
            }

            temp += c;
            if (map.containsKey(temp)) {
                answer += map.get(temp);
                temp = "";
            }
        }
        return Integer.parseInt(answer);
    }
}
