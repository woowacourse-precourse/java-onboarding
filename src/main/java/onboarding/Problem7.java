package onboarding;

import onboarding.problem7.UserScore;

import java.util.*;

public class Problem7 {

    private static final int LIMIT = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        UserScore userScore = new UserScore(user, friends, visitors);
        return userScore.findRecommendedUsers(LIMIT);
    }

}