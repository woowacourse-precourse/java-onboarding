package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> friendList = new ArrayList<>();   // 사용자의 친구 목록
        Map<String, Integer> recommendedFriends = new HashMap<>();   // 친구 추천 목록

        createFriendList(user, friends, friendList);
        checkFriendOfFriend(user, friends, friendList, recommendedFriends);
        checkVisitors(visitors, recommendedFriends);
        makeRecommendFriendsList(recommendedFriends, friendList, answer);

        return answer;
    }

    // 1. 사용자의 친구 목록 생성
    public static void createFriendList(String user, List<List<String>> friends, List<String> friendList) {
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                for (String name : friend) {
                    if (!name.equals(user)) friendList.add(name);
                }

            }
        }
    }

    // 2. 사용자의 친구 목록에 포함되어있는지 체크 ( = 사용자의 친구와 친구인지 확인 ) -> 맞으면 +10점
    public static void checkFriendOfFriend(String user, List<List<String>> friends, List<String> friendList, Map<String, Integer> recommendedFriends) {
        for (List<String> friend : friends) {
            for (String name : friend) {
                if (!friendList.contains(name) && !name.equals(user)) {
                    if (recommendedFriends.containsKey(name)){
                        recommendedFriends.put(name, recommendedFriends.get(name) + 10);
                    }
                    else recommendedFriends.put(name, 10);
                }
            }
        }
    }

    // 3. 사용자의 타임라인에 방문했는지 체크 -> 했으면 +1점
    public static void checkVisitors(List<String> visitors, Map<String, Integer> recommendedFriends) {
        for (String visitor : visitors) {
            if (recommendedFriends.containsKey(visitor)) {
                recommendedFriends.put(visitor, recommendedFriends.get(visitor) + 1);
            }
            else recommendedFriends.put(visitor, 1);
        }
    }

}
