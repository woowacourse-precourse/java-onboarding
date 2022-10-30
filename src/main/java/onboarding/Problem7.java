package onboarding;

import java.util.List;
import onboarding.problem7.AccountInfo;
import onboarding.problem7.FriendRecommendService;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        AccountInfo accountInfo = new AccountInfo(friends);
        FriendRecommendService friendRecommendService = new FriendRecommendService(
            accountInfo, visitors, user);

        return friendRecommendService.getRecommendedFriendsName();
    }
}
