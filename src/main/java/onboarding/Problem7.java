package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/* 기능 목록
1. 친구관계 그래프 Map 생성
2. 그래프에서 user 와 인접한 친구의 친구들에게 +10점
3. visitor +1점
4. 점수, 이름 순으로 정렬
5. 최대 5인 추천 친구 선정
*/

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // 1. 친구관계 그래프 Map 생성
        Map<String, List<String>> connectMap = new HashMap<>();

        for(List<String> connect : friends) {
            if(connectMap.containsKey(connect.get(0)))
                connectMap.get(connect.get(0)).add(connect.get(1));
            else {
                List<String> friendList = new ArrayList<>();
                friendList.add(connect.get(1));
                connectMap.put(connect.get(0), friendList);
            }

            if(connectMap.containsKey(connect.get(1)))
                connectMap.get(connect.get(1)).add(connect.get(0));
            else {
                List<String> friendList = new ArrayList<>();
                friendList.add(connect.get(0));
                connectMap.put(connect.get(1), friendList);
            }
        }

        // 2. 그래프에서 user 와 인접한 친구의 친구들에게 +10점
        Map<String, Integer> scores = new HashMap<>();
        for(String userFriend : connectMap.get(user)) {
            for(String friendFriend: connectMap.get(userFriend)) {
                scores.put(friendFriend, scores.containsKey(friendFriend) ? scores.get(friendFriend) + 10 : 10);
            }
        }

        // 3. visitor +1점
        for(String visitor : visitors) {
            scores.put(visitor, scores.containsKey(visitor) ? scores.get(visitor) + 1 : 1);
        }

        // 4. 점수, 이름 순으로 정렬
        List<Map.Entry<String, Integer>> scoresList = scores.entrySet()
                .stream().sorted(new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        if (o1.getValue() == o2.getValue())
                            return o1.getKey().compareTo(o2.getKey());
                        else
                            return -o1.getValue().compareTo(o2.getValue());
                    }
                })
                .collect(Collectors.toList());

        return answer;
    }
}
