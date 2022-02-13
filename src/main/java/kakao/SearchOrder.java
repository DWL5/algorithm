package kakao;

import java.util.ArrayList;
import java.util.List;

public class SearchOrder {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        List<Data> applicants = new ArrayList<>();

        for (String application : info) {
            String[] split = application.split(" ");
            applicants.add(new Data(split[0].trim(),
                    split[1].trim(), split[2].trim(), split[3].trim(), Integer.parseInt(split[4].trim())));
        }

        int idx = 0;
        for (String q : query) {
            int cnt = 0;
            String[] split = q.split("and");
            String[] foodAndScore = split[3].trim().split(" ");
            Data data = new Data(split[0].trim(), split[1].trim(), split[2].trim(), foodAndScore[0].trim(), Integer.parseInt(foodAndScore[1].trim()));
            for (Data applicant : applicants) {
                if (applicant.check(data)) {
                    cnt++;
                }
            }
            answer[idx] = cnt;
            idx++;
        }
        return answer;
    }

    public class Data {
        String lang;
        String job;
        String type;
        String food;
        int score;

        public Data(String lang, String job, String type, String food, int score) {
            this.lang = lang;
            this.job = job;
            this.type = type;
            this.food = food;
            this.score = score;
        }

        boolean check(Data data) {
            if (!data.lang.equals("-")) {
                if (!data.lang.equals(lang)) {
                    return false;
                }
            }

            if (!data.job.equals("-")) {
                if (!data.job.equals(job)) {
                    return false;
                }
            }

            if (!data.type.equals("-")) {
                if (!data.type.equals(type)) {
                    return false;
                }
            }

            if (!data.food.equals("-")) {
                if (!data.food.equals(food)) {
                    return false;
                }
            }

            if (score < data.score) {
                return false;
            }

            return true;
        }
    }
}
