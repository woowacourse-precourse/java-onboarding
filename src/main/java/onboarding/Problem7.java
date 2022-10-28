package onboarding;

import java.util.*;

class User {
    private String id;
    private int score;
    private List<User> friends;

    public User(String id) {
        this.id = id;
        this.score = 0;
        this.friends = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public List<User> getFriends() {
        return friends;
    }
}

public class Problem7 {

    private static Map<String, User> userList = new HashMap<>();
    private static List<String> answer = new ArrayList<>();

    public static List<String> solution(String mainUserId, List<List<String>> friends, List<String> visitors) {
        return answer;
    }

}
