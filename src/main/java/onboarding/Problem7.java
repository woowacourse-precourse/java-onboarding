package onboarding;

import org.mockito.internal.matchers.Null;
import problem7.FriendConnectionRepository;
import problem7.User;

import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        try {
            FriendConnectionRepository.create(friends);
            User user1 = new User(user);

            user1.calculateRecommendationScoreWith(visitors);

            return user1.calculateRecommendationScoreWithCommonFriends();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
