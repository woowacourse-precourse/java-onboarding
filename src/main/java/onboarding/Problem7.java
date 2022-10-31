package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static final int RELATED_POINT = 10;
    private static final int VISITOR_POINT = 1;

    private static Map<String, User> users = new HashMap<>();
    private static Set<User> recommendedFriends = new HashSet<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        createUserRelation(user, friends);
        checkPoint(user, visitors);
        return getAnswer(getTopFiveUserAsc());
    }

    private static void createUserRelation(String user, List<List<String>> friends) {
        users.put(user, new User(user));
        for (List<String> friend : friends) {
            String userA = friend.get(0);
            String userB = friend.get(1);

            users.put(userA, users.getOrDefault(userA, new User(userA)));
            users.put(userB, users.getOrDefault(userB, new User(userB)));
            if (userB.equals(user)) {
                users.get(user).addFriend(users.get(userA));
                continue;
            }
            users.get(userA).addFriend(users.get(userB));
        }
    }

    private static void checkPoint(String user, List<String> visitors) {
        User findUser = users.get(user);
        checkRelatedFriendPoint(findUser);
        checkVisitorPoint(findUser, visitors);
    }

    private static void checkRelatedFriendPoint(User user) {
        for (User friend : user.getFriends()) {
            for (User relatedFriend : friend.getFriends()) {
                recommendedFriends.add(relatedFriend);
                relatedFriend.plusPoint(RELATED_POINT);
            }
        }
    }

    private static void checkVisitorPoint(User user, List<String> visitors) {
        for (String visitor : visitors) {
            User findUser = users.get(visitor);
            if (findUser == null) {
                findUser = new User(visitor);
                users.put(visitor, findUser);
            }
            if (user.hasNoFriend(findUser)) {
                recommendedFriends.add(findUser);
                findUser.plusPoint(VISITOR_POINT);
            }
        }
    }

    private static List<User> getTopFiveUserAsc() {
        return recommendedFriends.stream()
                .sorted().limit(5)
                .collect(Collectors.toList());
    }

    private static List<String> getAnswer(List<User> result) {
        return result.stream()
                .map(User::getId)
                .collect(Collectors.toList());
    }

    static class User implements Comparable<User>{

        private String id;
        private int point;
        private List<User> friends = new ArrayList<>();

        public User(String id) {
            this.id = id;
            this.point = 0;
        }

        public String getId() {
            return id;
        }

        public List<User> getFriends() {
            return friends;
        }

        public void addFriend(User user) {
            friends.add(user);
        }

        public void plusPoint(int point) {
            this.point += point;
        }

        public boolean hasNoFriend(User findUser) {
            return !friends.contains(findUser);
        }

        @Override
        public int compareTo(User other) {
            if (this.point == other.point) {
                return this.id.compareTo(other.id);
            }
            return other.point - this.point;
        }
    }
}
