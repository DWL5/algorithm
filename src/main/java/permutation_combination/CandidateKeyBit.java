package permutation_combination;

import java.util.*;

public class CandidateKeyBit {
    public int solution(String[][] relation) {
        int answer = 0;
        int rowSize = relation.length;
        int colSize = relation[0].length;

        List<Integer> candidates = new LinkedList<Integer>();

        for (int i = 1; i < 1 << colSize; i++) {
            if (check(relation, rowSize, colSize, i)) {
                candidates.add(i);
            }
        }

        Collections.sort(candidates, new Comparator<Integer>() {
            int countBits(int n) {
                int ret = 0;
                while (n != 0) {
                    if ((n & 1) != 0) {
                        ret++;
                    }
                    n = n >> 1;
                }
                return ret;
            }

            @Override
            public int compare(Integer o1, Integer o2) {
                int x = countBits(o1);
                int y = countBits(o2);
                //속성을 적게 가진 순서대로 정렬
                if (x > y) {
                    return  1;
                } else if (x < y) {
                    return  -1;
                } else {
                    return 0;
                }
            }
        });

        while (candidates.size() != 0) {
            int n = candidates.remove(0);
            answer++;

            //최소성 만족하지 못하는 것 삭제
            for (Iterator<Integer> it = candidates.listIterator(); it.hasNext();) {
                int c = it.next();
                if ((n & c) == n) {
                    it.remove();
                }
            }
        }
        return answer;
    }

    private boolean check(String[][] relation, int rowSize, int colSize, int subset) {
        for (int i = 0; i < rowSize -1; i++) {
            for (int j = i + 1; j < rowSize; j++) {
                boolean isSame = true;
                for (int k = 0; k < colSize; k++) {
                    if ((subset & 1 << k) == 0) continue;
                    if (!relation[i][k].equals(relation[j][k])) {
                        isSame = false;
                        break;
                    }
                }

                if (isSame) {
                    return false;
                }
            }
        }
        return true;
    }
}
