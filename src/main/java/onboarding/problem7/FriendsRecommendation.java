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

        return null;
    }

    private void findFriendsOfUser(List<List<String>> friends) {
        friendsOfUser = friends.stream()
                .filter(pair -> pair.contains(user))
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    private void findRecommendationFromFriendsOfUser(List<List<String>> friends) {
        // TODO: 유저의 친구의 친구들을 찾는다. 단 friendsOfUser 에 포함된 친구여선 안된다.
    }

    private void findRecommendationFromVisitors(List<String> visitors) {
        // TODO: visitors 의 알고리즘 추천 점수를 올려준다.
    }

    private void removeExistFriends() {
        // TODO: User의 기존 친구들은 제거해주는 알고리즘이 필요하다.
    }
}