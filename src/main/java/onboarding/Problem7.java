package onboarding;

import java.util.*;
import java.util.stream.Collectors;


public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = calculateScoreProcess(user, friends, visitors);
        return answer;
    }

    public static List<String> calculateScoreProcess(String user, List<List<String>> friends, List<String> visitors) {

        List<String> usersFriends = findAllFriends(user, friends);
        Set<String> objectUsers = findAllObjectUsers(user, friends, usersFriends, visitors);
        if(objectUsers.size() == 0) return null;

        Map<String, Integer> score = new HashMap<>();

        for(String object : objectUsers) {
            List<String> objectsFriends = findAllFriends(object, friends);
            calculateScoreByFriendsList(usersFriends, objectsFriends, object, score);
        }
        calculateScoreByVisitors(visitors, usersFriends, score);

        score = score.entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, HashMap::new));
        return new ArrayList<>(score.keySet());
    }

    public static Set<String> findAllObjectUsers(String user, List<List<String>> friends, List<String> usersFriends, List<String> visitors) {
        Set<String> objectUsers = new HashSet<>(visitors);
        for(List<String> friendRelationship : friends) {
            objectUsers.addAll(friendRelationship);
        }
        objectUsers.addAll(visitors);
        objectUsers.remove(user);
        usersFriends.forEach(objectUsers::remove);

        return objectUsers;
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

    public static void calculateScoreByFriendsList(List<String> usersFriends, List<String> objectsFriends, String object, Map<String, Integer> score) {
        int count = 0;
        for(String usersFriend : usersFriends) {
            count += (objectsFriends.contains(usersFriend)) ? 1 : 0;
        }
        if(count == 0)  return;

        if(score.containsKey(object)) {
            int temp = score.get(object);
            score.put(object, temp + count * 10);
        } else {
            score.put(object, count * 10);
        }
    }

    public static void calculateScoreByVisitors(List<String> visitors, List<String> usersFriends, Map<String, Integer> score) {

        for(String visitor : visitors) {
            if(usersFriends.contains(visitor))  continue;

            if(score.containsKey(visitor)) {
                int temp = score.get(visitor);
                score.put(visitor, ++temp);
            } else {
                score.put(visitor, 1);
            }
        }
    }


}
