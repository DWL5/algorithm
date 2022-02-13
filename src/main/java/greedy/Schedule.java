package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Schedule {
    class Lecture implements Comparable<Lecture> {
        private int money;
        private int time;

        public Lecture(int money, int time) {
            this.money = money;
            this.time = time;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.time - this.time;
        }
    }

    static class Main {
        static int n, max = Integer.MIN_VALUE;

        public int solution(ArrayList<Lecture> arr) {
            int answer = 0;
            // 큰값을 우선순위로 하기
            PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
            Collections.sort(arr);

            int j = 0;
            for (int i = max; i >= 1; i--) {
                for (; j < n; j++) {
                    if (arr.get(j).time < i) break;
                    pQ.offer(arr.get(j).money);
                }

                if (!pQ.isEmpty()) answer+=pQ.poll();
            }
            return answer;
        }
    }
}
