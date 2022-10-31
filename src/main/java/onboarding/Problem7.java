package onboarding;

import org.mockito.internal.matchers.Null;
import problem7.FriendConnectionRepository;
import problem7.User;

import java.util.List;

public class Problem7 {
    public static List<String> solution(String userName, List<List<String>> friendsList, List<String> visitors) {
        try {
            FriendConnectionRepository.create(friendsList);
            FriendConnectionRepository.addUsers(visitors);

            User user = new User(userName);

            user.calculateRecommendationScoreWith(visitors);

            return user.calculateRecommendationScoreWithCommonFriends();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
