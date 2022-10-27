package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static final int RELATED_POINT = 10;
    private static final int VISITOR_POINT = 1;

    static Map<String, User> users = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Set<User> recommendedFriends = new HashSet<>();

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

        for (User friend : users.get(user).friends) {
            for (User relatedFriend : friend.friends) {
                recommendedFriends.add(relatedFriend);
                relatedFriend.plusPoint(RELATED_POINT);
            }
        }

        for (String visitor : visitors) {
            User findUser = users.get(visitor);
            if (findUser == null) {
                findUser = new User(visitor);
                users.put(visitor, findUser);
            }
            if (users.get(user).hasNoFriend(findUser)) {
                recommendedFriends.add(findUser);
                findUser.plusPoint(VISITOR_POINT);
            }
        }

        List<User> result = recommendedFriends.stream().sorted().collect(Collectors.toList());

        for (User recommend : result) {
            answer.add(recommend.id);
        }
        return answer;
    }

    static class User implements Comparable<User>{
        String id;
        int point;
        List<User> friends = new ArrayList<>();

        public User(String id) {
            this.id = id;
            this.point = 0;
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
