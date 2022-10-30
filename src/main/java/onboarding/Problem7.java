package onboarding;

import java.util.List;

import onboarding.problem7.FriendsRecommender;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        FriendsRecommender friendsRecommender = new FriendsRecommender(user, friends, visitors);

        List<String> answer = friendsRecommender.makeRecommendedFriendsList();

        return answer;
    }
}
