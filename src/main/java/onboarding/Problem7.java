package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    private static final int FIRST_FRIEND = 0;
    private static final int SECOND_FRIEND = 1;

    private static final int ZERO_POINT = 0;
    private static final int TEN_POINT = 10;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Map<String, List<String>> userToFriends = convertToFriendMap(friends);
        Map<String, Integer> scoreMap = calculateFriendsScore(userToFriends, user);

        return List.of();
    }

    private static Map<String, List<String>> convertToFriendMap(List<List<String>> friends) {
        HashMap<String, List<String>> userToFriends = new HashMap<>();

        for (List<String> friendPair : friends) {
            addFriendsList(userToFriends, friendPair.get(FIRST_FRIEND), friendPair.get(SECOND_FRIEND));
            addFriendsList(userToFriends, friendPair.get(SECOND_FRIEND), friendPair.get(FIRST_FRIEND));
        }

        return userToFriends;
    }

    private static void addFriendsList(Map<String, List<String>> userToFriends, String user, String friend) {
        userToFriends.computeIfAbsent(user, k -> new ArrayList<>()).add(friend);
    }

    private static Map<String, Integer> calculateFriendsScore(Map<String, List<String>> userToFriends, String user) {
        HashMap<String, Integer> result = new HashMap<>();

        for (String friend : userToFriends.get(user)) {
            plusTenPoint(result, userToFriends.get(friend));
        }

        return result;
    }

    private static void plusTenPoint(HashMap<String, Integer> scoreMap, List<String> friends) {
        for (String friend : friends) {
            Integer score = scoreMap.getOrDefault(friend, ZERO_POINT);
            scoreMap.put(friend, score + TEN_POINT);
        }
    }
}
