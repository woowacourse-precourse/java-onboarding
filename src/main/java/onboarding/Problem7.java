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
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
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