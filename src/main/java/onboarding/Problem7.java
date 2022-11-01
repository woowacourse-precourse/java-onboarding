package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendsList = getFriendsList(friends);
        Map<String, Integer> score = scoreByAcquaintance(user, friendsList);
        score = scoreByVisitor(user, score, friendsList, visitors);
        List<String> answer = getRecommendFriends(score);
        return answer;
    }
    public static Map<String, List<String>> getFriendsList(List<List<String>> friends) {
        Map<String, List<String>> friendsList = new HashMap<>();
        for (int i = 0; i < friends.size(); i++) {
            if (!friendsList.containsKey(friends.get(i).get(0))) {
                friendsList.put(friends.get(i).get(0), new ArrayList<>());
            }
            friendsList.get(friends.get(i).get(0)).add(friends.get(i).get(1));
            if (!friendsList.containsKey(friends.get(i).get(1))) {
                friendsList.put(friends.get(i).get(1), new ArrayList<>());
            }
            friendsList.get(friends.get(i).get(1)).add(friends.get(i).get(0));
        }
        return friendsList;
    }
    public static Map<String, Integer> scoreByAcquaintance(String user, Map<String, List<String>> friendsList) {
        Map<String, Integer> score = new HashMap<>();
        List<String> acquaintance = friendsList.get(user);
        friendsList.forEach((key, value) -> {
            if (key != user && !acquaintance.contains(key)) {
                score.put(key, 0);
            }
        });
        friendsList.forEach((key, value) -> {
            if (key != user && !acquaintance.contains(key)) {
                for (int i = 0; i < value.size(); i++) {
                    if (acquaintance.contains(value.get(i))) {
                        score.put(key, score.get(key) + 10);
                    }
                }
            }
        });
        return score;
    }
    public static Map<String, Integer> scoreByVisitor(String user, Map<String, Integer> score,
                                                      Map<String, List<String>> friends, List<String> visitors) {
        for (int i = 0; i < visitors.size(); i++) {
            if (score.containsKey(visitors.get(i))) {
                score.put(visitors.get(i), score.get(visitors.get(i)) + 1);
            }else if(!friends.get(user).contains(visitors.get(i))) {
                score.put(visitors.get(i), 1);
            }
        }
        return score;
    }
    public static List<String> getRecommendFriends (Map<String, Integer> score) {
        List<String> recommendFriends = new ArrayList<>();
        SortedSet<Map.Entry<String, Integer>> sortedSet = new TreeSet<>((e1, e2) -> {
            int result = e1.getValue().compareTo(e2.getValue());
            if (result == 0)
                return e1.getKey().compareTo(e2.getKey());
            return result * -1;
        });
        sortedSet.addAll(score.entrySet());
        for (Map.Entry<String, Integer> entry : sortedSet) {
            if (entry.getValue() == 0 || recommendFriends.size() == 5) {
                break;
            }
            recommendFriends.add(entry.getKey());
        }
        return recommendFriends;
    }
}

