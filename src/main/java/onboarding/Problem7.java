package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        //user 친구 찾기
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(0).equals(user)) {
                list.add(friends.get(i).get(1));
            } else if (friends.get(i).get(1).equals(user)) {
                list.add(friends.get(i).get(0));
            }
        }

        // user 친구의 친구 찾기
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (friends.get(i).get(0).equals(list.get(j))) {
                    if (!friends.get(i).get(1).equals(user)) {
                        map.put(friends.get(i).get(1), 10);
                    }
                } else if (friends.get(i).get(1).equals(list.get(j))) {
                    if (!friends.get(i).get(0).equals(user)) {
                        map.put(friends.get(i).get(0), 10);
                    }
                }
            }
        }
        //visitor

        for (int i = 0; i < visitors.size(); i++) {
            if (!map.containsKey(visitors.get(i))) {
                map.put(visitors.get(i), 1);
            } else {
                map.put(visitors.get(i), map.get(visitors.get(i)) + 1);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            map.remove(list.get(i));
        }

        // map 에 key value 다 들어가 있는 상황
        // 점수 내림차순으로 배열

        answer = new ArrayList<>(map.keySet());
        Collections.sort(answer, (value1, value2) -> {
            if(map.get(value1) == map.get(value2)){
                return value1.compareTo(value2);
            }
            return map.get(value2).compareTo(map.get(value1));
        });

        if (answer.size() > 5) {
            answer = answer.subList(0, 5);
        }
        return answer;
    }
}
