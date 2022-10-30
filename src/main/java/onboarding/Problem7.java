package onboarding;

import java.util.*;

public class Problem7 {
    public static final int FIRST_USER_INDEX = 0;
    public static final int SECOND_USER_INDEX = 1;
    public static final int SCORE_INIT = 0;
    public static final int MAX_RECOMMEND_NUM = 5;
    public static final int MINIMUM_USER_RANGE = 1;
    public static final int MAXIMUM_USER_RANGE = 30;
    public static final int MINIMUM_FRIENDS_SIZE = 1;
    public static final int MAXIMUM_FRIENDS_SIZE = 10000;
    public static final int MINIMUM_VISITOR_SIZE = 0;
    public static final int MAXIMUM_VISITOR_SIZE = 10000;
    public static final int FRIENDS_LIST_SIZE = 2;
    public static final int MINIMUM_ID_LENGTH = 1;
    public static final int MAXIMUM_ID_LENGTH = 30;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        validateUserRange(user);
        validateFriends(friends);
        validateVisitors(visitors);

        Map<String, User> users = preProcessing(friends);

        scoringByVisitors(visitors, users);
        scoringByFriends(user, users);

        List<String> recommendFriends = getRecommendFriends(users, user);
        validateRecommendFriends(recommendFriends);
        return recommendFriends;
    }

    private static void validateUserRange(String user) {
        if (user.length() < MINIMUM_USER_RANGE || MAXIMUM_USER_RANGE < user.length()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateFriends(List<List<String>> friends) {
        validateFiendsSize(friends);
        validateFriendsList(friends);
    }

    private static void validateFiendsSize(List<List<String>> friends) {
        if (friends.size() < MINIMUM_FRIENDS_SIZE || MAXIMUM_FRIENDS_SIZE < friends.size()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateFriendsList(List<List<String>> friends) {
        for (List<String> friend : friends) {
            validateFriendListSize(friend);

            validateIdLength(getFirstUserName(friend));
            validateLowerCase(getFirstUserName(friend));

            validateIdLength(getSecondUserName(friend));
            validateLowerCase(getSecondUserName(friend));
        }
    }

    private static void validateFriendListSize(List<String> friend) {
        if (friend.size() != FRIENDS_LIST_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateIdLength(String id) {
        if (id.length() < MINIMUM_ID_LENGTH || MAXIMUM_ID_LENGTH < id.length()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateLowerCase(String id) {
        for (char c : id.toCharArray()) {
            if (!Character.isLowerCase(c)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void validateVisitors(List<String> visitors) {
        validateVisitorsSize(visitors);

        for (String visitor : visitors) {
            validateIdLength(visitor);
            validateLowerCase(visitor);
        }
    }

    private static void validateVisitorsSize(List<String> visitors) {
        if (visitors.size() < MINIMUM_VISITOR_SIZE || MAXIMUM_VISITOR_SIZE < visitors.size()) {
            throw new IllegalArgumentException();
        }
    }

    private static Map<String, User> preProcessing(List<List<String>> friends) {
        Map<String, User> users = new HashMap<>();

        for (List<String> friend : friends) {
            String firstUserName = getFirstUserName(friend);
            String secondUserName = getSecondUserName(friend);

            User firstUser = getOrCreateUser(firstUserName, users);
            firstUser.friendNames.add(secondUserName);

            User secondUser = getOrCreateUser(secondUserName, users);
            secondUser.friendNames.add(firstUserName);
        }
        return users;
    }

    private static void scoringByVisitors(List<String> visitors, Map<String, User> users) {
        for (String visitor : visitors) {
            User user = getOrCreateUser(visitor, users);
            user.incrementVisitorScore();
        }
    }

    public static void scoringByFriends(String user, Map<String, User> users) {
        User accountOwner = users.get(user);
        Set<String> ownersFriends = accountOwner.friendNames;

        for (String ownersFriendName : ownersFriends) {
            User ownersFriend = users.get(ownersFriendName);

            for (String acquaintanceName : ownersFriend.friendNames) {
                User acquaintance = users.get(acquaintanceName);
                acquaintance.incrementAcquaintanceScore();
            }
        }
    }

    private static List<String> getRecommendFriends(Map<String, User> users, String ownerName) {
        Queue<User> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.score == o2.score) {
                return o1.name.compareTo(o2.name);
            }
            return o2.score - o1.score;
        });

        User owner = users.get(ownerName);

        for (String userName : users.keySet()) {
            User user = users.get(userName);

            if (isTargetUser(owner, user)) {
                queue.offer(user);
            }
        }

        return getTop5Friends(queue);
    }

    private static List<String> getTop5Friends(Queue<User> queue) {
        List<String> friends = new ArrayList<>();

        for (int i = 0; !queue.isEmpty() && i < MAX_RECOMMEND_NUM; i++) {
            User friend = queue.poll();
            friends.add(friend.name);
        }

        return friends;
    }

    private static void validateRecommendFriends(List<String> recommendFriends) {
        if (recommendFriends.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static User getOrCreateUser(String userName, Map<String, User> users) {
        if (users.containsKey(userName)) {
            return users.get(userName);
        }
        User user = new User(userName);
        users.put(userName, user);
        return user;
    }

    private static boolean isTargetUser(User owner, User user) {
        if (user.isZeroScore() || owner.isFriend(user.name) || user.isSameName(owner.name)) {
            return false;
        }
        return true;
    }

    private static String getSecondUserName(List<String> userNames) {
        return userNames.get(SECOND_USER_INDEX);
    }

    private static String getFirstUserName(List<String> userNames) {
        return userNames.get(FIRST_USER_INDEX);
    }

    static class User {
        public static final int VISITOR_SCORE = 1;
        public static final int ACQUAINTANCE_SCORE = 10;
        private String name;
        private Set<String> friendNames;
        private Integer score;

        public User(String name) {
            this.name = name;
            this.friendNames = new HashSet<>();
            this.score = SCORE_INIT;
        }

        public void incrementVisitorScore() {
            score += VISITOR_SCORE;
        }

        public void incrementAcquaintanceScore() {
            score += ACQUAINTANCE_SCORE;
        }

        public boolean isZeroScore() {
            return score == 0;
        }

        public boolean isFriend(String userName) {
            return friendNames.contains(userName);
        }

        public boolean isSameName(String userName) {
            return name.equals(userName);
        }
    }
}
