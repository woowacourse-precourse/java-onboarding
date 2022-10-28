package onboarding;

import java.util.List;
import onboarding.problem7.AccountRepository;
import onboarding.problem7.FriendRecommendService;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        AccountRepository accountRepository = new AccountRepository(friends);
        FriendRecommendService friendRecommendService = new FriendRecommendService(
            accountRepository, visitors, user);

        return friendRecommendService.getRecommendedFriendsName();
    }
}
