package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.Iterator;

public class Problem7 {
    public static final Integer KNOW_TOGETHER_SCORE = 10;
    public static final Integer VISIT_SCORE = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> friendList = getFriendList(user, friends);
        List<String> knowTogetherList = getKnowTogetherList(user, friendList, friends);
        Map<String, Integer> knowTogetherScoreMap = getKnowTogetherScoreMap(knowTogetherList);
        Map<String, Integer> visitScoreMap = getVisitScoreMap(visitors, friendList);
        Map<String, Integer> totalScoreMap = calculateTotalScoreMap(knowTogetherScoreMap, visitScoreMap);
        answer = makeRecommendFriendList(totalScoreMap);
        return answer;
    }

    public static List<String> getFriendList(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();
        int rowLength = friends.size();
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                friendList.addAll(friend);
            }
        }
        friendList.removeAll(Collections.singleton(user));
        return friendList;
    }

    public static List<String> getKnowTogetherList(String user, List<String> friendList, List<List<String>> friends) {
        List<String> knowTogetherList = new ArrayList<>();
        for (int i = 0; i < friendList.size(); i++) {
            for (List<String> friend : friends) {
                if (friend.containsAll(friendList.subList(i, i + 1))) {
                    knowTogetherList.addAll(friend);
                }
            }
        }
        knowTogetherList.removeAll(friendList);
        knowTogetherList.removeAll(Collections.singleton(user));
        return knowTogetherList;
    }

    public static Map<String, Integer> getKnowTogetherScoreMap(List<String> knowTogetherList) {
        Map<String, Integer> knowTogetherScoreMap = new HashMap<>();
        for (String name : knowTogetherList) {
            if (knowTogetherScoreMap.containsKey(name)) {
                knowTogetherScoreMap.put(name, knowTogetherScoreMap.get(name) + KNOW_TOGETHER_SCORE);
            } else {
                knowTogetherScoreMap.put(name, KNOW_TOGETHER_SCORE);
            }
        }
        return knowTogetherScoreMap;
    }

    public static Map<String, Integer> getVisitScoreMap(List<String> visitors, List<String> friendList) {
        Map<String, Integer> visitScoreMap = new HashMap<>();
        for (String name : visitors) {
            if (visitScoreMap.containsKey(name)) {
                visitScoreMap.put(name, visitScoreMap.get(name) + VISIT_SCORE);
            } else {
                visitScoreMap.put(name, VISIT_SCORE);
            }
        }
        for (String name : friendList) {
            visitScoreMap.remove(name);
        }
        return visitScoreMap;
    }

    public static Map<String, Integer> calculateTotalScoreMap(Map<String, Integer> knowTogetherScoreMap, Map<String, Integer> visitScoreMap) {
        Map<String, Integer> totalScoreMap = new HashMap<>();
        visitScoreMap.forEach((key, value) -> knowTogetherScoreMap.merge(key, value, (v1, v2) -> v1 + v2));
        totalScoreMap = knowTogetherScoreMap;
        return totalScoreMap;
    }

    public static List<String> makeRecommendFriendList(Map<String, Integer> totalScoreMap) {
        List<String> recommendFriendList = new ArrayList<>();
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(totalScoreMap.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparison = (o1.getValue() - o2.getValue()) * -1;
                if (comparison == 0) {
                    return o1.getKey().compareTo(o2.getKey());
                } else {
                    return comparison;
                }
            }
        });
        Map<String, Integer> sortedTotalScoreMap = new LinkedHashMap<>();
        for (Iterator<Map.Entry<String, Integer>> iterator = entryList.iterator(); iterator.hasNext(); ) {
            Map.Entry<String, Integer> entry = iterator.next();
            sortedTotalScoreMap.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Integer> name : sortedTotalScoreMap.entrySet()) {
            recommendFriendList.add(name.getKey());
        }
        return recommendFriendList;
    }
}
