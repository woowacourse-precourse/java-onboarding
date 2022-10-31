package onboarding;

import java.util.*;

public class Problem7 {

    public static final int FRIEND_SCORE = 10;
    public static final int VISITOR_SCORE = 1;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;

        ArrayList<String> userFriends = storeUserFriends(user, friends);
        Map<String, Integer> friendAndScore = storeFriendAndScore(user, friends, userFriends);
        visitScore(visitors, userFriends, friendAndScore);
        answer = mapToList(friendAndScore);

        return answer;
    }

    private static List<String> mapToList(Map<String, Integer> friendScore) {
        List<String> answer;
        answer = new ArrayList<>(friendScore.keySet());
        return answer;
    }

    private static void visitScore(List<String> visitors, ArrayList<String> withFriends, Map<String, Integer> friendScore) {
        visitors.forEach(visitor -> {
            existVisitor(withFriends, friendScore, visitor);
        });

    }

    private static void existVisitor(ArrayList<String> withFriends, Map<String, Integer> friendScore, String visitor) {
        if (friendScore.containsKey(visitor)) {
            Integer score = friendScore.get(visitor);
            score++;
            friendScore.replace(visitor, score);
        }
        if (!withFriends.contains(visitor)) {
            if (!friendScore.containsKey(visitor)) {
                friendScore.put(visitor, VISITOR_SCORE);
            }
        }
    }

    private static Map<String, Integer> storeFriendAndScore(String user, List<List<String>> friends, ArrayList<String> withFriends) {
        Map<String, Integer> friendScore = new HashMap<>();
        withFriends.forEach(userFriend -> {
            friends.forEach(knowFriendList -> {
                calculateVisitPoint(user, friendScore, userFriend, knowFriendList);
            });
        });

        return friendScore;
    }

    private static void calculateVisitPoint(String user, Map<String, Integer> friendScore, String userFriend, List<String> knowFriendList) {
        if (knowFriendList.contains(userFriend)) {
            knowFriendList.forEach(knowFriend -> {
                calculateFriendPoint(user, friendScore, userFriend, knowFriendList, knowFriend);
            });
        }
    }

    private static void calculateFriendPoint(String user, Map<String, Integer> friendScore, String userFriend, List<String> knowFriendList, String knowFriend) {
        if (!userFriend.equals(knowFriend) && !knowFriendList.contains(user)) {
            if (!friendScore.containsKey(knowFriend)) {
                friendScore.put(knowFriend, FRIEND_SCORE);
            }
        }
    }

    private static ArrayList<String> storeUserFriends(String user, List<List<String>> friends) {
        ArrayList<String> withFriends = new ArrayList<>();
        friends.forEach(friendList -> {
            storeUserFriend(user, withFriends, friendList);
        });

        return withFriends;
    }

    private static void storeUserFriend(String user, ArrayList<String> withFriends, List<String> friendList) {
        if (friendList.contains(user)) {
            friendList.forEach(friend -> {
                addFriend(user, withFriends, friend);
            });
        }
    }

    private static void addFriend(String user, ArrayList<String> withFriends, String friend) {
        if (!user.equals(friend)) {
            withFriends.add(friend);
        }
    }
}
