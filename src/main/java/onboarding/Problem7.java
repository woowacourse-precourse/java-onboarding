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