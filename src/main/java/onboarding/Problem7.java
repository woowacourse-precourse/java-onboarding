package onboarding;

import java.util.*;

public class Problem7 {

    private static final int USER_FRIEND_POINT = 10;
    private static final int USER_VISIT_POINT = 1;

    private static Map<String, List<String>> userFriendsList;
    private static Map<String, Integer> scores;

    private static void addUserFriend(String user, String friend) {
        List<String> friendsList = userFriendsList.getOrDefault(user, new ArrayList<>());
        friendsList.add(friend);
        userFriendsList.put(user, friendsList);
    }

    private static void createUserFriendsList(List<List<String>> friends) {
        for (List<String> friend : friends) {
            addUserFriend(friend.get(0), friend.get(1));
            addUserFriend(friend.get(1), friend.get(0));
        }
    }

    private static void calculateScore(String user, List<String> visitors) {
        List<String> usersFriends = userFriendsList.get(user);
        for (String usersFriend : usersFriends) {
            for (String friendsFriend : userFriendsList.get(usersFriend)) {
                if (!friendsFriend.equals(user) && !usersFriends.contains(friendsFriend)) {
                    increaseScore(friendsFriend, USER_FRIEND_POINT);
                }
            }
        }

        for (String visitor : visitors) {
            if (!usersFriends.contains(visitor)) {
                increaseScore(visitor, USER_VISIT_POINT);
            }
        }
    }

    private static void increaseScore(String user, int additionalScore) {
        int score = scores.getOrDefault(user, 0);
        score += additionalScore;
        scores.put(user, score);
    }

    private static List<String> getRecommendList() {
        List<String> recommendList = new ArrayList<>();

        List<Map.Entry<String, Integer>> userList = new LinkedList<>(scores.entrySet());
        userList.sort((o1, o2) -> o2.getValue() - o1.getValue());

        for (Map.Entry<String, Integer> user : userList) {
            if (user.getValue() == 0) {
                break;
            }
            recommendList.add(user.getKey());
            if (recommendList.size() == 5) {
                break;
            }
        }

        return recommendList;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        userFriendsList = new HashMap<>();
        scores = new HashMap<>();
        List<String> answer;

        createUserFriendsList(friends);
        calculateScore(user, visitors);
        answer = getRecommendList();
        return answer;
    }
}
