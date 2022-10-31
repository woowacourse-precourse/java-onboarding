package onboarding;

import java.util.*;

public class Problem7 {

    static class User implements Comparable<User> {

        private static final int VISIT_SCORE = 1;
        private static final int ACQUAINTANCE_SCORE = 10;
        private String name;
        private Set<User> friends;
        private int score = 0;
        private int visitCount = 0;
        private int acquaintanceCount = 0;

        public User(String name) {
            this.name = name;
        }

        public void addFriend(User user) {
            if (friends == null) {
                friends = new HashSet<>();
            }
            friends.add(user);
        }

        public void setAcquaintanceCount(User user) {
            for (User friend : friends) {
                acquaintanceCount += getMatchingCount(friend, user);
            }
        }

        public int getMatchingCount(User friend, User user) {
            if (user.isContains(friend)) {
                return 1;
            }
            return 0;
        }

        public boolean isContains(User user) {
            return friends.contains(user);
        }

        public void addVisitCount() {
            visitCount++;
        }

        @Override
        public int compareTo(User user) {
            return 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return score == user.score && visitCount == user.visitCount
                && acquaintanceCount == user.acquaintanceCount && name.equals(user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, score, visitCount, acquaintanceCount);
        }
    }

    private static Map<String, User> friendGraph;

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {
        initFriendGraph(friends);

        User targetUser = friendGraph.get(user);
        friendGraph.remove(user);
        friendGraph.entrySet().forEach(e -> e.getValue().setAcquaintanceCount(targetUser));

        User visitor;
        for (String visitorName : visitors) {
            addVisitCount(visitorName);
        }

        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void initFriendGraph(List<List<String>> friends) {
        friendGraph = new HashMap<>();
        User userA, userB;
        for (List<String> twoFriends : friends) {
            userA = addUser(twoFriends.get(0));
            userB = addUser(twoFriends.get(1));
            addFriend(userA, userB);
            addFriend(userB, userA);
        }
    }

    private static User addUser(String userName) {
        if (!friendGraph.containsKey(userName)) {
            friendGraph.put(userName, new User(userName));
        }
        return friendGraph.get(userName);
    }

    private static void addFriend(User user, User friend) {
        user.addFriend(friend);
    }

    private static void addVisitCount(String visitorName) {
        if (friendGraph.containsKey(visitorName)) {
            User visitor = friendGraph.get(visitorName);
            visitor.addVisitCount();
        }
    }
}
