package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static final Map<String, ArrayList<String>> FRIEND_MAP = new HashMap<>();
    private static final Map<String, Integer> RECOMMEND_SCORE = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        clearScore();
        setFriendMap(friends);
        countPoint(user, visitors);
        answer = recommendFriend();
        return answer;
    }

    private static void clearScore() {
        FRIEND_MAP.clear();
        RECOMMEND_SCORE.clear();
    }

    private static List<String> recommendFriend() {
        List<String> keys = Collections.emptyList();
        List<Map.Entry<String, Integer>> entries = getSortedList();
        removeZeroScore(entries);
        keys = getTop5KeyList(entries);
        return keys;
    }

    private static void removeZeroScore(List<Map.Entry<String, Integer>> entries) {
        entries.removeIf(entry -> entry.getValue().equals(0));
    }

    private static List<String> getTop5KeyList(List<Map.Entry<String, Integer>> entries) {
        if (entries.size() > 5)
            entries = entries.subList(0, 5);
        return entries.stream().map(Map.Entry::getKey).collect(Collectors.toList());
    }

    private static List<Map.Entry<String, Integer>> getSortedList() {
        Comparator<Map.Entry<String, Integer>> comparator = (e1, e2) -> {
            if (e2.getValue().compareTo(e1.getValue()) == 0) {
                return e1.getKey().compareTo((e2.getKey()));
            }
            return e2.getValue().compareTo(e1.getValue());
        };
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(RECOMMEND_SCORE.entrySet());
        return entries.stream().sorted(comparator).collect(Collectors.toList());
    }

    private static void setFriendMap(List<List<String>> friends) {
        for (List<String> relation : friends) {
            String leftUser = relation.get(0);
            String rightUser = relation.get(1);
            setFriend(leftUser, rightUser);
            setFriend(rightUser, leftUser);
        }
    }

    private static void setFriend(String leftUser, String rightUser) {
        if (FRIEND_MAP.containsKey(leftUser)) {
            FRIEND_MAP.get(leftUser).add(rightUser);
        } else {
            FRIEND_MAP.put(leftUser, new ArrayList<>(Collections.singletonList(rightUser)));
        }
    }

    private static void countPoint(String user, List<String> visitors) {
        countFriendPoint(user);
        countVisitorPoint(visitors);
        removeCountAlreadyFriend(user);
    }

    private static void removeCountAlreadyFriend(String user) {
        for (String friend : FRIEND_MAP.get(user)) {
            RECOMMEND_SCORE.put(friend, 0);
        }
    }

    private static void countVisitorPoint(List<String> visitors) {
        for (String visitor : visitors) {
            addScore(visitor, 1);
        }
    }

    private static void countFriendPoint(String user) {
        for (String friend : FRIEND_MAP.get(user)) {
            for (String userToEarnScore : FRIEND_MAP.get(friend)) {
                if (!userToEarnScore.equals(friend) && !userToEarnScore.equals(user)) {
                    addScore(userToEarnScore, 10);
                }
            }
        }
    }

    private static void addScore(String key, Integer delta) {
        if (RECOMMEND_SCORE.containsKey(key)) {
            RECOMMEND_SCORE.put(key, RECOMMEND_SCORE.get(key) + delta);
        } else {
            RECOMMEND_SCORE.put(key, delta);
        }
    }
}
