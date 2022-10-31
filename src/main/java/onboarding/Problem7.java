package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> scores = new HashMap<>();
        Map<String, List<String>> friendsList = createFriendsList(friends);
        addFriendScore(user, scores, friendsList);
        addVisitorScore(scores, visitors, friendsList.get(user));
        return makeResult(scores);
    }

    private static List<String> makeResult(Map<String, Integer> scores) {
        List<String> answer = new ArrayList<>(scores.keySet());
        answer.sort(Comparator.naturalOrder());
        answer.sort((o1, o2) -> scores.get(o2).compareTo(scores.get(o1)));
        return answer;
    }

    public static Map<String, List<String>> createFriendsList(List<List<String>> friends) {
        Map<String, List<String>> friendsList = new HashMap<>();
        for (List<String> friend : friends) {
            if (!friendsList.containsKey(friend.get(0)))
                friendsList.put(friend.get(0), new ArrayList<String>());
            if (!friendsList.containsKey(friend.get(1)))
                friendsList.put(friend.get(1), new ArrayList<String>());
            friendsList.get(friend.get(0)).add(friend.get(1));
            friendsList.get(friend.get(1)).add(friend.get(0));
        }
        return friendsList;
    }

    public static void addFriendScore(String user, Map<String, Integer> scores, Map<String, List<String>> friendsList) {
        List<String> userFriends = friendsList.get(user);
        for (String friend : userFriends) {
            for (String person : friendsList.get(friend)) {
                if (person.equals(user))
                    continue;
                if (!scores.containsKey(person))
                    scores.put(person, 0);
                scores.put(person, scores.get(person) + 10);
            }
        }
    }

    public static void addVisitorScore(Map<String, Integer> scores, List<String> visitors, List<String> friends) {
        for (String visitor : visitors) {
            if (friends.contains(visitor))
                continue;
            if (!scores.containsKey(visitor))
                scores.put(visitor, 0);
            scores.put(visitor, scores.get(visitor) + 1);
        }
    }
}
