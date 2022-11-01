package onboarding;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Problem7 {
    private static final int USER = 0;
    private static final int FRIEND = 1;
    private static final int FRIEND_SCORE = 10;
    private static final int VISIT_SCORE = 1;
    private static final int MIN_SCORE = 1;
    private static final int MAX_COUNT = 5;

    public static class User {
        private String id;
        private int score;
        private List<String> friends;

        public User(String id) {
            this.id = id;
            this.score = 0;
            this.friends = new ArrayList<>();
        }

        public String getId() {
            return id;
        }

        public void incrementScore(int score) {
            this.score += score;
        }

        public int getScore() {
            return score;
        }

        public void addFriend(String friend) {
            this.friends.add(friend);
        }

        public List<String> getFriends() {
            return friends;
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, User> users = setFriends(friends, user);
        setTogetherFriendScore(users, user);
        setVisitScore(users, visitors);

        return getRecommendedFriends(users, user);
    }

    private static Map<String, User> setFriends(List<List<String>> friends, String user) {
        Map<String, User> users = new HashMap<>();
        users.put(user, new User(user));

        for (List<String> friend : friends) {
            String userId = friend.get(USER);
            String friendId = friend.get(FRIEND);

            addFriendOfUser(users, userId, friendId);
            addFriendOfUser(users, friendId, userId);
        }

        return users;
    }

    private static void addFriendOfUser(Map<String, User> users, String userId, String friendId) {
        User user = users.getOrDefault(userId, new User(userId));
        user.addFriend(friendId);
        users.put(userId, user);
    }

    private static void setTogetherFriendScore(Map<String, User> users, String id) {
        List<String> friendIds = findFriendIdsById(users, id);

        for (String friendId : friendIds) {
            setFriendScore(users, friendId);
        }
    }

    private static void setFriendScore(Map<String, User> users, String id) {
        List<String> friendIds = findFriendIdsById(users, id);

        for (String friendId : friendIds) {
            User user = users.get(friendId);
            user.incrementScore(FRIEND_SCORE);
        }
    }

    private static List<String> findFriendIdsById(Map<String, User> users, String id) {
        User user = users.get(id);
        return user.getFriends();
    }

    private static void setVisitScore(Map<String, User> users, List<String> visitors) {
        for (String visitorId : visitors) {
            User user = users.getOrDefault(visitorId, new User(visitorId));
            user.incrementScore(VISIT_SCORE);
            users.put(visitorId, user);
        }
    }

    private static List<String> getRecommendedFriends(Map<String, User> users, String user) {
        List<User> recommendCandidates = getRecommendCandidates(users, user);

        List<String> recommendFriends = recommendCandidates.stream()
                .sorted(sortRecommendFriend())
                .map(u -> u.getId())
                .limit(MAX_COUNT)
                .collect(Collectors.toList());

        return recommendFriends;
    }

    private static List<User> getRecommendCandidates(Map<String, User> users, String user) {
        List<String> friendIds = findFriendIdsById(users, user);

        List<User> recommendCandidates = users.values().stream()
                .filter(canRecommend(user, new HashSet<>(friendIds)))
                .collect(Collectors.toList());

        return recommendCandidates;
    }

    private static Predicate<User> canRecommend(String user, Set<String> friendIds) {
        return u -> !user.equals(u.getId()) && !friendIds.contains(u.getId()) && u.getScore() >= MIN_SCORE;
    }

    private static Comparator<User> sortRecommendFriend() {
        return Comparator.comparing(User::getScore).reversed().thenComparing(User::getId);
    }
}
