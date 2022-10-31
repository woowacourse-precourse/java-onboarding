package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static Map<String, List<String>> analyzeRelationship(List<List<String>> friends) {
        Map<String, List<String>> relationships = new HashMap<>();

        for (List<String> friend : friends) {
            makeRelationshipsMap(relationships, friend.get(0), friend.get(1));
            makeRelationshipsMap(relationships, friend.get(1), friend.get(0));
        }

        return relationships;
    }

    private static void makeRelationshipsMap(Map<String, List<String>> relationships, String person, String friendsOfPerson) {
        if (relationships.containsKey(person)) {
            relationships.get(person).add(friendsOfPerson);
        } else {
            List<String> friends = new ArrayList<>();

            friends.add(friendsOfPerson);
            relationships.put(person, friends);
        }
    }
}
