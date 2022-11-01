package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> findUserFriends(String user, List<List<String>> friendRelation) {
        List<String> userFriends = new ArrayList<>();

        for (List<String> friends : friendRelation) {
            for (String friend : friends) {
                if (friends.contains(user) && !friend.equals(user)) {
                    userFriends.add(friend);
                }
            }
        }

        return userFriends;
    }

    public static Map<String, Integer> scoreFriendRelation(String user, Map<String, Integer> candidates, List<String> userFriends, List<List<String>> friendRelation) {
        for (String userFriend : userFriends) {
            for (List<String> friends : friendRelation) {
                for (String friend : friends) {
                    if (friends.contains(userFriend) && !friend.equals(userFriend) && !friend.equals(user)) {
                        candidates.put(friend, candidates.get(friend) + 10);
                    }
                }
            }
        }

        return candidates;
    }

    public static Map<String, Integer> scoreVisitors(Map<String, Integer> candidates, List<String> visitors) {
        for (String visitor : visitors) {
            if (candidates.containsKey(visitor)) {
                candidates.put(visitor, candidates.get(visitor) + 1);
            }
        }

        return candidates;
    }

    public static Map<String, Integer> findCandidates(String user, List<List<String>> friendRelation, List<String> visitors) {
        Map<String, Integer> candidates = new HashMap<>();

        for (List<String> friends : friendRelation) {
            for (String friend : friends) {
                if (!candidates.containsKey(friend)) {
                    candidates.put(friend, 0);
                }
            }
        }
        for (String visitor : visitors) {
            if (!candidates.containsKey(visitor)) {
                candidates.put(visitor, 0);
            }
        }
        for (List<String> friends : friendRelation) {
            for (String friend : friends) {
                if (friends.contains(user) && !friend.equals(user)) {
                    candidates.remove(friend);
                }
            }
        }
        candidates.remove(user);

        return candidates;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
