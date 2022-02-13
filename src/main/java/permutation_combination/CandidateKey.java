package permutation_combination;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CandidateKey {
    private String[][] relation;
    ArrayList<String> keys = new ArrayList<>();

    public int solution(String[][] relation) {
        int answer = 0;
        this.relation = relation;
        for (int r = 1; r <= relation[0].length; r++) {
            int[] comArr = new int[r];
            combination(comArr, relation[0].length, r, 0, 0);
        }

        for (int i = 0; i < keys.size(); i++) {
            char[] pin = keys.get(i).toCharArray();
            boolean success = true;
            for (int j = 0; j < keys.size(); j++) {
                if (i == j) continue;
                char[] temp = keys.get(j).toCharArray();

                for (int k = 0; k < pin.length; k++) {
                    if (k >= temp.length) {
                    }

                    if (pin[k] == temp[k]) {
                        success = false;
                    }
                }
            }

            if (success) {
                answer++;
            }
        }
        return answer;
    }

    private void combination(int[] comArr, int n, int r, int index, int target) {
        if (r==0) {
            if (isUnique(comArr)) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < comArr.length; i++) {
                    sb.append(comArr[i]);
                }
                keys.add(sb.toString());
            }
            return;
        }
        if (target == n) return;

        comArr[index] = target;
        combination(comArr, n, r-1, index + 1, target + 1); //뽑는 경우
        combination(comArr, n, r, index, target + 1); // 안뽑는 경우
    }

    private boolean isUnique(int[] columns) {
        Set<String> tempTuples = new HashSet<>();
        for (String[] tuple: relation) {
            StringBuilder sb = new StringBuilder();
            for (Integer col : columns) {
                sb.append(tuple[col]);
            }
            if (!tempTuples.add(sb.toString())) return false;
        }
        return true;
    }
}
