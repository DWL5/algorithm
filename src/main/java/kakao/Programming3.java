package kakao;

import java.util.*;
import java.util.stream.Collectors;

public class Programming3 {
    int basicFee;
    int basicTime;
    int unitTime;
    int unitFee;

    class Car {
        String id;
        int enter;
        int exit;
        int accum;
        int money;

        public Car(String id) {
            this.id = id;
            this.enter = -1;
            this.exit = -1;
        }

        public void exit() {
            accum += exit - enter;
            enter = -1;
            exit = -1;
        }

        public void calculate() {
            if (enter != -1 && exit == -1) {
                exit = convertTime("23:59");
                accum += exit - enter;
            }

            int accumTime = accum - basicTime;
            if (accumTime > 0) {
                double value = (double) accumTime / unitTime;
                int up = (int) Math.ceil(value);
                money += basicFee + up * unitFee;
            } else {
                money += basicFee;
            }
        }
    }

    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        Map<String, Car> map = new HashMap<>();
        basicTime = fees[0];
        basicFee = fees[1];
        unitTime = fees[2];
        unitFee = fees[3];

        for (String record : records) {
            String[] split = record.split(" ");
            String time = split[0];
            String id = split[1];
            String action = split[2];

            if ("IN".equals(action)) {
                if (!map.containsKey(id)) {
                    map.put(id, new Car(id));
                }
                Car car = map.get(id);
                car.enter = convertTime(time);
                car.exit = -1;
            } else if ("OUT".equals(action)) {
                Car car = map.get(id);
                car.exit = convertTime(time);
                car.exit();
            }
        }

        for (Car car : map.values()) {
            if (car.exit == -1) {
                car.calculate();
            }
        }

        Collection<Car> arrayList = map.values();
        List<Car> collect = arrayList.stream().sorted(Comparator.comparingInt(o -> Integer.parseInt(o.id))).collect(Collectors.toList());

        answer = new int[collect.size()];

        for (int i = 0; i < collect.size(); i++) {
            answer[i] = collect.get(i).money;
        }

        return answer;
    }

    int convertTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 +
                Integer.parseInt(split[1]);
    }
}
