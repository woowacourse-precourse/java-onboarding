package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        HashMap<String, User> userMap = initialize(user, friends);
        HashMap<String, Integer> recommendedMap = new HashMap<>();

        User standardUser = userMap.get(user);

        for(User friend : standardUser.getFriends()) {
            friend.getFriends().stream()
                    .filter(f -> (! standardUser.getFriends().contains(f)) && (! f.equals(standardUser)))
                    .forEach(
                            f -> {
                                String username = f.getUsername();
                                int point = Optional.ofNullable(recommendedMap.get(username)).orElse(0);
                                recommendedMap.put(username, point + 10);
                            }
                    );
        }

        visitors.stream()
                .filter(visitor -> ! standardUser.getFriendsName().contains(visitor))
                .forEach(visitor -> {
                    int point = Optional.ofNullable(recommendedMap.get(visitor)).orElse(0);
                    recommendedMap.put(visitor, point + 1);
                });

        List<Map.Entry<String, Integer>> entries = recommendedMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue((c1, c2) -> c2 - c1))
                .collect(Collectors.toList());

        entries.forEach(entry -> answer.add(entry.getKey()));

        return answer;
    }

    private static HashMap<String, User> initialize(String user, List<List<String>> friends) {
        HashMap<String, User> userMap = new HashMap<>();
        String username1;
        String username2;
        User user1;
        User user2;

        userMap.put(user, new User(user));
        for(List<String> relation : friends) {
            username1 = relation.get(0);
            username2 = relation.get(1);

            user1 = Optional.ofNullable(userMap.get(username1)).orElse(new User(username1));
            user2 = Optional.ofNullable(userMap.get(username2)).orElse(new User(username2));

            user1.addFriend(user2);
            user2.addFriend(user1);

            userMap.put(username1, user1);
            userMap.put(username2, user2);
        }

        return userMap;
    }

    private static class User {
        private final String username;
        private final List<User> friends;

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

        public List<String> getFriendsName() {
            List<String> friendsName = new ArrayList<>();

            friends.forEach(friend -> friendsName.add(friend.getUsername()));

            return friendsName;
        }
    }
}
