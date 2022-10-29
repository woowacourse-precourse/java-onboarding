package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Problem7 {

    private static final Set<String> realFriends = new HashSet<>();
    private static final Map<String, Integer> scores = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        findRealFriends(user, friends);
        addRelationScore(user, friends);
        addVisitScore(user, visitors);

        return recommendFriends();
    }

    private static List<String> recommendFriends() {
        List<String> list = new ArrayList<>();

        for (String s : scores.keySet()) {
            if (scores.get(s) > 0) {
                list.add(s);
            }
        }

        list.sort((o1, o2) -> {
            if (Objects.equals(scores.get(o1), scores.get(o2))) {
                return o1.compareTo(o2);
            }
            return scores.get(o2) - scores.get(o1);
        });

        return list;
    }

    private static void findRealFriends(String user, List<List<String>> friends) {

        for (List<String> friend : friends) {
            String f1 = friend.get(0);
            String f2 = friend.get(1);
            if (containUser(user, f1, f2)) {
                realFriends.add(f1);
                realFriends.add(f2);
            }
        }
    }

    private static void addRelationScore(String user, List<List<String>> friends) {

        for (List<String> friend : friends) {
            String f1 = friend.get(0);
            String f2 = friend.get(1);
            if (containUser(user, f1, f2)) {
                continue;
            }
            if (realFriends.contains(f1)) {
                scores.put(f2, scores.getOrDefault(f2, 0) + 10);
            }
            if (realFriends.contains(f2)) {
                scores.put(f1, scores.getOrDefault(f1, 0) + 10);
            }
        }
    }

    private static void addVisitScore(String user, List<String> visitors) {

        for (String visitor : visitors) {
            if (isUserOrRealFriend(user, visitor)) {
                continue;
            }
            scores.put(visitor, scores.getOrDefault(visitor, 0) + 1);
        }
    }

    private static boolean containUser(String user, String f1, String f2) {
        return Objects.equals(f1, user) || Objects.equals(f2, user);
    }

    private static boolean isUserOrRealFriend(String user, String visitor) {
        return Objects.equals(visitor, user) || realFriends.contains(visitor);
    }

}
