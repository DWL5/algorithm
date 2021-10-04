package hash;
import java.util.*;

/**
 * 프로그래머스 다단계 칫솔 판매
 * 재귀, 해쉬
 * 더 이상 재귀를 수행해도 되지 않을 때, return 시켜주는 조건 찾기..
 * 이 문제에서는 moeny가 0이되면 더이상 재귀를 수행하지 않아도 됨.
 */

public class MultiLevelBrush {
    HashMap<String, Integer> idxMap;
    HashMap<String, String> parentMap;
    int[] answer;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        answer = new int[enroll.length];
        idxMap = new HashMap<>();
        parentMap = new HashMap<>();

        for(int i = 0; i < enroll.length; i++) {
            String ref = referral[i];
            String en = enroll[i];

            idxMap.put(en, i);
            parentMap.put(en, ref);
        }

        for(int i = 0; i < seller.length; i++) {
            calculate(seller[i], 100 * amount[i]);
        }

        return answer;
    }

    private void calculate(String seller, int money) {
        if (seller.equals("-")) {
            return;
        }

        //와우...
        if (money == 0) {
            return;
        }

        answer[idxMap.get(seller)] = answer[idxMap.get(seller)] + money - (money / 10);
        calculate(parentMap.get(seller), money / 10);
    }
}
