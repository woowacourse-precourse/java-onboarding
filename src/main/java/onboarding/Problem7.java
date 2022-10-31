package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        UserFriends userFriends = new UserFriends(user);
        FriendScores friendScores;

        for (int i = 0; i < friends.size(); i++) {
            userFriends.addUserFriend(user, friends.get(i));
        }

        friendScores = new FriendScores(userFriends);

        for (int i = 0; i < friends.size(); i++) {
            friendScores.add(friends.get(i));
        }

        for (int i = 0; i < visitors.size(); i++) {
            friendScores.add(visitors.get(i));
        }

        return friendScores.getRecommend();
    }
}
