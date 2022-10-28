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

    public void addFriend(User user) {
        this.friends.add(user);
    }
}

public class Problem7 {

    private static Map<String, User> userList = new HashMap<>();
    private static List<String> answer = new ArrayList<>();

    public static List<String> solution(String mainUserId, List<List<String>> friends, List<String> visitors) {
        return answer;
    }

    public static void initUserList(List<List<String>> friends, List<String> visitors) {
        for (List<String> data : friends) {
            for (String id : data) {
                if(!userList.containsKey(id)) {
                    userList.put(id, new User(id));
                }
            }
        }

        for (String id : visitors) {
            if (!userList.containsKey(id)) {
                userList.put(id, new User(id));
            }
        }
    }

    public static void initFriends(List<List<String>> friends) {
        for (List<String> data : friends) {
            String idA = data.get(0);
            String idB = data.get(1);
            User userA = userList.get(idA);
            User userB = userList.get(idB);

            userA.addFriend(userB);
            userB.addFriend(userA);
        }
    }
}
