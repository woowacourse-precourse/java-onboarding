package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    /**
     * 추천 친구 목록을 생성
     * @param user
     * @param friends
     * @param visitors
     * @return
     */
    public static Map<String, Integer> friendLists(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> friendMap = new HashMap<>();

        // 나를 제외한 모든 친구를 저장
        friends.forEach(friend -> {
            if(friend.get(0) != user) friendMap.putIfAbsent(friend.get(0), 0);
            if(friend.get(1) != user) friendMap.putIfAbsent(friend.get(1), 0);
        });

        visitors.forEach(visitor -> {
            if(visitor != user) friendMap.putIfAbsent(visitor, 0);
        });

        // 목록에서 내 친구를 삭제한 뒤 반환
        return myFriendLists(user, friends, friendMap);
    }

    /**
     * 친구 목록에서 내 친구를 삭제
     * @param user
     * @param friends
     * @param friendMap
     * @return
     */
    public static Map<String, Integer> myFriendLists(String user, List<List<String>> friends, Map<String, Integer> friendMap) {
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user) || friend.get(1).equals(user)) {
                friendMap.remove(friend.get(0));
                friendMap.remove(friend.get(1));
            }
        }
        return friendMap;
    }
}
