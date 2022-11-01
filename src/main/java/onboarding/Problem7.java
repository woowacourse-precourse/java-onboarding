package onboarding;

import java.util.*;

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

    private static HashSet<String> getUserFriends(List<List<String>> friends) {
        return new HashSet<>();
    }

    private static void scoreFriendsKnowWithUser(List<List<String>> friends) {
        HashSet<String> userFriends = getUserFriends(friends);
    }

    private static void scoreVisitor(List<String> visitors) {

    }

    private static List<String> getMaxScoredPerson() {
        return new ArrayList<>();
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        makeMapOfPersonScore(friends, visitors);
        scoreFriendsKnowWithUser(friends);
        scoreVisitor(visitors);
        return getMaxScoredPerson();
    }
}
