package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> scoreMap = new HashMap<>();

        List<String> directFriends = createDirectFriends(user, friends);

        findMutualFriends(scoreMap, friends, directFriends);

        scoreVisitedFriends(visitors, scoreMap);

        List<String> names = createSortedFriendsName(scoreMap);

        List<String> answer = chooseFiveFriends(names, directFriends, user);

        return answer;
    }

    private static List<String> chooseFiveFriends(List<String> names, List<String> directFriends, String user){
        List<String> result = new ArrayList<>();

        for (int i = 0; i < names.size(); i++) {
            if (result.size() >= 5) break;

            if (directFriends.contains(names.get(i)) || names.get(i).equals(user)) continue;

            result.add(names.get(i));
        }
        return result;
    }

    private static List<String> createSortedFriendsName(HashMap<String, Integer> scoreMap) {
        List<String> result = new ArrayList<>(scoreMap.keySet());
        result.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return scoreMap.get(o2) - scoreMap.get(o1);
            }
        });

        return result;
    }
    private static void scoreVisitedFriends(List<String> visitors, HashMap<String, Integer> scoreMap) {
        for (String visitor : visitors) {
            scoreMap.put(visitor, scoreMap.getOrDefault(visitor, 0) + 1);
        }
    }

    private static List<String> createDirectFriends(String user, List<List<String>> friends) {
        List<String> result = new ArrayList<>();
        for (List<String> relationship : friends){
            if (relationship.get(0).equals(user)) result.add(relationship.get(1));
            if (relationship.get(1).equals(user)) result.add(relationship.get(0));
        }
        return result;
    }

    private static void findMutualFriends(HashMap<String, Integer> scoreMap, List<List<String>> friends, List<String> directFriends) {
        for (String friend : directFriends) {
            for (List<String> relationship : friends){
                scoreMutualFriends(scoreMap, relationship, friend);
            }
        }
    }

    private static void scoreMutualFriends(HashMap<String, Integer> scoreMap, List<String> relationship, String friend) {
        if (relationship.get(0).equals(friend))
            scoreMap.put(relationship.get(1), scoreMap.getOrDefault(relationship.get(1), 0) + 10);
        else if (relationship.get(1).equals(friend))
            scoreMap.put(relationship.get(0), scoreMap.getOrDefault(relationship.get(0), 0) + 10);
    }
}
