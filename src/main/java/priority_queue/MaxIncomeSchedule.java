package priority_queue;

import java.util.*;

/**
 * Heap
 * 힙에 새 원소를 넣고 빼는 데에는 O(nlogn)의 시간 복잡도
 * PriorityQueue
 * N개의 기업이 강연 요청
 * 각 기업은 D일 안에 와서 강연을 해주면 M만큼 강연로를 주기로함
 * 각 기업의 요청한 D와 M을 바탕으로 가장 많은 돈을 벌 수 있도록 강연 스케줄을 짜야함
 */

class Lecture implements Comparable<Lecture> {
    public int money;
    public int time;

    public Lecture(int money, int time) {
        this.money = money;
        this.time = time;
    }

    public int compareTo(Lecture o) {
        return o.time - this.time;
    }
}

public class MaxIncomeSchedule {
    static int max = Integer.MAX_VALUE;

    public int solution(List<Lecture> arr) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr);
        int j = 0;
        for (int i = max; i >= 1; i--) {
            for (; j < arr.size(); j++) {
                if (arr.get(j).time < i) {
                    break;
                }
                priorityQueue.add(arr.get(j).money);
            }

            if (!priorityQueue.isEmpty()) {
                answer+=priorityQueue.poll();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        MaxIncomeSchedule maxIncomeSchedule = new MaxIncomeSchedule();
        Scanner scanner = new Scanner(System.in);

        ArrayList<Lecture> arr = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            int d = scanner.nextInt();
            arr.add(new Lecture(m, d));
            if (d > max) max = d;
        }

        System.out.println(maxIncomeSchedule.solution(arr));
    }
}
