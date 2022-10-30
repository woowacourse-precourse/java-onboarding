package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        User userObject = new User();
        userObject.setName(user);

        userObject.setFriends(friends.stream()
                .filter(s -> s.contains(userObject.getName()))
                .flatMap(List::stream)
                .filter(s -> !s.equals(userObject.getName()))
                .collect(Collectors.toList()));
    }

    private static class User {

        private String name;
        private List<String> friends;
        private Map<String, Integer> friendRecommendScore = new HashMap<>();

        public User() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getFriends() {
            return friends;
        }

        public void setFriends(List<String> friends) {
            this.friends = friends;
        }

        public Map<String, Integer> getFriendRecommendScore() {
            return friendRecommendScore;
        }

        public void setFriendRecommendScore(Map<String, Integer> friendRecommendScore) {
            this.friendRecommendScore = friendRecommendScore;
        }
    }

}
