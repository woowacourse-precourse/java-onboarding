package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Problem7 {

    public static final int INITIAL_SCORE = 0;
    public static final int SCORE_MUTUAL_FRIEND = 10;
    public static final int SCORE_VISITOR = 1;
    public static final int MAX_SIZE = 5;
    private static HashMap<String, Integer> score = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        initializeScore(friends, visitors);
        handleVisitors(visitors);

        List<String> directFriendsOfUser = getDirectFriends(user, friends);
        handleMutualFriends(friends, directFriendsOfUser);

        removeElementsFromScore(directFriendsOfUser);
        removeElementFromScore(user);

        return formatScore();
    }

    private static List<String> formatScore() {
        return score.keySet().stream()
                .filter(isScoreBiggerThanZero())
                .sorted()
                .sorted(sortByScoreInDescendingOrder())
                .limit(MAX_SIZE)
                .collect(Collectors.toList());
    }

    private static Comparator<String> sortByScoreInDescendingOrder() {
        return (e1, e2) -> score.get(e2).compareTo(score.get(e1));
    }

    private static Predicate<String> isScoreBiggerThanZero() {
        return element -> score.get(element) > 0;
    }

    private static void removeElementFromScore(String user) {
        score.keySet().remove(user);
    }

    private static void removeElementsFromScore(List<String> directFriendsOfUser) {
        score.keySet().removeAll(directFriendsOfUser);
    }

    private static void handleVisitors(List<String> visitors) {
        for (String visitor : visitors) {
            updateScore(visitor,SCORE_VISITOR);
        }
    }

    private static void updateScore(String target, int addedScore) {
        score.put(target, score.get(target) + addedScore);
    }

    private static void initializeScore(List<List<String>> friends, List<String> visitors) {
        for (List<String> pairedFriends : friends) {
            initialize(pairedFriends);
        }
        initialize(visitors);
    }

    private static void initialize(List<String> targets) {
        for (String target : targets) {
            score.put(target, INITIAL_SCORE);
        }
    }

    private static void handleMutualFriends(List<List<String>> friends, List<String> directFriends) {
        for (String directFriend : directFriends) {
            List<String> mutualFriends = getDirectFriends(directFriend, friends);
            mutualFriends.remove(directFriends);
            for (String mutualFriend : mutualFriends) {
                updateScore(mutualFriend,SCORE_MUTUAL_FRIEND);
            }
        }
    }

    private static List<String> getDirectFriends(String target, List<List<String>> friends) {
        List<String> directFriends = new ArrayList<>();
        for (List<String> friendPair : getFriendPairsWithTarget(target, friends)) {
            for (String directFriend : friendPair) {
                if (!directFriend.equals(target)) {
                    directFriends.add(directFriend);
                }
            }
        }
        return directFriends;
    }

    private static List<List<String>> getFriendPairsWithTarget(String target, List<List<String>> friends) {
        List<List<String>> friendPairs = friends.stream()
                .filter(friendPair -> friendPair.contains(target))
                .collect(Collectors.toList());
        return friendPairs;
    }
}
