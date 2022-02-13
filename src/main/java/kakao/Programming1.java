package kakao;

import java.util.*;
import java.util.stream.Collectors;

class Programming1 {
    class Member {
        int id;
        String name;
        int mailCount;

        public Member(int id, String name) {
            this.id = id;
            this.name = name;
            this.mailCount = 0;
        }

        public void receiveMail() {
            mailCount++;
        }


    }

    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Member> memberMap = new HashMap<>();


        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], new HashSet<>());
            memberMap.put(id_list[i], new Member(i, id_list[i]));

        }

        for (String r : report) {
            String[] split = r.split(" ");
            map.get(split[1]).add(split[0]);
        }

        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            Set<String> set = entry.getValue();
            if (set.size() >= k) {
                for (String name : set) {
                    memberMap.get(name).receiveMail();
                }
            }
        }

        List<Member> collect = memberMap.values().stream().sorted(Comparator.comparingInt(o -> o.id)).collect(Collectors.toList());

        int[] answer = new int[collect.size()];

        for (int i = 0; i < collect.size(); i++) {
            answer[i] = collect.get(i).mailCount;
        }

        return answer;
    }
}