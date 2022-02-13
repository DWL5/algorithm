package greedy;

import java.util.Arrays;
import java.util.Collections;

public class Boat {
    public int solution(int[] people, int limit) {
        int rescue = 0;
        int boat = 0;

        int start = 0;
        int end = people.length - 1;

        Integer[] peopleArr = Arrays.stream(people).boxed().toArray(Integer[]::new);
        Arrays.sort(peopleArr, Collections.reverseOrder());

        while (rescue != peopleArr.length) {
            if (start > end) {
                break;
            }

            if (start == end) {
                rescue++;
                boat++;
                start++;
                continue;
            }

            if (peopleArr[start] + peopleArr[end] <= limit) {
                boat++;
                rescue+=2;
                start++;
                end--;
                continue;
            }

            boat++;
            start++;
        }


        return boat;
    }
}
