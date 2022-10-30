package onboarding;

import java.util.*;

public class Problem7 {

    public static final int FRIEND_SCORE = 10;
    public static final int VISITOR_SCORE = 1;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;

        ArrayList<String> withFriends = storeUserFriends(user, friends);
        Map<String, Integer> friendAndScore = storeFriendAndScore(user, friends, withFriends);

        return answer;
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
