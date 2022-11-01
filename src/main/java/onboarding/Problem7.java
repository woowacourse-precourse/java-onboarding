package onboarding;

import onboarding.problem7.FriendRecommendation;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        FriendRecommendation friendRecommendation = new FriendRecommendation(user, friends, visitors);
        answer = friendRecommendation.start();
        return answer;
    }
}
