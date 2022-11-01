package onboarding;

import onboarding.problem7.controller.FriendRecommendation;

import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new FriendRecommendation(user, friends, visitors).getRecommendUserList();
        return answer;
    }
}
