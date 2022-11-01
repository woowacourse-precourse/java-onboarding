package onboarding;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem7 {
    private static void addMyFriend(List<String> myFriends, List<String> relation, String user) {
        String user1 = relation.get(0);
        String user2 = relation.get(1);
        if (user1.equals(user)) {
            myFriends.add(user2);
        }
        else if(user2.equals(user)) {
            myFriends.add(user1);
        }
    }
    private static List<String> getMyFriends(String user, List<List<String>> friends) {
        List<String> myFriends = new LinkedList<>();
        for (List<String> relation : friends) {
            addMyFriend(myFriends, relation, user);
        }
        return myFriends;
    }
    private static void addRelation(List<List<String>> relations, List<String> relation, String user) {
        String user1 = relation.get(0);
        String user2 = relation.get(1);
        if (!(user1.equals(user) || user2.equals(user))) {
            relations.add(relation);
        }
    }
    private static List<List<String>> getRelations(String user, List<List<String>> friends) {
        List<List<String>> relations = new LinkedList<>();
        for (List<String> relation : friends) {
            addRelation(relations, relation, user);
        }
        return relations;
    }
    private static int searchUser(List<User> users, String userName) {
        int index = 0;
        boolean stop = false;
        while (!stop && index < users.size()) {
            User user = users.get(index);
            String name = user.name;
            stop = name.equals(userName);
            index++;
        }
        if (stop) {
            return index - 1;
        }
        return -1;
    }
    private static void pointUp(List<User> users, String userName, int n) {
        int index = searchUser(users, userName);
        if (index == -1) {
            users.add(new User(userName, n));
            return;
        }
        User user = users.get(index);
        user.point += n;
    }
    private static void calculateFriendPoint(List<String> myFriends, List<String> relation, List<User> users) {
        String user1 = relation.get(0);
        String user2 = relation.get(1);
        if (myFriends.contains(user1) && myFriends.contains(user2)) {
            return;
        }
        if (myFriends.contains(user1)) {
            pointUp(users, user2, 10);
        }
        if (myFriends.contains(user2)) {
            pointUp(users, user1, 10);
        }
    }
    private static void calculateFriendsPoint(List<String> myFriends, List<List<String>> relations, List<User> users) {
        for (List<String> relation : relations) {
            calculateFriendPoint(myFriends, relation, users);
        }
    }
    private static void calculateVisitorPoint(List<String> myFriends, String visitor, List<User> users) {
        if (myFriends.contains(visitor)) {
            return;
        }
        pointUp(users, visitor, 1);
    }
    private static void calculateVisitorsPoint(List<String> myFriends, List<String> visitors, List<User> users) {
        for (String visitor : visitors) {
            calculateVisitorPoint(myFriends, visitor, users);
        }
    }
    private static void sort(List<User> users) {
        users.sort((user1, user2) -> {
           if (user1.point == user2.point) {
               return user1.name.compareTo(user2.name);
           }
           return user2.point - user1.point;
        });
    }
    private static void makeAnswer(List<String> answer, List<User> users) {
        int usersSize = users.size();
        usersSize = Math.min(usersSize, 5);
        for (int i = 0; i < usersSize; i++) {
            User user = users.get(i);
            String name = user.name;
            answer.add(name);
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new LinkedList<>();
        List<String> myFriends = getMyFriends(user, friends);
        List<List<String>> relations = getRelations(user, friends);
        List<User> users = new LinkedList<>();
        calculateFriendsPoint(myFriends, relations, users);
        calculateVisitorsPoint(myFriends, visitors, users);
        sort(users);
        makeAnswer(answer, users);
        return answer;
    }
}

class User {
    String name;
    int point;
    public User(String name, int point) {
        this.name = name;
        this.point = point;
    }
}