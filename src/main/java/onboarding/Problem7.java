package onboarding;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    static void sortList(List<Map.Entry<String, Integer>> entries) {
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() < o2.getValue()) {
                    return 1;
                }

                if(o1.getValue() == o2.getValue()) {
                    if (o1.getKey().charAt(0) > o2.getKey().charAt(0)) {
                        return 1;
                    }

                    return -1;
                }

                return -1;
            }
        });
    }

    static void recommendFriend(List<Map.Entry<String, Integer>> entries, List<String> recommendedList) {
        for (Map.Entry<String, Integer> entry : entries) {
            recommendFriendException(entry, recommendedList);
        }
    }

    static void recommendFriendException(Map.Entry<String, Integer> entry, List<String> recommendedList) {
        if (entry.getValue() == 0) {
            return;
        }

        if (recommendedList.size() > 5) {
            return;
        }

        recommendedList.add(entry.getKey());
    }
}
