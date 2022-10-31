package onboarding;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        int size = 5;

        List<String> allUsers = getAllUsers(friends, visitors);
        List<String> myFriends = getMyFriends(user, friends);

        User me = new User(user, myFriends);

        return answer;
    }

    private static List<String> getMyFriends(String user, List<List<String>> friends) {

        List<String> myFriends = new LinkedList<>();

        int friendSize = friends.size();

        for (int i = 0; i < friendSize; i++) {
            List<String> relation = friends.get(i);

            String friendA = relation.get(0);
            String friendB = relation.get(1);

            if (friendA.equals(user)) {
                myFriends.add(friendB);
            }
            if (friendB.equals(user)) {
                myFriends.add(friendA);
            }

        }
        return myFriends;
    }

    private static List<String> getAllUsers(List<List<String>> friends, List<String> visitors) {

        List<String> allUsers = new LinkedList<>();

        int friendSize = friends.size();
        int visitorSize = visitors.size();

        for (int i = 0; i < friendSize; i++) {
            List<String> relation = friends.get(i);

            String friendA = relation.get(0);
            String friendB = relation.get(1);

            if (!allUsers.contains(friendB)) {
                allUsers.add(friendB);
            }
            if (!allUsers.contains(friendA)) {
                allUsers.add(friendA);
            }

        }

        for (int i = 0; i < visitorSize; i++) {
            String visitor = visitors.get(i);

            if (!allUsers.contains(visitor)) {
                allUsers.add(visitor);
            }
        }
        return allUsers;
    }

    public static class User {
        String name;
        List<String> friendsList;

        public User(String name, List<String> friendsList) {
            this.name = name;
            this.friendsList = friendsList;
        }

        public String getName() {
            return name;
        }

        public List<String> getFriendsList() {
            return friendsList;
        }
    }
}
