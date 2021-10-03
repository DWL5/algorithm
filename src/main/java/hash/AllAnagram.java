package hash;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 모든 아나그램 찾기
 * Hash, TwoPointer, SlidingWindow
 */
public class AllAnagram {

    private int solution(String a, String b) {
        int answer = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();

        for (char x : b.toCharArray()) {
            bm.put(x, bm.getOrDefault(x, 0) + 1);
        }

        for (int i = 0; i < b.length(); i++) {
            am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) + 1);
        }

        if (am.equals(bm)) {
            answer++;
        }

        int left = 0;
        int right = b.length() - 1;
        while (right < a.length()) {
            am.put(a.charAt(left), am.get(a.charAt(left)) - 1);
            if (am.get(a.charAt(left)) == 0) {
                am.remove(a.charAt(left));
            }
            left++;
            right++;
            if (right >= a.length()) {
                break;
            }
            am.put(a.charAt(right), am.getOrDefault(a.charAt(right), 0) + 1);

            if (am.equals(bm)) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        AllAnagram allAnagram = new AllAnagram();
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b= scanner.next();
        System.out.println(allAnagram.solution(a, b));
    }
}
