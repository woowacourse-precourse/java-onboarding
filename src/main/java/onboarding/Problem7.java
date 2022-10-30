package onboarding;

import java.util.*;

public class Problem7 {

    public static final int FRIEND_SCORE = 10;
    public static final int VISITOR_SCORE = 1;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;

        ArrayList<String> withFriends = storeUserFriends(user, friends);
        Map<String, Integer> friendAndScore = storeFriendAndScore(user, friends, withFriends);
        visitScore(visitors, withFriends, friendAndScore);;

        return answer;
    }

    private static void visitScore(List<String> visitors, ArrayList<String> withFriends, Map<String, Integer> friendScore) {
        for (int i = 0; i < visitors.size(); i++) {
            String visitor = visitors.get(i);
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
    }

    private static Map<String, Integer> storeFriendAndScore(String user, List<List<String>> friends, ArrayList<String> withFriends) {
        Map<String, Integer> friendScore = new HashMap<>();
        for (int i = 0; i < withFriends.size(); i++) {
            String withFriend = withFriends.get(i);
            for (int j = 0; j < friends.size(); j++) {
                List<String> knowFriendList = friends.get(j);
                if (knowFriendList.contains(withFriend)) {
                    for (int k = 0; k < knowFriendList.size(); k++) {
                        String knowFriend = knowFriendList.get(k);
                        if (!withFriend.equals(knowFriend) && !knowFriendList.contains(user)) {
                            if (!friendScore.containsKey(knowFriend)) {
                                friendScore.put(knowFriend, FRIEND_SCORE);
                            }
                        }
                    }
                }
            }
        }
        return friendScore;
    }

    private static ArrayList<String> storeUserFriends(String user, List<List<String>> friends) {
        ArrayList<String> withFriends = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            List<String> friendList = friends.get(i);
            if (friendList.contains(user)) {
                for (int j = 0; j < friendList.size(); j++) {
                    String friend = friendList.get(j);
                    if (!user.equals(friend)) {
                        withFriends.add(friend);
                    }
                }
            }
        }
        return withFriends;
    }
}
