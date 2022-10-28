package onboarding;

import static onboarding.problem7.FriendsRecommender.getRecommendedFriendsName;

import java.util.List;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {
        return getRecommendedFriendsName(user, friends, visitors);
    }
}
