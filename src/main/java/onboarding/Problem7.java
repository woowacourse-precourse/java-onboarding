package onboarding;

import onboarding.problem7.FriendsRecommendation;

import java.util.List;

public class Problem7 {
    private static final int MAX_FRIENDS_SIZE = 10000;
    private static final int MAX_USER_LENGTH = 30;
    private static final int MAX_VISITOR_SIZE = 10000;

    private static final int MIN_FRIENDS_SIZE = 1;
    private static final int MIN_USER_LENGTH = 1;
    private static final int MIN_VISITOR_SIZE = 0;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        if (!validateUserAndList(user, friends, visitors)) {
            return null;
        }

        FriendsRecommendation friendsRecommendation = FriendsRecommendation.from(user);

        List<String> answer = friendsRecommendation.recommendFriends(friends, visitors);
        return answer;
    }

    public static boolean validateUserAndList(String user, List<List<String>> friends, List<String> visitors) {
        if (user.length() < MIN_USER_LENGTH || user.length() > MAX_USER_LENGTH) {
            return false;
        }

        if (friends.size() < MIN_FRIENDS_SIZE || friends.size() > MAX_FRIENDS_SIZE) {
            return false;
        }

        if (visitors.size() < MIN_VISITOR_SIZE || visitors.size() > MAX_VISITOR_SIZE) {
            return false;
        }

        return true;
    }
}
