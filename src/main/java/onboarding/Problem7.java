package onboarding;

import problem7.FriendConnectionRepository;
import problem7.User;

import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        try {
            FriendConnectionRepository.create(friends);
            User user1 = new User(FriendConnectionRepository.getFriends(user));
            user1.calculateRecommendationScoreWith(visitors);
            return FriendConnectionRepository.mostRecommendedAsFriend();
        } catch (RuntimeException e) {
            return null;
        }
    }
}
