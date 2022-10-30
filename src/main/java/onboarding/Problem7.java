package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    
    private static final int RECOMMENDED_FRIENDS_WEIGHT_RELATED_MY_FRIEND = 10;
    private static final int RECOMMENDED_FRIENDS_WEIGHT_VISIT_MY_PAGE = 1;
    private static final int MAX_NUMBER_TO_RECOMMENDED_FRIENDS = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        User userObject = new User(user);
        userObject.addFriends(friends);
        userObject.addFriendRecommendScore(friends, visitors);
        return userObject.findToRecommendedFriends(MAX_NUMBER_TO_RECOMMENDED_FRIENDS);
    }

    private static class User {

        private String name;
        private List<String> friends;
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
            addRelatedFriends(friends);
            addVisitUsers(visitors);
        }

        private void addRelatedFriends(List<List<String>> friends) {
            List<String> usersRelatedFriends = friends.stream()
                    .filter(friendPair ->
                            !friendPair.contains(this.name) &&
                            !Collections.disjoint(friendPair, this.friends))
                    .flatMap(List::stream)
                    .filter(username -> !this.friends.contains(username))
                    .collect(Collectors.toList());

            calculateScore(usersRelatedFriends, RECOMMENDED_FRIENDS_WEIGHT_RELATED_MY_FRIEND);
        }

        private void addVisitUsers(List<String> visitors) {
            List<String> visitorsWithoutFriend = visitors.stream()
                    .filter(friendPair -> !this.getFriends().contains(friendPair))
                    .collect(Collectors.toList());

            calculateScore(visitorsWithoutFriend, RECOMMENDED_FRIENDS_WEIGHT_VISIT_MY_PAGE);
        }


        private void calculateScore(List<String> recommendedFriends, int weight) {
            for (String name : recommendedFriends) {
                if (this.isContainInRecommendList(name)) {
                    this.getFriendRecommendScore().put(name, this.getFriendRecommendScore().get(name) + weight);
                }
                if (!this.isContainInRecommendList(name)) {
                    this.getFriendRecommendScore().put(name, weight);
                }
            }
        }

        public boolean isContainInRecommendList(String username) {
            return this.getFriendRecommendScore().containsKey(username);
        }

        public List<String> findToRecommendedFriends(int maxElementNum) {
            return this.getFriendRecommendScore().entrySet().stream()
                    .sorted(Collections.reverseOrder(Map.Entry.<String, Integer>comparingByValue())
                            .thenComparing(Map.Entry.comparingByKey()))
                    .limit(maxElementNum)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }
    }
}
