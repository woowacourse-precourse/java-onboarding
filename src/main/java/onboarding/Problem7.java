package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, Integer> targets = new HashMap<>();
        List<String> friend = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(user)){
                friend.add(friends.get(i).get(0));
            }else{
                String key = friends.get(i).get(0);
                String val = friends.get(i).get(1);
                List<String> temp = map.getOrDefault(key, new ArrayList<>());
                temp.add(val);
                map.put(key, temp);
            }
        }

        // 친구 추천 +10
        for (String f : friend){
            List<String> temp = map.get(f);
            for (String unknown: temp){
                targets.put(unknown, targets.getOrDefault(unknown, 0)+10);
            }
        }

        // 방문자 +1
        for (int i = 0; i < visitors.size(); i++) {
            if (friend.contains(visitors.get(i))){
                continue;
            }else{
                targets.put(visitors.get(i), targets.getOrDefault(visitors.get(i), 0)+1);
            }
        }

        // 정렬 코드
        answer = new ArrayList<>(targets.keySet());
        Collections.sort(answer, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (targets.get(o1) == targets.get(o2)) {
                    return o1.compareTo(o2);
                } else {
                    return targets.get(o2).compareTo(targets.get(o1));
                }
            }
        });

        // System.out.println("targets = " + targets);
        // System.out.println("map = " + map);

        return answer;
    }
}
