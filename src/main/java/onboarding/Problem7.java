package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    private final static int TIMELINE_VISIT_SCORE = 1;
    private final static int KNOW_TOGETHER_SCORE = 10;

    private static Map<String, Integer> friendsScore;

    private static Set<String> userFriends;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        friendsScore = new HashMap<>();

        userFriends = createUserFriendsSet(user, friends);
        calculateFriendsRelationScore(user, friends);
        calculateTimelineVisitScore(visitors);

        return recommendFriendsByScore();
    }

    private static List<String> recommendFriendsByScore() {
        return friendsScore.entrySet().stream()
                .filter(Problem7::recommendPolicy)
                .sorted(Problem7::recommendListSortPolicy)
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static Set<String> createUserFriendsSet(String user, List<List<String>> friends) {
        return friends.stream()
                .filter(pair -> pair.contains(user))
                .flatMap(Collection::stream)
                .collect(Collectors.toCollection(HashSet::new));
    }

    private static void calculateFriendsRelationScore(String user, List<List<String>> friends) {
        friends.stream()
                .filter(pair -> !pair.contains(user))
                .forEach(Problem7::addScoreEachFriend);
    }

    private static void addScoreEachFriend(List<String> friendsPair) {
        final String p1 = friendsPair.get(0);
        final String p2 = friendsPair.get(1);
        addSecondScoreIfUserKnowFirst(p1, p2);
        addSecondScoreIfUserKnowFirst(p2, p1);
    }

    private static void addSecondScoreIfUserKnowFirst(String p1, String p2) {
        if (userFriends.contains(p1)) {
            friendsScore.put(p2, friendsScore.getOrDefault(p2, 0) + KNOW_TOGETHER_SCORE);
        }
    }

    private static void calculateTimelineVisitScore(List<String> visitors) {
        visitors.forEach(visitor ->
                friendsScore.put(visitor, friendsScore.getOrDefault(visitor, 0) + TIMELINE_VISIT_SCORE)
        );
    }

    private static boolean recommendPolicy(Map.Entry<String, Integer> userScore) {
        return recommendIfNot0Score(userScore) && notAlreadyFriend(userScore);
    }

    private static boolean recommendIfNot0Score(Map.Entry<String, Integer> userScore) {
        return userScore.getValue() != 0;
    }

    private static boolean notAlreadyFriend(Map.Entry<String, Integer> userScore) {
        return !userFriends.contains(userScore.getKey());
    }

    private static int recommendListSortPolicy(
            Map.Entry<String, Integer> userScore1,
            Map.Entry<String, Integer> userScore2) {
        if (Objects.equals(userScore1.getValue(), userScore2.getValue())) {
            return userScore1.getKey().compareTo(userScore2.getKey());
        }
        return userScore2.getValue().compareTo(userScore1.getValue());
    }
}
