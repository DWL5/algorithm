package kakao;


public class Advertise {
    int makeTime(String str) {
        String[] split = str.split(":");
        int hour = Integer.parseInt(split[0]) * 3600;
        int min = Integer.parseInt(split[1]) * 60;
        int sec = Integer.parseInt(split[2]);

        return hour + min + sec;
    }

    String toStringTime(int time) {
        int hour = time/3600;
        int min = (time%3600) / 60;
        int sec = (time%3600%60);

        String h = String.format("%02d", hour);
        String m = String.format("%02d", min);
        String s = String.format("%02d", sec);
        return h+":"+m+":"+s;
    }

    public String solution(String play_time, String adv_time, String[] logs) {
        if (play_time.equals(adv_time)) {
            return "00:00:00";
        }

        int time = makeTime(play_time);
        int[] arr = new int[time + 1];


        for (String log : logs) {
            String[] split = log.split("-");
            int start = makeTime(split[0]);
            int end = makeTime(split[1]);

            for (int i = start; i < end; i++) {
                arr[i] += 1;
            }
        }

        long currSum = 0;
        int advTime = makeTime(adv_time);

        for (int i = 0; i < advTime; i++) {
            currSum += arr[i];
        }

        long maxSum = currSum;
        int maxIdx = 0;

        for (int i = advTime; i <= time; i++) {
            currSum = currSum + arr[i] - arr[i - advTime];

            if (currSum > maxSum) {
                maxSum = currSum;
                maxIdx = i - advTime + 1;
            }
        }

        return toStringTime(maxIdx);
    }
}
