package onboarding;

import java.util.*;
import java.util.stream.Collectors;


public class Problem7 {

    private static final int NEIGHBOR_POINT = 10;
    private static final int VISITOR_POINT = 1;
    private static final int RECOMMEND_USER = 5;
    private static List<String> USER_FRIENDS;
    private static Map<String, Integer> RECOMMEND_SCORE;


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        init();
        getUserFriends(user, friends);
        getRecommendScoreByRelationship(user, friends);
        getRecommendScoreByVisitor(visitors);
        return getTotalRecommendUsers();
    }

    private static void init() {
        USER_FRIENDS = new ArrayList<>();
        RECOMMEND_SCORE = new HashMap<>();
    }

    private static void getUserFriends(String user, List<List<String>> friends) {
        for (List<String> info : friends) {
            String userA = info.get(0);
            String userB = info.get(1);

            if (userA.equals(user))
                USER_FRIENDS.add(userB);
            if (userB.equals(user))
                USER_FRIENDS.add(userA);
        }
    }

    private static void getRecommendScoreByRelationship(String user, List<List<String>> friends) {
        for (List<String> info : friends) {
            String userA = info.get(0);
            String userB = info.get(1);

            if (isUserException(info, user) || isUserFriendException(userA, userB))
                continue;

            if (USER_FRIENDS.contains(userA))
                addToRecommendScoreMap(userB, NEIGHBOR_POINT);
            else if (USER_FRIENDS.contains(userB))
                addToRecommendScoreMap(userA, NEIGHBOR_POINT);
        }
    }

    private static boolean isUserException(List<String> info, String user) {
        return info.get(0).equals(user) || info.get(1).equals(user);
    }

    private static boolean isUserFriendException(String userA, String userB) {
        return USER_FRIENDS.contains(userA) && USER_FRIENDS.contains(userB);
    }

    private static void getRecommendScoreByVisitor(List<String> visitors) {
        for (String visitor : visitors) {
            if (USER_FRIENDS.contains(visitor))
                continue;
            addToRecommendScoreMap(visitor, VISITOR_POINT);
        }
    }

    private static void addToRecommendScoreMap(String user, int score) {
        RECOMMEND_SCORE.put(user, RECOMMEND_SCORE.containsKey(user) ? RECOMMEND_SCORE.get(user) + score : score);
    }

    private static List<String> getTotalRecommendUsers() {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(RECOMMEND_SCORE.entrySet());
        return entries.stream()
                .sorted((o1, o2) -> {
                    int num = Integer.compare(o2.getValue(), o1.getValue());
                    if (num == 0) {
                        num  = o1.getKey().compareTo(o2.getKey());
                    }
                    return num;
                })
                .limit(RECOMMEND_USER)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}