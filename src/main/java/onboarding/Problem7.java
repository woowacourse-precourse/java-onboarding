package onboarding;

import onboarding.problem7.UserRepository;
import onboarding.problem7.UserService;

import java.util.List;

public class Problem7 {
    private static final Integer LIMIT_SIZE = 5;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        var userService = new UserService(
                new UserRepository(user, friends, visitors)
        );

        return userService.findHighestRecommendationByUsernameLimitN(user, LIMIT_SIZE);
    }
}
