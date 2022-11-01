package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static List<String> findAllFriends(String user, List<List<String>> friends) {
        List<String> friendsList = new ArrayList<>();

        for(List<String> friendRelationship : friends) {
            if(friendRelationship.contains(user)) {
                friendsList.add(
                        (friendRelationship.get(0).equals(user))? friendRelationship.get(1) : friendRelationship.get(0)
                );
            }
        }

        return friendsList;
    }

    public static Map<String, Integer> calculateScoreByFriendsList(List<String> usersFriends, List<String> objectsFriends, String object) {
        int count = 0;
        for(String usersFriend : usersFriends) {
            count = (objectsFriends.contains(usersFriend)) ? 1 : 0;
        }
        Map<String, Integer> friendsScore = new HashMap<>();
        friendsScore.put(object, count * 10);
        return friendsScore;
    }

    public static Map<String, Integer> calculateScoreByVisitors(List<String> visitors, Map<String, Integer> scoreMap) {
        for(String visitor : visitors) {
            if(scoreMap.containsKey(visitor)) {
                scoreMap.replace(visitor, scoreMap.get(visitor) + 1);
            } else {
                scoreMap.put(visitor, 1);
            }
        }
        return scoreMap;
    }

}
