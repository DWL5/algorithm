package greedy;

import java.util.ArrayList;

class Live {

    public static void main(String[] args) {
        new Live().solution(new int[]{3,1,2}, 5);
    }
    public int solution(int[] food_times, long k) {
        int current = 0;
        ArrayList<Integer> idx = new ArrayList<>();
        for (int i = 0; i < food_times.length; i++) {
            idx.add(i);
        }

        for (long i = k - 1; i >= 0; i--) {
            if (current >= idx.size()) {
                current = 0;
            }

            food_times[idx.get(current)]--;
            if (food_times[idx.get(current)] == 0) {
                idx.remove(current);
                continue;
            }
            current++;
        }

        if (current >= idx.size()) {
            current = 0;
        }

        return idx.get(current) + 1;
    }
}