package onboarding.problem7;

import java.util.*;
import java.util.stream.Collectors;

public class SNSFriendRecommender {
    private static final int RECOMMENDED_FRIEND_MAX_NUM = 5;
    private static final int FRIEND_KNOW_TOGETHER_PLUS_SCORE = 10;
    private static final int VISITOR_PLUS_SCORE = 1;

    private final String targetUser;
    private final List<String> targetUserFriends;
    private LinkedHashMap<String, Integer> scores = new LinkedHashMap<>();

    public SNSFriendRecommender(String targetUser, List<String> visitors, FriendRelation friendRelation) {
        this.targetUser = targetUser;
        Map<String, List<String>> relations = friendRelation.getRelations();
        this.targetUserFriends = relations.getOrDefault(targetUser, new ArrayList<>());
        initScores(visitors, relations);
    }

    private void initScores(List<String> visitors, Map<String, List<String>> relations) {
        if (!this.targetUserFriends.isEmpty()) {
            addScoreOfUserKnowTogether(getTotalUsersKnowTogether(relations));
        }
        addVisitorScore(visitors);
        sortScores((e1, e2) -> {
            Integer e1Value = e1.getValue();
            Integer e2Value = e2.getValue();
            if (e1Value.equals(e2Value))
                return e1.getKey().compareTo(e2.getKey());
            return e2Value.compareTo(e1Value);
        });
    }

    private void sortScores(Comparator<Map.Entry<String, Integer>> comparator) {
        Map<String, Integer> unsortedMap = Map.copyOf(scores);
        scores.clear();
        scores = unsortedMap.entrySet().stream()
                .sorted(comparator)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }

    private List<String> getTotalUsersKnowTogether(Map<String, List<String>> relations) {
        List<String> totalUsersKnowTogether = new ArrayList<>();
        for (String friend : this.targetUserFriends) {
            List<String> usersKnowTogether = relations.getOrDefault(friend, new ArrayList<>());
            totalUsersKnowTogether.addAll(usersKnowTogether);
        }
        return totalUsersKnowTogether;
    }

    private void addScoreOfUserKnowTogether(List<String> totalUsersKnowTogether) {
        addScore(totalUsersKnowTogether, FRIEND_KNOW_TOGETHER_PLUS_SCORE);
    }

    private void addVisitorScore(List<String> visitors) {
        addScore(visitors, VISITOR_PLUS_SCORE);
    }

    private void addScore(List<String> scoringUser, int addedScoreGap) {
        for (String user : scoringUser) {
            if (isExclusiveUser(user))
                continue;
            Integer userScore = scores.getOrDefault(user, 0);
            scores.put(user, userScore + addedScoreGap);
        }
    }

    private boolean isExclusiveUser(String user) {
        return user.equals(this.targetUser) ||
                (!this.targetUserFriends.isEmpty() && this.targetUserFriends.contains(user));
    }
}
