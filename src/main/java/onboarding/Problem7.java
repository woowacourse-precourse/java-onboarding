package onboarding;

import onboarding.problem7.Users;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    private static Users users;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        users = new Users();
        return users.getRecommendFriendsRankingFive();
    }
}
