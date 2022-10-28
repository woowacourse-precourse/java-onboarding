package onboarding.problem7;

import java.util.List;

import static onboarding.problem7.InputValueValidator.*;

public class RecommendationSystem {

    private final FriendsService friendsService;
    private final VisitorService visitorService;

    public RecommendationSystem(FriendsService friendsService, VisitorService visitorService) {
        this.friendsService = friendsService;
        this.visitorService = visitorService;
    }

    public List<String> doRecommend(String user, List<List<String>> friends, List<String> visitors) {
        validateInputValue(user, friends, visitors);

        return null;
    }
}
