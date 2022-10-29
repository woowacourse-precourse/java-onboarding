package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        HashMap<String, User> userMap = new HashMap<>();


        return answer;
    }

    public HashMap<String, User> initialize(String user, List<List<String>> friends) {
        HashMap<String, User> userMap = new HashMap<>();
        String username1;
        String username2;
        User user1;
        User user2;

        userMap.put(user, new User(user));
        for(List<String> relation : friends) {
            username1 = relation.get(0);
            username2 = relation.get(1);

            user1 = userMap.get(username1);
            if(user1.equals(null)) {
                user1 = new User(username1);
            }

            user2 = userMap.get(username2);
            if(user2.equals(null)) {
                user2 = new User(username2);
            }

            user1.addFriend(user2);
            user2.addFriend(user1);

            userMap.put(username1, user1);
            userMap.put(username2, user2);
        }

        return userMap;
    }

    private static class User {
        private String username;
        private List<User> friends;

        public String getUsername() {
            return this.username;
        }

        private List<User> getFriends() {
            return this.friends;
        }

        public User(String username) {
            isValidUsername(username);
            this.username = username;
            this.friends = new ArrayList<>();
        }

        private void isValidUsername(String username) {
            int length = username.length();
            if(length < 1 || 30 < length) {
                throw new IllegalArgumentException("닉네임의 길이가 적절치 않습니다.");
            }
        }

        public void addFriend(User user) {
            this.friends.add(user);
        }
    }
}
