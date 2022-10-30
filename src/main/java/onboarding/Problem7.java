package onboarding;

import problem7.FriendConnection;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        try {
            FriendConnection friendConnection = new FriendConnection(user, friends);
            friendConnection.calculateRecommendationScore(visitors);
            return friendConnection.mostRecommendedAsFriend();
        } catch (RuntimeException e) {
            return null;
        }
    }
}
