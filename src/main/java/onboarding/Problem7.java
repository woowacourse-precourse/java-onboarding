package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    private static final int RECOMMENDED_FRIENDS_WEIGHT_RELATED_MY_FRIEND = 10;
    private static final int RECOMMENDED_FRIENDS_WEIGHT_VISITED_MY_PAGE = 1;
    private static final int MAX_NUMBER_TO_RECOMMENDED_FRIENDS = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        User userObject = new User(user);
        userObject.addFriends(friends);
        userObject.addFriendRecommendScore(friends, visitors);
        return userObject.findToRecommendedFriends();
    }

    private static class User {

        private String name;
        private List<String> friends = new ArrayList<>();
        private Map<String, Integer> friendRecommendScore = new HashMap<>();

        public User(String name) {
            this.name = name;
        }

        public List<String> getFriends() {
            return friends;
        }

        public Map<String, Integer> getFriendRecommendScore() {
            return friendRecommendScore;
        }

        public void addFriends(List<List<String>> friends) {
            this.friends = friends.stream()
                    .filter(friendPair -> friendPair.contains(this.name))
                    .flatMap(List::stream)
                    .filter(username -> !username.equals(this.name))
                    .collect(Collectors.toList());
        }

        public void addFriendRecommendScore(List<List<String>> friends, List<String> visitors) {
            calculateRecommendScore(addUsersRelatedMyFriends(friends), RECOMMENDED_FRIENDS_WEIGHT_RELATED_MY_FRIEND);
            calculateRecommendScore(addUsersVisitedMyPage(visitors), RECOMMENDED_FRIENDS_WEIGHT_VISITED_MY_PAGE);
        }

        private void calculateRecommendScore(List<String> recommendedFriends, int weight) {
            for (String name : recommendedFriends) {
                this.getFriendRecommendScore().computeIfPresent(name, (k,v) -> v + weight);
                this.getFriendRecommendScore().putIfAbsent(name, weight);
            }
        }

        private List<String> addUsersRelatedMyFriends(List<List<String>> friends) {
            return friends.stream()
                    .filter(friendPair ->
                            !friendPair.contains(this.name) &&
                            !Collections.disjoint(friendPair, this.friends))
                    .flatMap(List::stream)
                    .filter(username -> !this.friends.contains(username))
                    .collect(Collectors.toList());
        }

        private List<String> addUsersVisitedMyPage(List<String> visitors) {
            return visitors.stream()
                    .filter(friendPair -> !this.getFriends().contains(friendPair))
                    .collect(Collectors.toList());
        }
        
        public List<String> findToRecommendedFriends() {
            return this.getFriendRecommendScore().entrySet().stream()
                    .sorted(Collections.reverseOrder(Map.Entry.<String, Integer>comparingByValue())
                            .thenComparing(Map.Entry.comparingByKey()))
                    .limit(MAX_NUMBER_TO_RECOMMENDED_FRIENDS)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }
    }

}
