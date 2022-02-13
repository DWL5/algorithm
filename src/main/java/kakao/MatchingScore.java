package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://codechacha.com/ko/java-string-indexof-lastindexof-java/
public class MatchingScore {
    class Page {

        int idx;
        int basic, link;
        double score;

        public Page(int idx, int basic, int link, double score) {
            this.idx = idx;
            this.basic = basic;
            this.link = link;
            this.score = score;
        }
    }

    public int solution(String word, String[] pages) {
        Map<String, Integer> pageMap = new HashMap<>();
        List<Page> pageList = new ArrayList();
        word = word.toLowerCase();

        for (int i = 0; i < pages.length; i++) {
            String s = pages[i] = pages[i].toLowerCase();
            int mid = 0, left = 0, right = 0;

            //meta 태그 안에 있는 https로 시작하는 URL 찾기
            while(mid <= left) {
                left = s.indexOf("<meta", left + 1);
                right = s.indexOf(">", left);
                mid = s.lastIndexOf("https://", right);
            }

            //URL 추출 mid 부터 큰 따옴표를 만날때 까지
            right = s.indexOf("\"", mid);
            String url = s.substring(mid, right);

            //바디부터 시작
            left = s.indexOf("<body>", right) + "<body>".length();
            int temp = s.indexOf("</body>", left + 1);
            int basic = 0; // 기본 점수 값

            //기본점수 구하기
            for (int start = left; ;) {
                start = s.indexOf(word, start + 1);
                if (start > temp) break;
                if (start == - 1) break;
                if (!Character.isLetter(s.charAt(start - 1)) && !Character.isLetter(s.charAt(start + word.length()))) {
                    basic++;
                    start += word.length();
                }
            }

            int link = 0;
            for (int start = left; ;) {
                start = s.indexOf("<a href", start + 1);
                if (start > temp) break;
                if (start == - 1) break;
                link++;
            }

            pageMap.put(url , i);
            pageList.add(new Page(i, basic, link, basic));
        }

        //링크점수
        //어떤 페이지가 다른 페이지에 건 링크를 찾고
        //링크가 걸린 페이지의 score를 더해주는 과정
        for (int i = 0; i < pages.length; ++i) {
            String s = pages[i];
            for (int left = 0, right = 0; ;) {
                left = s.indexOf("<a href", right);
                if (left == - 1) break;

                left = s.indexOf("https://", left);
                right = s.indexOf("\"", left);
                String url = s.substring(left, right);

                Integer value = pageMap.get(url);
                //현재 i는 value 인덱스로 링크를 걸고 있다.
                //i는 value 인덱스로 링크가 걸린 '다른 웹페이지'다.
                //value의 링크점수는 i의 기본점수 / 외부링크를 더해야 한다.
                if (value != null) {
                    pageList.get(value).score += (double) pageList.get(i).basic / pageList.get(i).link;
                }
            }
        }

        pageList.sort((o1, o2) -> {
            if (o1.score > o2.score) {
                return -1;
            } else if (o1.score < o2.score) {
                return 1;
            } else {
                return o1.idx - o2.idx;
            }
        });

        return pageList.get(0).idx;
    }
}
