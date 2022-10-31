package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem7 {
    private static final int MAX_RECOMMEND_FRIENDS = 5;
    private static final int SCORE_ZERO = 0;
    public static List<String> solution(String mainUser, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendRelations = createFriendRelations(friends);
        Map<String, Integer> recommendScore = calculateRecommendScore(friendRelations, mainUser, visitors);

        removeScoreIfZero(recommendScore);

        return getSortedRecommendFriends(recommendScore);
    }

    private static Map<String, List<String>> createFriendRelations(List<List<String>> friends) {
        Map<String, List<String>> friendRelations = new HashMap<>();

        for (List<String> friend : friends) {
            String firstUser = friend.get(0);
            String secondUser = friend.get(1);

            addFriendInFriendRelation(friendRelations, firstUser, secondUser);
            addFriendInFriendRelation(friendRelations, secondUser, firstUser);
        }
        return friendRelations;
    }

    private static void addFriendInFriendRelation(Map<String, List<String>> friendRelations, String user,
        String userFriend) {

        List<String> userFriends = getUserFriends(friendRelations, user);
        userFriends.add(userFriend);
        friendRelations.put(user, userFriends);
    }

    private static List<String> getUserFriends(Map<String, List<String>> friendRelations, String user) {
        return friendRelations.getOrDefault(user, new ArrayList<>());
    }

    private static Map<String, Integer> calculateRecommendScore(Map<String, List<String>> friendRelations,
        String mainUser, List<String> visitors) {

        Map<String, Integer> recommendScore = new HashMap<>();
        List<String> mainUserFriends = friendRelations.get(mainUser);

        calculateRelationScore(friendRelations, mainUser, recommendScore, mainUserFriends);
        calculateVisitScore(visitors, recommendScore);

        removeRelationScoreIfFriendWithMainUser(recommendScore, mainUser, mainUserFriends);

        return recommendScore;
    }

    private static void calculateRelationScore(Map<String, List<String>> friendRelations, String mainUser,
        Map<String, Integer> recommendScore, List<String> mainUserFriends) {

        if (mainUserFriends == null) {
            return;
        }

        for (String mainUserFriend : mainUserFriends) {
            List<String> friendsOfMainUserFriend = friendRelations.get(mainUserFriend);

            for (String friendOfMainUserFriend : friendsOfMainUserFriend) {
                if (isFriendOfMainUserFriendIsMainUser(mainUser, friendOfMainUserFriend)) {
                    continue;
                }
                recommendScore.put(friendOfMainUserFriend, recommendScore.getOrDefault(friendOfMainUserFriend, 0) + 10);
            }
        }
    }

    private static boolean isFriendOfMainUserFriendIsMainUser(String mainUser, String friendOfMainUserFriend) {
        return friendOfMainUserFriend.equals(mainUser);
    }

    private static Map<String, Integer> calculateVisitScore(List<String> visitorsToMainUser,
        Map<String, Integer> recommendScore) {

        for (String visitorToMainUser : visitorsToMainUser) {
            recommendScore.put(visitorToMainUser, recommendScore.getOrDefault(visitorToMainUser, 0) + 1);
        }

        return recommendScore;
    }

    private static void removeRelationScoreIfFriendWithMainUser(Map<String, Integer> recommendScore, String mainUser,
        List<String> mainUserFriends) {
        if (mainUserFriends == null) {
            return;
        }

        for (String mainUserFriend : mainUserFriends) {
            recommendScore.remove(mainUserFriend);
        }
    }

    private static void removeScoreIfZero(Map<String, Integer> recommendScore) {
        for (String friend : recommendScore.keySet()) {
            if (recommendScore.get(friend) == SCORE_ZERO) {
                recommendScore.remove(friend);
            }
        }
    }

    private static List<String> getSortedRecommendFriends(Map<String, Integer> recommendScore) {
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(recommendScore.entrySet());
        entries.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        List<String> recommendFriends = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entries) {
            if (recommendFriends.size() == MAX_RECOMMEND_FRIENDS) {
                break;
            }
            recommendFriends.add(entry.getKey());
        }

        return recommendFriends;
    }
}
