package onboarding;

import java.util.*;

public class Problem7 {
    private static final int FRIEND_SCORE = 10;
    private static final int VISITOR_SCORE = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, ArrayList<String>> friendMap = createFriendMap(friends);
        ArrayList<String> friendsOfUser = friendMap.get(user);

        Map<String, Integer> recommendScore = new TreeMap<>();
        addFriendScore(recommendScore, friendMap, friendsOfUser, user);
        addVisitorScore(recommendScore, visitors, friendsOfUser, user);

        return answer;
    }

    private static Map<String, ArrayList<String>> createFriendMap(List<List<String>> friends) {
        Map<String, ArrayList<String>> friendMap = new HashMap<>();
        for (List<String> friend : friends) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);
            storeUser(friendMap, user1, user2);
            storeUser(friendMap, user2, user1);
        }
        return friendMap;
    }

    private static void storeUser(Map<String, ArrayList<String>> friendMap, String user1, String user2) {
        ArrayList<String> friendList = friendMap.getOrDefault(user1, new ArrayList<>());
        friendList.add(user2);
        friendMap.put(user1, friendList);
    }

    private static void addFriendScore(Map<String, Integer> recommendScore, Map<String, ArrayList<String>> friendMap, List<String> friendsOfUser, String user) {
        for (String friend : friendsOfUser) {
            addRecommendScore(recommendScore, friendMap.get(friend), FRIEND_SCORE, friendsOfUser, user);
        }
    }

    private static void addVisitorScore(Map<String, Integer> recommendScore, List<String> visitors, List<String> friendsOfUser, String user) {
        addRecommendScore(recommendScore, visitors, VISITOR_SCORE, friendsOfUser, user);
    }

    private static void addRecommendScore(Map<String, Integer> recommendScore, List<String> friendsOfFriend, int score, List<String> friendsOfUser, String user) {
        for (String friend : friendsOfFriend) {
            if (isException(friend, friendsOfUser, user)) {
                continue;
            }
            recommendScore.put(friend, recommendScore.getOrDefault(friend, 0) + score);
        }
    }

    private static boolean isException(String friend, List<String> userFriends, String user) {
        return userFriends.contains(friend) || friend.equals(user);
    }
}
