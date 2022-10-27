package onboarding;

import java.util.*;

public class Problem7 {
    static class User{
        final String name;
        List<String> friends;
        List<String> visitor;
        int score;

        public User(String name) {
            this.name = name;
            this.friends = new ArrayList<>();
            this.visitor = new ArrayList<>();
            this.score = 0;
        }

        public void addFriend(String name){
            friends.add(name);
        }

        public void setVisitor(List<String> visitor) {
            this.visitor = visitor;
        }
    }

    public static Map<String, User> repository = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        initFriend(friends);

        User userInstance = repository.get(user);
        userInstance.setVisitor(visitors);

        return answer;
    }

    private static void initFriend(List<List<String>> friends) {
        for (List<String> friend : friends){
            String friendA = friend.get(0);
            String friendB = friend.get(1);

            setFriendToMap(friendA, friendB);
        }
    }

    private static void setFriendToMap(String friendA, String friendB) {
        User tmpUser;

        tmpUser = repository.getOrDefault(friendA, new User(friendA));
        tmpUser.addFriend(friendB);
        repository.put(friendA, tmpUser);

        tmpUser = repository.getOrDefault(friendB, new User(friendB));
        tmpUser.addFriend(friendA);
        repository.put(friendB, tmpUser);
    }
}
