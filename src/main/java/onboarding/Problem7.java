package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    static final Integer USER_A = 0;
    static final Integer USER_B = 1;
    static final Integer MAX_LENGTH = 5;
    static final Integer SCORE_VISIT = 1;
    static final Integer SCORE_FRIEND = 10;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, User> userInformation = new HashMap<>();
        userInformation.put(user, new User(user));

        for (List<String> friendPair : friends) {
            String nameA = friendPair.get(USER_A);
            String nameB = friendPair.get(USER_B);

            User userA = userInformation.get(nameA);
            User userB = userInformation.get(nameB);

            if (userA == null) {
                userA = new User(nameA);
                userA.friends.add(nameB);
                userInformation.put(nameA, userA);
            }
            userA.friends.add(nameB);

            if (userB == null) {
                userB = new User(nameB);
                userB.friends.add(nameA);
                userInformation.put(nameB, userB);
            }
            userB.friends.add(nameA);
        }

        for (String visitor : visitors) {

            User visitorInformation = userInformation.get(visitor);

            if (visitorInformation == null) {
                visitorInformation = new User(visitor);
                userInformation.put(visitor, visitorInformation);
            }

            visitorInformation.score += SCORE_VISIT;
        }

        List<String> pivotFriends = userInformation.get(user).friends;
        userInformation.remove(user);

        Set<Map.Entry<String, User>> entries = userInformation.entrySet();

        for (Map.Entry<String, User> entry : entries) {
            String name = entry.getKey();
            User information = entry.getValue();

            information.friends.retainAll(pivotFriends);
            userInformation.get(name).score += information.friends.size() * SCORE_FRIEND;
        }

        List<User> before = new ArrayList<>();

        for (Map.Entry<String, User> entry : userInformation.entrySet()) {
            String name = entry.getKey();
            Integer score = entry.getValue().score;

            if (!pivotFriends.contains(name) && score != 0) {
                before.add(entry.getValue());
            }
        }


        before.sort(new ResultComparator());

        if (before.size() > MAX_LENGTH) {
            return before.subList(0, MAX_LENGTH - 1).stream().map(result -> result.name).collect(Collectors.toList());
        } else {
            return before.stream().map(result -> result.name).collect(Collectors.toList());
        }
    }

    static class User {
        private String name;
        private List<String> friends;
        private Integer score;


        public User(String name) {
            this.name = name;
            this.friends = new ArrayList<>();
            this.score = 0;
        }
    }

    static class ResultComparator implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            if (o1.score > o2.score) {
                return -1;
            } else if (o1.score < o2.score) {
                return 1;
            } else if (o1.score == o2.score) {
                return (o1.name.compareTo(o2.name));
            }
            return 0;
        }
    }
}
