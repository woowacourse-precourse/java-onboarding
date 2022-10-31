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

}
