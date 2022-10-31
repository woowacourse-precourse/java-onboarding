package onboarding;

import static onboarding.Problem7.FRIEND_SCORE;
import static onboarding.Problem7.VISITOR_SCORE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Problem7 {

    public static final Integer FRIEND_SCORE = 10;
    public static final Integer VISITOR_SCORE = 1;

    public static final int RESULT_MAX_SIZE = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Map<String, RecommendFriend> recommendFriendsMap = new HashMap<>();
        List<String> userFriends = new ArrayList<>();

        findFriends(user, friends, recommendFriendsMap, userFriends);
        findVisitors(visitors, recommendFriendsMap, userFriends);

        List<RecommendFriend> recommendFriends = new ArrayList<>(recommendFriendsMap.values());

        Collections.sort(recommendFriends);

        List<String> result = new ArrayList<>();

        for (int i = 0; i < recommendFriends.size(); ++i) {
            if (i >= RESULT_MAX_SIZE) {
                break;
            }

            result.add(recommendFriends.get(i).getName());
        }

        return result;
    }

    private static void findFriends(String user, List<List<String>> friends,
                                    Map<String, RecommendFriend> recommendFriendsMap, List<String> userFriends) {

        for (List<String> friend : friends) {
            if (isContains(user, friend)) {
                userFriends.add(friend.get(0).equals(user) ? friend.get(1) : friend.get(0));
            }
        }

        for (String userFriend : userFriends) {
            for (List<String> friend : friends) {
                if (isContains(userFriend, friend) && !isContains(user, friend)) {
                    String friendCandidate = friend.get(0).equals(userFriend) ? friend.get(1) : friend.get(0);

                    if (getRecommendFriend(recommendFriendsMap, friendCandidate) == null) {
                        putRecommendFriend(recommendFriendsMap, friendCandidate, FRIEND_SCORE);
                    } else {
                        getRecommendFriend(recommendFriendsMap, friendCandidate).friendPlusScore();
                    }
                }
            }
        }
    }

    private static void findVisitors(List<String> visitors, Map<String, RecommendFriend> recommendFriendsMap,
                                     List<String> userFriends) {

        for (String visitor : visitors) {
            if (isContains(visitor, userFriends)) {
                continue;
            }

            if (getRecommendFriend(recommendFriendsMap, visitor) == null) {
                putRecommendFriend(recommendFriendsMap, visitor, VISITOR_SCORE);
            } else {
                getRecommendFriend(recommendFriendsMap, visitor).visitPlusScore();
            }

        }
    }

    private static void putRecommendFriend(Map<String, RecommendFriend> recommendFriendsMap, String friendCandidate, Integer friendScore) {
        recommendFriendsMap.put(friendCandidate, new RecommendFriend(friendCandidate, friendScore));
    }

    private static boolean isContains(String user, List<String> friend) {
        return friend.contains(user);
    }

    private static RecommendFriend getRecommendFriend(Map<String, RecommendFriend> recommendFriendsMap, String visitor) {
        return recommendFriendsMap.get(visitor);
    }
}

class RecommendFriend implements Comparable<RecommendFriend> {

    private final String name;
    private int score;

    public RecommendFriend(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void friendPlusScore() {
        this.score += FRIEND_SCORE;
    }

    public void visitPlusScore() {
        this.score += VISITOR_SCORE;
    }

    @Override
    public int compareTo(RecommendFriend o) {
        if (o.getScore() == this.getScore()) {
            return this.name.compareTo(o.name);
        }

        return o.getScore() - this.getScore();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RecommendFriend that = (RecommendFriend) o;
        return score == that.score && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
