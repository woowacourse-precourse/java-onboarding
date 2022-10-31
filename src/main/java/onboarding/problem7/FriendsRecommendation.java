package onboarding.problem7;

import java.util.*;
import java.util.stream.Collectors;

public class FriendsRecommendation {
    private Set<String> friendsOfUser = new HashSet<>();
    private Map<String, Integer> recommendationsForUser = new TreeMap<>();
    private String user;

    private FriendsRecommendation(String user) {
        this.user = user;
    }

    public static FriendsRecommendation from(String user) {
        return new FriendsRecommendation(user);
    }

    public List<String> recommendFriends(List<List<String>> friends, List<String> visitors) {
        Set<String> visitorsOfUserPage = new TreeSet<>();

        findFriendsOfUser(friends);
        findRecommendationFromFriendsOfUser(friends);
        findRecommendationFromVisitors(visitors);
        removeExistFriends();

        // TreeMap 에서 이름 정렬은 완료, Collections.Sort 는 stable 한 sort 이기 때문에 value 에 대한 정렬만 한다.
        List<Map.Entry<String, Integer>> recommendationsForUserList
                = new LinkedList<Map.Entry<String, Integer>>(recommendationsForUser.entrySet());
        Collections.sort(recommendationsForUserList, (src, dest) -> dest.getValue() - src.getValue());

        return recommendationsForUserList
                .stream()
                .map(entry -> entry.getKey())
                .limit(5)
                .collect(Collectors.toList());
    }

    private void findFriendsOfUser(List<List<String>> friends) {
        friendsOfUser = friends.stream()
                .filter(pair -> pair.contains(user))
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    private void findRecommendationFromFriendsOfUser(List<List<String>> friends) {
        for (List<String> pair : friends) {
            if (friendsOfUser.contains(pair.get(0))) {
                recommendationsForUser
                        .put(pair.get(1), recommendationsForUser.getOrDefault(pair.get(1), 0) + 10);
            }
            if (friendsOfUser.contains(pair.get(1))) {
                recommendationsForUser
                        .put(pair.get(0), recommendationsForUser.getOrDefault(pair.get(0), 0) + 10);
            }
        }
    }

    private void findRecommendationFromVisitors(List<String> visitors) {
        visitors.forEach(visitor -> {
            recommendationsForUser
                    .put(visitor, recommendationsForUser.getOrDefault(visitor, 0) + 1);
        });
    }

    private void removeExistFriends() {
        friendsOfUser.forEach(friend -> recommendationsForUser.remove(friend));
    }
}