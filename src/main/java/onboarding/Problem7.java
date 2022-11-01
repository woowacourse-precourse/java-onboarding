package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem7 {

    public static List<String> solution(
        String user,
        List<List<String>> friends,
        List<String> visitors
    ) {
        Map<String, String> friendsMap = new HashMap<>();
        Map<String, User> userMap = new HashMap<>();
        List<String> targetUserFriendList = new ArrayList<>();

        for (List<String> stringList : friends) {
            String s = stringList.get(0);
            String s1 = stringList.get(1);

            if (!s.equals(user)) {
                userMap.put(s, new User(s));
            }

            if (!s1.equals(user)) {
                userMap.put(s1, new User(s1));
            }

            friendsMap.put(s, s1);
            friendsMap.put(s1, s);

            if (s.equals(user)) {
                targetUserFriendList.add(s1);
            }

            if (s1.equals(user)) {
                targetUserFriendList.add(s);
            }
        }

        for (String visitorName : visitors) {
            userMap.put(visitorName, new User(visitorName));
        }

        for (String friendsName : targetUserFriendList) {
            for (List<String> stringList : friends) {
                String s = stringList.get(0);
                String s1 = stringList.get(1);

                if (s.equals(friendsName) && !s1.equals(user)) {
                    User user1 = userMap.get(s1);
                    user1.increaseFriendScore();
                    userMap.put(s1, user1);
                }

                if (s1.equals(friendsName) && !s1.equals(user)) {
                    User user1 = userMap.get(s);
                    user1.increaseFriendScore();
                    userMap.put(s, user1);
                }
            }
        }

        for (String visitorName : visitors) {
            User user1 = userMap.get(visitorName);
            user1.increaseVisitorScore();
            userMap.put(visitorName, user1);
        }

        for (String friendName : targetUserFriendList) {
            userMap.remove(friendName);
        }

        List<User> userList = new ArrayList<>();

        for (String key : userMap.keySet()) {
            userList.add(userMap.get(key));
        }

        return userList.stream()
            .filter(u -> u.score > 0)
            .sorted()
            .limit(5)
            .map(u -> u.name)
            .collect(Collectors.toList());
    }
}


class User implements Comparable<User> {

    final String name;
    int score;

    public User(String name) {
        this.name = name;
    }

    public void increaseFriendScore() {
        this.score += 10;
    }

    public void increaseVisitorScore() {
        this.score += 1;
    }

    @Override
    public int compareTo(User o) {

        if (this.score == o.score) {
            return this.name.compareTo(o.name);
        }

        return o.score - this.score;
    }
}
