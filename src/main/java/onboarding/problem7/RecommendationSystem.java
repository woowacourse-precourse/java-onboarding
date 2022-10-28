package onboarding.problem7;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static onboarding.problem7.InputValueValidator.validateInputValue;

public class RecommendationSystem {

    private final FriendsService friendsService;
    private final VisitorService visitorService;

    public RecommendationSystem(FriendsService friendsService, VisitorService visitorService) {
        this.friendsService = friendsService;
        this.visitorService = visitorService;
    }

    public List<String> doRecommend(String user, List<List<String>> friends, List<String> visitors) {
        validateInputValue(user, friends, visitors);

        List<Friend> friendList = friendsService
                .mapToFriendList(getTotalScore(user, friends, visitors));

        return friendList.stream()
                .sorted()
                .map(Friend::getName)
                .collect(Collectors.toList());
    }

    private Map<String, Integer> getTotalScore(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> relationshipScore = friendsService.getRelationshipScore(user, friends);

        List<String> knownFriends = friendsService.getKnownFriends(user, friends);
        Map<String, Integer> visitScore = visitorService.getVisitScore(visitors, knownFriends);  // 유저가 알고있는 친구 정보를 준다.

        // 방문 점수를 relationshipScore로 합산.
        for (String friend : visitScore.keySet()) {
            int value = relationshipScore.getOrDefault(friend, 0) + visitScore.get(friend);
            relationshipScore.put(friend, value);
        }

        return relationshipScore;
    }
}
