package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    static final Integer USER_A = 0;
    static final Integer USER_B = 1;
    static final Integer MAX_LENGTH = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, User> userInformations = new HashMap<>();
        userInformations.put(user, new User(user));

        for (List<String> friendPair : friends) {
            String nameA = friendPair.get(USER_A);
            String nameB = friendPair.get(USER_B);

            User userA = userInformations.get(nameA);
            User userB = userInformations.get(nameB);

            if (userA == null) {
                userA = new User(nameA);
                userA.friends.add(nameB);
                userInformations.put(nameA, userA);
            }
            userA.friends.add(nameB);

            if (userB == null) {
                userB = new User(nameB);
                userB.friends.add(nameA);
                userInformations.put(nameB, userB);
            }
            userB.friends.add(nameA);
        }

        for (String visitor : visitors) {

            User visitorInfomation = userInformations.get(visitor);

            if (visitorInfomation == null) {
                visitorInfomation = new User(visitor);
                userInformations.put(visitor, visitorInfomation);
            }

            visitorInfomation.score++;
        }

        List<String> pivotFriends = userInformations.get(user).friends;
        userInformations.remove(user);

        if (pivotFriends.size() > 0) {
            Set<Map.Entry<String, User>> entries = userInformations.entrySet();

            for (Map.Entry<String, User> entry : entries) {
                String name = entry.getKey();
                User information = entry.getValue();

                information.friends.retainAll(pivotFriends);
                userInformations.get(name).score += information.friends.size() * 10;
            }
        }

        List<User> before = new ArrayList<>();

        for (Map.Entry<String, User> entry : userInformations.entrySet()) {
            String name = entry.getKey();
            Integer score = entry.getValue().getScore();

            if (pivotFriends.size() > 0) {
                if (!pivotFriends.contains(name) && score != 0) {
                    before.add(entry.getValue());
                }
            } else {
                if (score != 0) {
                    before.add(entry.getValue());
                }
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

        public Integer getScore() {
            return score;
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
