package onboarding;

import java.util.*;


public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = calculateScoreProcess(user, friends, visitors);
        return answer;
    }

    public static List<String> calculateScoreProcess(String user, List<List<String>> friends, List<String> visitors) {

        List<String> usersFriends = findAllFriends(user, friends);
        Map<String, Integer> score = new HashMap<>();

        Set<String> allUsers = new HashSet<>(visitors);
        for(List<String> friendRelationship : friends) {
            allUsers.addAll(friendRelationship);
        }
        allUsers.addAll(visitors);
        allUsers.remove(user);
        usersFriends.forEach(allUsers::remove);

        for(String object : allUsers) {
            List<String> objectsFriends = findAllFriends(object, friends);
            calculateScoreByFriendsList(usersFriends, objectsFriends, object, score);
            calculateScoreByVisitors(visitors, usersFriends, score);
        }

        return new ArrayList<>(score.keySet());
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

    public static Map<String, Integer> calculateScoreByFriendsList(List<String> usersFriends, List<String> objectsFriends, String object, Map<String, Integer> score) {
        int count = 0;
        for(String usersFriend : usersFriends) {
            count = (objectsFriends.contains(usersFriend)) ? 1 : 0;
        }

        if(score.containsKey(object)) {
            int temp = score.get(object);
            score.put(object, temp + count * 10);
        } else {
            score.put(object, count * 10);
        }

        return score;
    }

    public static Map<String, Integer> calculateScoreByVisitors(List<String> visitors, List<String> usersFriends, Map<String, Integer> scoreMap) {
        for(String visitor : visitors) {
            if(usersFriends.contains(visitor))  continue;

            if(scoreMap.containsKey(visitor)) {
                int temp = scoreMap.get(visitor);
                scoreMap.put(visitor, temp + 1);
            } else {
                scoreMap.put(visitor, 1);
            }
        }
        return scoreMap;
    }

}
