package onboarding.problem7;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RecommendationSystem {

    private final RelationshipService relationshipService;
    private final VisitorService visitorService;

    public RecommendationSystem(RelationshipService relationshipService, VisitorService visitorService) {
        this.relationshipService = relationshipService;
        this.visitorService = visitorService;
    }

    public List<String> doRecommend(String user, List<List<String>> friends, List<String> visitors) {
        List<Friend> friendList = relationshipService
                .totalScoreToFriendList(getTotalScore(user, friends, visitors));

        return friendList.stream()
                .filter(friend -> friend.getScore() > 0)
                .sorted()
                .map(Friend::getName)
                .limit(5)
                .collect(Collectors.toList());
    }

    private Map<String, Integer> getTotalScore(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> relationshipScore = relationshipService.getRelationshipScore(user, friends);

        List<String> knownFriends = relationshipService.getKnownFriends(user, friends);
        Map<String, Integer> visitScore = visitorService.getVisitScore(visitors, knownFriends);  // 유저가 알고있는 친구 정보를 준다.

        // 방문 점수를 relationshipScore로 합산.
        for (String friend : visitScore.keySet()) {
            int value = relationshipScore.getOrDefault(friend, 0) + visitScore.get(friend);
            relationshipScore.put(friend, value);
        }

        return relationshipScore;
    }
}
