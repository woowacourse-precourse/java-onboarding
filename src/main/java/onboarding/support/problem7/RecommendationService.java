package onboarding.support.problem7;

import java.util.*;
import java.util.stream.Collectors;

public class RecommendationService {

    //함께 아는 친구
    private static final int ACQUAINTANCE_SCORE = 10;
    private static final int TIME_LINE_VISIT_SCORE = 1;
    private final List<String> sortedFriends;
    private final String user;

    public RecommendationService(List<List<String>> friends, String user, List<String> visitors) {
        this.user = user;
        this.sortedFriends = new ArrayList<>();

        Map<String, Set<String>> friendRelations = new HashMap<>();
        Map<String, Integer> scores = new HashMap<>();

        for (List<String> friend : friends) {
            makeFriendRelation(friendRelations, friend);
        }
        for (Map.Entry<String, Set<String>> friendEntry : friendRelations.entrySet()) {
            calculateAcquaintanceScore(friendRelations, scores, friendEntry);
        }

        Set<String> userFriendRelation = friendRelations.get(user);
        for (String visitor : visitors) {
            calculateTimelineVisitScore(scores, userFriendRelation, visitor);
        }

        List<Map.Entry<String, Integer>> sortedScores = sortList(scores);

        for (Map.Entry<String, Integer> scoresEntry : sortedScores) {
            this.sortedFriends.add(scoresEntry.getKey());
        }
    }

    private static List<Map.Entry<String, Integer>> sortList(Map<String, Integer> scores) {
        return scores
                .entrySet()
                .stream()
                .sorted(Comparator
                        .comparing(Map.Entry<String, Integer>::getValue)
                        .reversed().thenComparing(Map.Entry::getKey))
                .collect(Collectors.toList());
    }

    private static void calculateTimelineVisitScore(Map<String, Integer> scores, Set<String> userFriendRelations, String visitor) {
        if (!userFriendRelations.contains(visitor)) {
            scores.merge(visitor, TIME_LINE_VISIT_SCORE, Integer::sum);
        }
    }

    private void calculateAcquaintanceScore(Map<String, Set<String>> friendRelations, Map<String, Integer> scores,
                                            Map.Entry<String, Set<String>> friendEntries) {
        if (isNotUser(friendEntries.getKey())) {
            for (String relatedFriend : friendEntries.getValue()) {
                if (isUsersFriend(friendRelations.get(user), relatedFriend)) {
                    scores.merge(friendEntries.getKey(), ACQUAINTANCE_SCORE, Integer::sum);
                }
            }
        }
    }

    private static void makeFriendRelation(Map<String, Set<String>> friendRelations, List<String> friends) {
        String firstFriend = friends.get(0);
        String secondFriend = friends.get(1);

        friendRelations.computeIfAbsent(firstFriend, value -> new HashSet<>()).add(secondFriend);
        friendRelations.computeIfAbsent(secondFriend, value -> new HashSet<>()).add(firstFriend);
    }

    private boolean isNotUser(String name) {
        return !user.equals(name);
    }

    private boolean isUsersFriend(Set<String> usersFriends, String relatedFriend) {
        return usersFriends.contains(relatedFriend);
    }

    public List<String> getSortedFriends() {
        return sortedFriends;
    }
}
