package onboarding.support.problem7;

import java.util.*;
import java.util.stream.Collectors;

public class RecommendationService {

    //함께 아는 친구
    private static final int ACQUAINTANCE_SCORE = 10;
    private static final int TIME_LINE_VISIT_SCORE = 1;
    private final List<String> recommendationFriends;
    private final String user;

    public RecommendationService(List<List<String>> friends, String user, List<String> visitors) {
        this.user = user;

        this.recommendationFriends = new ArrayList<>();
        Map<String, Set<String>> friendRelations = new FriendRelation(friends).getFriendRelations();

        Map<String, Integer> scores = new HashMap<>();
        calculateScore(user, visitors, friendRelations, scores);

        List<Map.Entry<String, Integer>> sortedScores = sortList(scores);
        for (Map.Entry<String, Integer> scoresEntry : sortedScores) {
            this.recommendationFriends.add(scoresEntry.getKey());
        }
    }

    private void calculateScore(
            String user,
            List<String> visitors,
            Map<String, Set<String>> friendRelations,
            Map<String, Integer> scores
    ) {
        for (Map.Entry<String, Set<String>> friendEntry : friendRelations.entrySet()) {
            calculateAcquaintanceScore(friendRelations, scores, friendEntry);
        }

        Set<String> userFriendRelation = friendRelations.get(user);
        for (String visitor : visitors) {
            calculateTimelineVisitScore(scores, userFriendRelation, visitor);
        }
    }

    private static List<Map.Entry<String, Integer>> sortList(Map<String, Integer> scores) {
        return scores.entrySet()
                .stream()
                .sorted(Comparator
                        .comparing(Map.Entry<String, Integer>::getValue).reversed()
                        .thenComparing(Map.Entry::getKey))
                .collect(Collectors.toList());
    }

    private static void calculateTimelineVisitScore(
            Map<String, Integer> scores,
            Set<String> userFriendRelations,
            String visitor
    ) {
        if (!userFriendRelations.contains(visitor)) {
            scores.merge(visitor, TIME_LINE_VISIT_SCORE, Integer::sum);
        }
    }

    private void calculateAcquaintanceScore(
            Map<String, Set<String>> friendRelations,
            Map<String, Integer> scores,
            Map.Entry<String, Set<String>> friendEntries
    ) {
        if (isNotUser(friendEntries.getKey())) {
            for (String relatedFriend : friendEntries.getValue()) {
                if (isUsersFriend(friendRelations.get(user), relatedFriend)) {
                    scores.merge(friendEntries.getKey(), ACQUAINTANCE_SCORE, Integer::sum);
                }
            }
        }
    }

    private boolean isNotUser(String name) {
        return !user.equals(name);
    }

    private boolean isUsersFriend(Set<String> usersFriends, String relatedFriend) {
        return usersFriends.contains(relatedFriend);
    }

    public List<String> getRecommendationFriends() {
        return recommendationFriends;
    }
}
