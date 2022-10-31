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

    private static void getScore(Map<String, Integer> scoreBoard, List<String> userRelationships, List<String> friends, int score) {
        for (String friend : friends) {
            if (userRelationships.contains(friend)) {
                continue;
            }

            if (scoreBoard.containsKey(friend)) {
                scoreBoard.replace(friend, scoreBoard.get(friend) + score);
            } else {
                scoreBoard.put(friend, score);
            }
        }
    }

    private static void scoreFollowForFollow(Map<String, List<String>> relationships, List<String> userRelationships, Map<String, Integer> scoreBoard) {
        for (String relationship : userRelationships) {
            List<String> followForFollow = relationships.get(relationship);
            getScore(scoreBoard, userRelationships, followForFollow, 10);
        }
    }

    private static void scoreVisitor(Map<String, Integer> scoreBoard, List<String> userRelationships, List<String> visitors) {
        getScore(scoreBoard, userRelationships, visitors, 1);
    }

    private static List<String> SortByName(Map<String, Integer> scoreBoard) {
        List<String> sortedrecommendationList = new ArrayList<>(scoreBoard.keySet());
        sortedrecommendationList.sort((x, y) -> scoreBoard.get(y) - scoreBoard.get(x));

        if (sortedrecommendationList.size() > 5) {
            sortedrecommendationList.subList(0, 5);
        }

        return sortedrecommendationList;
    }
}
