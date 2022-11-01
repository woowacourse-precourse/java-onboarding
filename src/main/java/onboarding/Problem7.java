package onboarding;

import java.util.*;

public class Problem7 {
    private static final int MAX_RECOMMEND_FRIENDS_SIZE = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        if (!validateInput(user, friends, visitors)) {
            return null;
        }
        return calculateAnswer(user, friends, visitors);
    }

    private static boolean validateInput(String user, List<List<String>> friends, List<String> visitors) {
        return Validation.validate(user, friends, visitors);
    }

    private static List<String> calculateAnswer(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendsMap = calculateFriendsMap(friends);
        Map<String, Integer> friendsScoreMap = calculateFriendsScoreMap(user, friendsMap);
        calculateVisitorsScoreMap(visitors, friendsScoreMap);
        return calculateRecommendFriendsList(user, friendsScoreMap, friendsMap);
    }

    private static Map<String, List<String>> calculateFriendsMap(List<List<String>> friends) {
        Map<String, List<String>> friendsMap = new HashMap<>();

        for (List<String> friend : friends) {
            String firstFriend = friend.get(0);
            String secondFriend = friend.get(1);
            friendsMap.put(firstFriend, calculateFriendFriendList(firstFriend, secondFriend, friendsMap));
            friendsMap.put(secondFriend, calculateFriendFriendList(secondFriend, firstFriend, friendsMap));
        }
        return friendsMap;
    }

    private static List<String> calculateFriendFriendList(String firstFriend, String secondFriend, Map<String, List<String>> friendsMap) {
        List<String> newFriendList = friendsMap.getOrDefault(firstFriend, new ArrayList<>());
        newFriendList.add(secondFriend);
        return newFriendList;
    }

    private static Map<String, Integer> calculateFriendsScoreMap(String user, Map<String, List<String>> friendsMap) {
        Map<String, Integer> friendsScoreMap = new HashMap<>();

        for (String userFriend : friendsMap.get(user)) {
            for (String userFriendFriend : friendsMap.get(userFriend)) {
                friendsScoreMap.put(userFriendFriend, friendsScoreMap.getOrDefault(userFriendFriend, 0) + 10);
            }
        }
        return friendsScoreMap;
    }

    private static void calculateVisitorsScoreMap(List<String> visitors, Map<String, Integer> friendsScoreMap) {
        for (String visitor : visitors) {
            friendsScoreMap.put(visitor, friendsScoreMap.getOrDefault(visitor, 0) + 1);
        }
    }

    private static List<String> calculateRecommendFriendsList(String user, Map<String, Integer> friendsScoreMap, Map<String, List<String>> friendsMap) {
        int friendsCount = 0;
        List<String> recommendFriendsList = new ArrayList<>();
        Map<String, Integer> recommendFriendsMap = sortMapByValueThenKey(friendsScoreMap);

        for (String friend : new LinkedList<>(recommendFriendsMap.keySet())) {
            if (calculateValidUserFriend(user, friend, friendsMap, friendsCount)) {
                friendsCount++;
                recommendFriendsList.add(friend);
            }
        }
        return recommendFriendsList;
    }

    private static boolean calculateValidUserFriend(String user, String friend, Map<String, List<String>> friendsMap, int friendsCount) {
        return !friend.equals(user)
                && friendsCount < MAX_RECOMMEND_FRIENDS_SIZE
                && !friendsMap.get(user).contains(friend);
    }

    private static Map<String, Integer> sortMapByValueThenKey(Map<String, Integer> friendsScoreMap) {
        SortedSet<Map.Entry<String, Integer>> sortedSet = new TreeSet<>((e1, e2) -> {
            int result = e1.getValue().compareTo(e2.getValue());
            if (result == 0)
                return e1.getKey().compareTo(e2.getKey());
            return result * -1;
        });
        sortedSet.addAll(friendsScoreMap.entrySet());
        return convertSortedSetToMap(sortedSet);
    }

    private static Map<String, Integer> convertSortedSetToMap(SortedSet<Map.Entry<String, Integer>> sortedSet) {
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (var entry : sortedSet)
            sortedMap.put(entry.getKey(), entry.getValue());
        return sortedMap;
    }

    static abstract class Validation {

        private static final int MIN_USER_ID_LENGTH = 1;
        private static final int MAX_USER_ID_LENGTH = 30;
        private static final int MIN_FRIENDS_SIZE = 1;
        private static final int MAX_FRIENDS_SIZE = 10000;
        private static final int MIN_VISITORS_SIZE = 0;
        private static final int MAX_VISITORS_SIZE = 10000;
        private static final String LOWER_ALPHABET_REGEX = "^[a-z]*$";

        public static boolean validate(String user, List<List<String>> friends, List<String> visitors) {
            return validateUserIdLength(user)
                    && validateFriendsSize(friends)
                    && validateFriendsList(friends)
                    && validateVisitorsSize(visitors);
        }

        private static boolean validateUserIdLength(String user) {
            return user.length() >= MIN_USER_ID_LENGTH
                    && user.length() <= MAX_USER_ID_LENGTH;
        }

        private static boolean validateFriendsSize(List<List<String>> friends) {
            return friends.size() >= MIN_FRIENDS_SIZE
                    && friends.size() <= MAX_FRIENDS_SIZE;
        }

        private static boolean validateFriendsList(List<List<String>> friends) {
            for (List<String> friend : friends) {
                if (friend.size() != 2) {
                    return false;
                }
                if (!validateUserIdLength(friend.get(0)) || !validateUserIdLength(friend.get(1))) {
                    return false;
                }
                if (!validateLowerAlphabet(friend.get(0)) || !validateLowerAlphabet(friend.get(1))) {
                    return false;
                }
            }
            return true;
        }

        private static boolean validateLowerAlphabet(String user) {
            return user.matches(LOWER_ALPHABET_REGEX);
        }

        private static boolean validateVisitorsSize(List<String> visitors) {
            return visitors.size() >= MIN_VISITORS_SIZE
                    && visitors.size() <= MAX_VISITORS_SIZE;
        }
    }
}
