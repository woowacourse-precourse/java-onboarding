package onboarding;

import problem7.FriendConnectionRepository;
import problem7.User;
import problem7.Validator;

import java.util.List;

public class Problem7 {
    public static List<String> solution(String userName, List<List<String>> friendsList, List<String> visitors) {
        try {
            Validator.validateFriends(friendsList);
            Validator.validateVisitors(visitors);

            FriendConnectionRepository.create(friendsList);
            FriendConnectionRepository.addUsers(visitors);
            FriendConnectionRepository.addUsers(List.of(userName));


            User user = new User(userName);

            return user.getMostRecommendedAsFriend(visitors);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
