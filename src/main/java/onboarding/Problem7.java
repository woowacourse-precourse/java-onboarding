package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        Map<String, Integer> pointOfUsers = new HashMap<>();
        Set<String> friendsList = new HashSet<>();

        for (List<String> friend : friends) {
            String userA = friend.get(0);
            String userB = friend.get(1);

            friendsList.add(userA);
            calculateFriendScore(user, pointOfUsers, userB);
        }

        for (String visitor : visitors) {
            if (!friendsList.contains(visitor)) {
                calculateVisitorScore(pointOfUsers, visitor);
            }
        }

        answer = new ArrayList<>(pointOfUsers.keySet());

        answer.sort((obj1, obj2) -> {
            if (!Objects.equals(pointOfUsers.get(obj1), pointOfUsers.get(obj2))) {
                return pointOfUsers.get(obj2) - pointOfUsers.get(obj1);
            }
            return obj1.compareTo(obj2);
        });

        if (answer.size() > 5) {
            answer = answer.subList(0, 5);
        }

        return answer;
    }

    private static void calculateFriendScore(String user, Map<String, Integer> pointOfUsers, String userB) {
        if (!Objects.equals(userB, user)) {
            if (!pointOfUsers.containsKey(userB)) {
                pointOfUsers.put(userB, 10);
            } else {
                pointOfUsers.put(userB, pointOfUsers.get(userB) + 10);
            }
        }
    }

    private static void calculateVisitorScore(Map<String, Integer> pointOfUsers, String visitor) {
        if (!pointOfUsers.containsKey(visitor)) {
            pointOfUsers.put(visitor, 1);
        } else {
            pointOfUsers.put(visitor, pointOfUsers.get(visitor) + 1);
        }
    }
}
