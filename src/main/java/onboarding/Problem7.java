package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, ArrayList<String>> friendsMap = new HashMap<>();    // 친구 관계 그래프
        Map<String, Integer> scoreMap = new HashMap<>();        // 친구 점수 맵

        // 친구 관계 그래프 만들기
        for (List<String> friendRelation : friends){
            addFriendsMap(friendsMap,friendRelation);
        }

        return answer;
    }

    private static void addFriendsList(Map<String, ArrayList<String>> friendsMap, String key, String value) {
        ArrayList<String> friendsList = new ArrayList<>();
        if (friendsMap.containsKey(key)) {
            friendsList = friendsMap.get(key);
            friendsList.add(value);
        } else friendsList.add(value);
        friendsMap.put(key, friendsList);
    }

    private static void addFriendsMap(Map<String, ArrayList<String>> friendsMap, List<String> friends){
        addFriendsList(friendsMap, friends.get(0), friends.get(1));
        addFriendsList(friendsMap, friends.get(1), friends.get(0));
    }
}
