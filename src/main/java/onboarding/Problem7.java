package onboarding;

import java.util.Collections;
import java.util.List;
import onboarding.problem7.FriendSystem;
import onboarding.problem7.validation.FriendsValidation;
import onboarding.problem7.validation.UserValidation;
import onboarding.problem7.validation.VisitorsValidation;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        try {
            UserValidation.validate(user);
            FriendsValidation.validate(friends);
            VisitorsValidation.validate(visitors);
            FriendSystem friendSystem = new FriendSystem();
            answer = friendSystem.getRecommendedFriendsList(user, friends, visitors);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return answer;
    }
}
