package onboarding;

import java.util.Collections;
import java.util.List;
import onboarding.problem7.FriendSystem;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        FriendSystem friendSystem = new FriendSystem();
        answer = friendSystem.getRecommendedFriendsList(user, friends, visitors);
        return answer;
    }
}
