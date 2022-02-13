package sorting;

import java.util.ArrayList;
import java.util.List;

public class Cache {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new ArrayList();
        for (String city : cities) {
            String c = city.toUpperCase();
            int idx = cache.indexOf(c);
            if (idx == -1) {
                answer += 5;
            } else {
                answer += 1;
                cache.remove(idx);
            }
            cache.add(0, c);

            if (cache.size() > cacheSize) {
                cache.remove(cacheSize);
            }
        }
        return answer;
    }
}
