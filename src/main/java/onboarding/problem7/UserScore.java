package onboarding.problem7;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UserScore {

    private static final int KNOW_SCORE = 10;
    private static final int VISIT_SCORE = 1;

    private final UserGraph userGraph;
    private final String targetUser;
    private final List<String> visitors;

    public UserScore(String targetUser, List<List<String>> friends, List<String> visitors) {
        this.targetUser = targetUser;
        this.userGraph = new UserGraph(friends);
        this.visitors = visitors;
    }

    public List<String> findRecommendedUsers(int limit) {
        Map<String, Integer> userToScore = new HashMap<>();

        scoreFriendsOfFriends(userToScore);
        scoreVisitors(userToScore);
        removeSelfOrNeighbors(userToScore);

        return sortByScore(userToScore, limit);
    }

    private void scoreFriendsOfFriends(Map<String, Integer> userToScore) {
        Set<String> userFriends = userGraph.getFriends(targetUser);

        for (String commonFriend : userFriends) {
            Set<String> candidates = userGraph.getFriends(commonFriend);
            plusScore(userToScore, candidates, KNOW_SCORE);
        }
    }

    private void scoreVisitors(Map<String, Integer> userToScore) {
        plusScore(userToScore, visitors, VISIT_SCORE);
    }

    private void removeSelfOrNeighbors(Map<String, Integer> userToScore) {
        userToScore.remove(targetUser);
        Set<String> userFriends = userGraph.getFriends(targetUser);
        userFriends.forEach(userToScore::remove);
    }

    private void plusScore(Map<String, Integer> userToScore, Collection<String> candidates, int value) {
        for (String candidate : candidates) {
            int newScore = userToScore.getOrDefault(candidate, 0) + value;
            userToScore.put(candidate, newScore);
        }
    }

    private List<String> sortByScore(Map<String, Integer> userToScore, int limit) {
        return userToScore.entrySet()
                .stream()
                .filter(UserScore::isNotZeroScore)
                .sorted(UserScore::compare)
                .limit(limit)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
        int scoreOfA = a.getValue();
        int scoreOfB = b.getValue();

        if (scoreOfA == scoreOfB) {
            return sortByName(a, b);
        }

        return scoreOfB - scoreOfA;
    }

    private static int sortByName(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
        String nameOfA = a.getKey();
        String nameOfB = b.getKey();
        return nameOfA.compareTo(nameOfB);
    }

    private static boolean isNotZeroScore(Map.Entry<String, Integer> entry) {
        return entry.getValue() != 0;
    }

}
