package kakao;

import java.util.*;

public class SearchOrderFast {
    Map<String, Integer> wordMap = new HashMap<>();
    List<List<Integer>> scores = new ArrayList<>();

    public int[] solution(String[] info, String[] query) {
        wordMap.put("-", 0);
        wordMap.put("cpp", 1);
        wordMap.put("java", 2);
        wordMap.put("python", 3);
        wordMap.put("backend", 1);
        wordMap.put("frontend", 2);
        wordMap.put("junior", 1);
        wordMap.put("senior", 2);
        wordMap.put("chicken", 1);
        wordMap.put("pizza", 2);

        for (int i = 0; i < 4 * 3 * 3 * 3; i++) {
            scores.add(new ArrayList<>());
        }

        for (String str: info) {
            String[] word = str.split(" ");
            int[] arr = {wordMap.get(word[0]) *3*3*3,
                    wordMap.get(word[1]) *3*3,
                    wordMap.get(word[2]) *3,
                    wordMap.get(word[3])};
            int score = Integer.parseInt(word[4]);

            //16 부분집합
            for (int i = 0; i < (1 << 4); i++) {
                int idx = 0;
                //"-"는 무조건들어가야함
                //j번째 비트가 켜져있는지
                for (int j = 0; j < 4; j++) {
                    if ((i & (1 << j)) != 0) {
                        idx += arr[j];
                    }
                }
                scores.get(idx).add(score);
            }
        }

        for (int i = 0 ; i < 4 * 3 * 3 * 3; i++) {
            Collections.sort(scores.get(i));
        }

        int [] answer = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            String[] word = query[i].split(" ");
            int idx = wordMap.get(word[0]) *3*3*3
                    + wordMap.get(word[2]) *3*3
                    + wordMap.get(word[4]) *3
                    + wordMap.get(word[6]);

            int score = Integer.parseInt(word[7]);
            int ret = Collections.binarySearch(scores.get(idx), score);
            if (ret < 0) {
                ret = -(ret + 1);
            } else {
                for (int j = ret - 1; j >= 0; j--) {
                    if (scores.get(idx).get(j) == score) {
                        ret = j;
                    } else {
                        break;
                    }
                }
            }

            answer[i] = scores.get(idx).size() - ret;
        }

        return answer;
    }
}
