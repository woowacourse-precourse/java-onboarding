package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        UserFriends userFriends = new UserFriends(user);
        FriendScores friendScores;

        validFriends(friends);
        validVisitors(visitors);

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

    public static void validFriends(List<List<String>> friends) {
        if (friends.size() < 1 || friends.size() > 10000)
            throw new IllegalArgumentException("친구 목록의 크기는 1 이상 10,000 이하여야 합니다.");
    }

    public static void validVisitors(List<String> visitors) {
        if (visitors.size() < 0 || visitors.size() > 10000)
            throw new IllegalArgumentException("방문자 목록의 크기는 0 이상 10,000 이하여야 합니다.");
    }
}
