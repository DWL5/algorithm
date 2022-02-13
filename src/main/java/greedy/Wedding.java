package greedy;

import java.util.ArrayList;
import java.util.Collections;

public class Wedding {
    class Time implements Comparable<Time> {
        public int time;
        public char state;

        public Time(int time, char state) {
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Time o) {
            if (this.time == o.time) return this.state - o.state;
            else return this.time - o.time;
        }
    }

    static class Main {
        public int solution(ArrayList<Time> arr) {
            int answer= Integer.MIN_VALUE;
            Collections.sort(arr);

            int cnt = 0;
            for (Time ob : arr) {
                if(ob.state == 's') cnt++;
                else cnt--;
                answer = Math.max(answer, cnt);
            }
            return answer;
        }
        public static void main(String[] args) {

        }
    }
}
