package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static final int FIRST_USER_INDEX = 0;
    public static final int SECOND_USER_INDEX = 1;
    public static final int MAX_RECOMMEND_NUM = 5;
    public static final int MINIMUM_USER_RANGE = 1;
    public static final int MAXIMUM_USER_RANGE = 30;
    public static final int MINIMUM_FRIENDS_SIZE = 1;
    public static final int MAXIMUM_FRIENDS_SIZE = 10000;
    public static final int MINIMUM_VISITOR_SIZE = 0;
    public static final int MAXIMUM_VISITOR_SIZE = 10000;
    public static final int FRIENDS_LIST_SIZE = 2;
    public static final int MINIMUM_ID_LENGTH = 1;
    public static final int MAXIMUM_ID_LENGTH = 30;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
        validateUserRange(user);
        validateFriends(friends);
        validateVisitors(visitors);
        validateRecommendFriends(recommendFriends);
    }

    private static void validateUserRange(String user) {
        if (user.length() < MINIMUM_USER_RANGE || MAXIMUM_USER_RANGE < user.length()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateFriends(List<List<String>> friends) {
        validateFiendsSize(friends);
        validateFriendsList(friends);
    }

    private static void validateFiendsSize(List<List<String>> friends) {
        if (friends.size() < MINIMUM_FRIENDS_SIZE || MAXIMUM_FRIENDS_SIZE < friends.size()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateFriendsList(List<List<String>> friends) {
        for (List<String> friend : friends) {
            validateFriendListSize(friend);

            validateIdLength(getFirstUserName(friend));
            validateLowerCase(getFirstUserName(friend));

            validateIdLength(getSecondUserName(friend));
            validateLowerCase(getSecondUserName(friend));
        }
    }

    private static void validateFriendListSize(List<String> friend) {
        if (friend.size() != FRIENDS_LIST_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateIdLength(String id) {
        if (id.length() < MINIMUM_ID_LENGTH || MAXIMUM_ID_LENGTH < id.length()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateLowerCase(String id) {
        for (char c : id.toCharArray()) {
            if (!Character.isLowerCase(c)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void validateVisitors(List<String> visitors) {
        validateVisitorsSize(visitors);

        for (String visitor : visitors) {
            validateIdLength(visitor);
            validateLowerCase(visitor);
        }
    }

    private static void validateVisitorsSize(List<String> visitors) {
        if (visitors.size() < MINIMUM_VISITOR_SIZE || MAXIMUM_VISITOR_SIZE < visitors.size()) {
            throw new IllegalArgumentException();
        }
    }


    private static void validateRecommendFriends(List<String> recommendFriends) {
        if (recommendFriends.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
    private static String getSecondUserName(List<String> userNames) {
        return userNames.get(SECOND_USER_INDEX);
    }

    private static String getFirstUserName(List<String> userNames) {
        return userNames.get(FIRST_USER_INDEX);
    }
}
