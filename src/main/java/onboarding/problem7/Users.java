package onboarding.problem7;

import java.util.*;
import java.util.stream.Collectors;

public class Users {

    private final int CO_FRIEND_SCORE = 10;
    private final int VISITOR_SCORE = 1;
    private final int RECOMMEND_COUNT = 5;

    private final List<User> users;

    public Users() {
        this.users = new ArrayList<>();
    }

    private Optional<User> findUserById(String id) {
        return users.stream()
                .filter(user -> user.isSame(id))
                .findAny();
    }

    public User getUserById(String id) {
        Optional<User> user = findUserById(id);

        if (user.isPresent()) return user.get();

        User newUser = new User(id);
        users.add(newUser);

        return newUser;
    }

    public List<String> recommendFriends(String id, List<String> visitors) {

        User user = getUserById(id);

        return getScore(user, visitors).entrySet().stream()
                .filter(e -> e.getValue() != 0)
                .filter(e -> !user.hasFriend(e.getKey()))
                .sorted((e1, e2) -> {
                    int compareValue = Integer.compare(e2.getValue(), e1.getValue());

                    if (compareValue == 0) return e1.getKey().compareTo(e2.getKey());
                    return compareValue;
                })
                .limit(RECOMMEND_COUNT)
                .map(Map.Entry::getKey)
                .map(User::getId)
                .collect(Collectors.toList());
    }

    private Map<User, Integer> getScore(User user, List<String> visitors) {

        Map<User, Integer> scoreMap = new HashMap<>();

        getCoFriendScore(user, scoreMap);
        getVisitorScore(visitors, scoreMap);

        return scoreMap;
    }

    private void getCoFriendScore(User user, Map<User, Integer> scoreMap) {
        for (User candidate : users) {
            if (candidate.equals(user)) continue;
            scoreMap.put(candidate, candidate.countCoFriends(user) * CO_FRIEND_SCORE);
        }
    }

    private void getVisitorScore(List<String> visitors, Map<User, Integer> scoreMap) {
        for (String visitorId : visitors) {
            User visitor = getUserById(visitorId);
            scoreMap.put(visitor, scoreMap.getOrDefault(visitor, 0) + VISITOR_SCORE);
        }
    }
}