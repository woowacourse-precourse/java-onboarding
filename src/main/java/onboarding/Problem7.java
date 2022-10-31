package onboarding;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Sns sns = new Sns(user, friends, visitors);
        return sns.getRecommend();
    }

    static class Sns {
        private final String owner;
        private final Map<String, Integer> scores;
        private final List<List<String>> allFriends;
        private final List<String> visitors;
        private final Set<String> earlyFriends;

        public Sns(String owner, List<List<String>> friends, List<String> visitors) {
            this.owner = owner;
            this.allFriends = friends;
            this.visitors = visitors;
            this.scores = new HashMap<>();
            this.earlyFriends = new HashSet<>();
            createFriendsList();
            initScores();
        }

        private void createFriendsList() {
            allFriends.stream()
                    .filter(friend -> friend.contains(owner))
                    .forEach(this::insertFriends);
            removeOwner();
        }

        private void insertFriends(List<String> pair) {
            String friendA = pair.get(0);
            String friendB = pair.get(1);
            earlyFriends.add(friendA);
            earlyFriends.add(friendB);
        }

        private void removeOwner() {
            earlyFriends.remove(owner);
        }

        private void initScores() {
            allFriends.stream()
                    .filter(friend -> !friend.contains(owner))
                    .forEach(friend -> {
                        addScoreByFriend(friend.get(0), friend.get(1));
                        addScoreByFriend(friend.get(1), friend.get(0));
                    });
            visitors.forEach(this::addScoreByVisit);
        }

        private void addScoreByFriend(String friendA, String friendB) {
            if (!earlyFriends.contains(friendB)) return;
            scores.put(friendA, scores.computeIfAbsent(friendA, v -> 0) + 10);
        }


        private void addScoreByVisit(String friend) {
            if (earlyFriends.contains(friend)) return;
            scores.put(friend, scores.computeIfAbsent(friend, v -> 0) + 1);

        }

        private List<String> getRecommend() {
            return scores.entrySet().stream()
                    .filter(entry -> !earlyFriends.contains(entry.getKey()))
                    .sorted(this::compare)
                    .limit(5)
                    .map(Map.Entry::getKey)
                    .collect(toList());

        }

        private int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
            if (entry1.getValue() == entry2.getValue()) {
                return entry1.getKey().compareTo(entry2.getKey());
            }
            return entry2.getValue().compareTo(entry1.getValue());
        }
    }
}
