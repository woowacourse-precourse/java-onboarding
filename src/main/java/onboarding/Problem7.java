package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = Collections.emptyList();
        Map<String, HashSet<String>> friendMap = new HashMap<>();

        return answer;
    }

    /**
     * 주어진 친구 정보로 친구관계를 표현한 HashMap을 생성하는 메서드
     * 해쉬맵은 친구 이름을 key로, 친구관계인 친구들의 정보를 가진 HashSet 을 value 로 가짐
     *
     * @param friends 친구 정보
     * @return 친구 정보를 담은 HashMap
     */
    public static Map<String, HashSet<String>> makeMap(List<List<String>> friends) {

        Map<String, HashSet<String>> friendMap = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {

            String friendA = friends.get(i).get(0);
            String friendB = friends.get(i).get(1);

            HashSet<String> friendList = friendMap.getOrDefault(friendA, new HashSet<>());
            friendList.add(friendB);
            friendMap.put(friendA, friendList);

            friendList = friendMap.getOrDefault(friendB, new HashSet<>());
            friendList.add(friendA);
            friendMap.put(friendB, friendList);

        }

        return friendMap;
    }

}
