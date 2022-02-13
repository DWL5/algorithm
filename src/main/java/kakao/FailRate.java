package kakao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FailRate {

    class Fail {
        int stage;
        double rate;

        public Fail(int stage, double rate) {
            this.stage = stage;
            this.rate = rate;
        }
    }

    public static void main(String[] args) {
        FailRate failRate = new FailRate();
        failRate.solution(4, new int[]{4,4,4,4});

    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<Fail> fails = new ArrayList<>();
        int total = stages.length;

        for (int i = 1; i <= N; i++) {
            int notClear = 0;
            for (int j = 0; j < stages.length; j++) {
                if (i == stages[j]) {
                    notClear++;
                }
            }
            System.out.println("total : " + total + "notClear : " + notClear/total);
            fails.add(new Fail(i, notClear/total));
            total -= notClear;

        }

        fails.sort(new Comparator<Fail>() {
            @Override
            public int compare(Fail o1, Fail o2) {
                return (int) (o1.rate - o2.rate);
            }
        });

        for (int i = 0; i < answer.length; i++) {
            answer[i] = fails.get(i).stage;
        }

        return answer;
    }
}
