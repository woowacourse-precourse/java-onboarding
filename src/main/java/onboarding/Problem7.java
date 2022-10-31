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

        // 친구의 친구인 경우 점수 맵에 10점 추가하기
        for(Object friend : friendsMap.get(user)) {
            ArrayList<String> friendsList = friendsMap.get(friend); // 친구의 친구 목록 가져오기
            addScoresForFriend(scoreMap, friendsList);
        }

        return answer;
    }

    private static void addToScoreMap(Map<String, Integer> scoreMap, String friend){
        if(scoreMap.containsKey(friend)){
            scoreMap.put(friend, scoreMap.get(friend)+10);
        }else scoreMap.put(friend,10);
    }

    private static void addScoresForFriend(Map<String, Integer> scoreMap, List<String> friendsList) {
        for (String friend : friendsList) {
            addToScoreMap(scoreMap, friend);
        }
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
