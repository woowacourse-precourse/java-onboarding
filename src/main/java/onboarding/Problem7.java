package onboarding;

import problem7.FriendConnection;
import problem7.User;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        try {
            FriendConnection friendConnection = new FriendConnection(friends);
            User user1 = new User(friendConnection.getFriends(user));
            friendConnection.calculateRecommendationScore(visitors);
            return friendConnection.mostRecommendedAsFriend();
        } catch (RuntimeException e) {
            return null;
        }
    }
}
