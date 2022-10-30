package onboarding;

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

        List<String> collect = friends.stream()
                .filter(s -> !s.contains(userObject.getName()) && !Collections.disjoint(s,userObject.getFriends()))
                .flatMap(List::stream)
                .filter(s -> !userObject.getFriends().contains(s))
                .collect(Collectors.toList());

        for (String fr : collect) {
            if (userObject.isContainInRecommendList(fr)) {
                userObject.getFriendRecommendScore().put(fr, userObject.getFriendRecommendScore().get(fr) + 10);
            }
            if (!userObject.isContainInRecommendList(fr)) {
                userObject.getFriendRecommendScore().put(fr, 10);
            }
        }

        List<String> visitorsWithoutFriend = visitors.stream()
                .filter(s -> !userObject.getFriends().contains(s))
                .collect(Collectors.toList());

        for (String visitor : visitorsWithoutFriend) {
            if (userObject.isContainInRecommendList(visitor)) {
                userObject.getFriendRecommendScore().put(visitor, userObject.getFriendRecommendScore().get(visitor) + 1);
            }
            if (!userObject.isContainInRecommendList(visitor)) {
                userObject.getFriendRecommendScore().put(visitor, 1);
            }
        }

        return userObject.getFriendRecommendScore().entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.<String, Integer>comparingByValue())
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
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

        public boolean isContainInRecommendList(String username) {
        return this.getFriendRecommendScore().containsKey(username);
    }
    }

}
