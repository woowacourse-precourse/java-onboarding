package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    private static void checkId(String id) {
        if (id.length() > 30 || id.length() < 1)
            throw new IllegalArgumentException("user는 1이상 30이하여야합니다.");
    }

    private static void checkFriends(List<List<String>> friends) {
        if (friends.size() > 10000 || friends.size() < 1)
            throw new IllegalArgumentException("friends는 1이상 10000이하여야합니다.");
    }

    private static void checkVisitors(List<String> visitors) {
        if (visitors.size() > 10000)
            throw new IllegalArgumentException("visitors는 0이상 10000이하여야합니다.");
    }

    private static void checkIds(List<List<String>> friends){
        for(List<String> friend : friends){
            friend.forEach(Problem7::checkId);
        }
    }

    private static void checkAll(String user, List<List<String>> friends, List<String> visitors){
        checkId(user);
        checkFriends(friends);
        checkVisitors(visitors);
        checkIds(friends);
        visitors.forEach(Problem7::checkId);
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        checkAll(user, friends, visitors);

        List<String> answer = Collections.emptyList();
        return answer;
    }
}

class Friend{
    String id;
    int score;

    public Friend(String id, int score){
        this.id = checkId(id);
        this.score = score;
    }

    private String checkId(String id) {
        if (id.length() > 30 || id.length() < 1)
            throw new IllegalArgumentException("user는 1이상 30이하여야합니다.");
        return id;
    }
}

class Friends{
    List<Friend> friends;

    public Friends(){
        friends = new ArrayList<>();
    }


}