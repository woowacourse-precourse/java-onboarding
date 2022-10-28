package onboarding.problem7;

import java.util.*;
import java.util.stream.Collectors;

public class RecommendFactory {

    private static final Integer LIMITED_SIZE = 5;

    public static List<String> getRecommendFriendList(List<Recommend> recommendList) {
        final HashMap<String, Integer> map = input(recommendList);
        return recommendFriendLimitedSortedList(map);
    }

    private static List<String> recommendFriendLimitedSortedList(HashMap<String, Integer> map) {
        return map.entrySet().stream()
                .sorted(Collections
                        .reverseOrder(Map.Entry.<String, Integer>comparingByValue())
                        .thenComparing(Map.Entry.comparingByKey())
                )
                .map(Map.Entry::getKey)
                .limit(LIMITED_SIZE)
                .collect(Collectors.toUnmodifiableList());
    }

    private static HashMap<String, Integer> input(List<Recommend> recommendList) {
        HashMap<String, Integer> map = new HashMap<>();
        recommendList.forEach(recommend ->
                        map.put(recommend.getName(),
                        map.getOrDefault(recommend.getName(), 0) + recommend.getScore()));
        return map;
    }
}
