package hash;
import java.util.*;

/**
 * 해쉬에 전화번호를 저장한다.
 * 전화번호를 돌면서 앞의 문자열을 하나씩 더해간다.
 * 문자열 더해가면서 해쉬에 저장된 키값중 더해진 문자열이 있는지 본다.
 * 더해진 문자열이 있고, 그게 현재 전화번호와 다르다면 '접두어'로 판단
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 */
public class PhoneNumber {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap();
        for(int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], 1);
        }

        Set<String> keys = map.keySet();
        for(int i = 0; i < phone_book.length; i++) {
            String temp = "";
            for (int j = 0; j < phone_book[i].length(); j++) {
                temp += phone_book[i].charAt(j);
                if(keys.contains(temp) && !temp.equals(phone_book[i])) {
                    return false;
                }
            }
        }

        return answer;
    }
}
