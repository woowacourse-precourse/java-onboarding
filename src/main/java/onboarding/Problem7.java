package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static HashMap<String, Integer> personScore = new HashMap<>();

    private static void makeMapOfPersonScore(List<List<String>> friends, List<String> visitors) {
        for(List<String> friend: friends) {
            personScore.put(friend.get(0), 0);
            personScore.put(friend.get(1), 0);
        }
        for(String visitor: visitors) {
            personScore.put(visitor, 0);
        }
    }

    private static Set<String> getUserFriends(String user, List<List<String>> friends) {
        return friends.stream()
                .filter(friend -> friend.get(0).equals(user) || friend.get(1).equals(user))
                .map(friend -> {
                    if(friend.get(0).equals(user)) return friend.get(1);
                    else return friend.get(0);
                }).collect(Collectors.toSet());
    }

    private static void scoreFriendsKnowWithUser(String user, List<List<String>> friends) {
        Set<String> userFriends = getUserFriends(user, friends);
        for(List<String> friend: friends) {
            String friend1 = friend.get(0), friend2 = friend.get(1);
            if(userFriends.contains(friend1))
                personScore.put(friend2, personScore.get(friend2)+10);
            if(userFriends.contains(friend2))
                personScore.put(friend1, personScore.get(friend1)+10);
        }
        personScore.remove(user);
    }

    private static void scoreVisitor(List<String> visitors) {

    }

    private static List<String> getMaxScoredPerson() {
        return new ArrayList<>();
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        makeMapOfPersonScore(friends, visitors);
        scoreFriendsKnowWithUser(user, friends);
        scoreVisitor(visitors);
        return getMaxScoredPerson();
    }
}
