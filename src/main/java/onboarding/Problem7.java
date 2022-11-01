package onboarding;

import java.util.*;

public class Problem7 {
    HashMap<String, Integer> personScore = new HashMap<>();

    private static void makeMapOfPersonScore(List<List<String>> friends, List<String> visitors) {

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
