package onboarding;

import java.util.List;
import onboarding.problem7.User;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        User savedUser = new User(user, friends, visitors);
        return savedUser.getRecommendedUsers();
    }
}
