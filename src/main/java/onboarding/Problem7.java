package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static final Integer ANSWER_LIMIT_SIZE = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        return new User(user, getFriendsByUser(user, friends), visitors).getRecommendFriendNames(friends,
                ANSWER_LIMIT_SIZE, (o1, o2) -> {
                    if (o1.getValue().equals(o2.getValue())) {
                        return o1.getKey().compareTo(o2.getKey());
                    }
                    return o2.getValue() - o1.getValue();
                });
    }

    private static HashSet<String> getFriendsByUser(String userName, List<List<String>> friendRelations) {
        List<String> result = new ArrayList<>();

        for (List<String> users: friendRelations) {
            String userA = users.get(0);
            String userB = users.get(1);

            if (userA.equals(userName)) {
                result.add(userB);
            } else if (userB.equals(userName)) {
                result.add(userA);
            }
        }

        return new HashSet<>(result);
    }


    private static class User {
        private final String userName;
        private final HashSet<String> friends;
        private final List<String> visitors;

        public User(String userName, HashSet<String> friends, List<String> visitors) {
            this.userName = userName;
            this.friends = friends;
            this.visitors = visitors;
        }

        public List<String> getRecommendFriendNames(List<List<String>> friendRelations, Integer size,
                                                     Comparator<Map.Entry<String, Integer>> comparator) {
            RecommendFriendScore score = new RecommendFriendScore(this);

            for (List<String> list: this.withoutUserFriendRelations(friendRelations)) {
                String friendA = list.get(0);
                String friendB = list.get(1);

                score.addMutualFriend(friendA, friendB);
                score.addMutualFriend(friendB, friendA);
            }

            for (String visitor: this.getVisitors()) {
                score.addVisitor(visitor);
            }


            List<Map.Entry<String, Integer>> list = score.getRecommendList();
            list.sort(comparator);

            return list.stream().map(Map.Entry::getKey).limit(size).collect(Collectors.toList());
        }

        private List<List<String>> withoutUserFriendRelations(List<List<String>> friendRelations) {
           return friendRelations.stream()
                    .filter((users) -> !users.contains(this.getUserName()))
                    .collect(Collectors.toList());
        }

        public String getUserName() {
            return userName;
        }

        public HashSet<String> getFriends() {
            return friends;
        }

        public List<String> getVisitors() {
            return visitors;
        }
    }

    public static class RecommendFriendScore {
        private final Integer VISITOR_SCORE = 1;
        private final Integer MUTUAL_FRIEND_SCORE = 10;

        private final User user;
        private final Map<String, Integer> scoreMap = new HashMap<>();

        public RecommendFriendScore(User user) {
           this.user = user;
        }

        public void addMutualFriend(String receiver, String friend) {
            if (this.user.getFriends().contains(friend)) {
                this.updateScore(receiver, MUTUAL_FRIEND_SCORE);
            }
        }

        public void addVisitor(String visitor) {
            if (this.user.getFriends().contains(visitor) || visitor.equals(user.getUserName())) {
                return;
            }

            this.updateScore(visitor, VISITOR_SCORE);
        }

        public List<Map.Entry<String, Integer>> getRecommendList() {
            return new ArrayList<>(scoreMap.entrySet());
        }

        private void updateScore(String receiver, Integer score) {
            if (!this.scoreMap.containsKey(receiver)) {
                this.scoreMap.put(receiver, score);
            } else {
                this.scoreMap.put(receiver, this.scoreMap.get(receiver) + score);
            }
        }
    }
}
