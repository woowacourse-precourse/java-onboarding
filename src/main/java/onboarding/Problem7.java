package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
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
            int value = 10;
            if (scores.containsKey(friendA)) {
                value += scores.get(friendA);
            }
            scores.put(friendA, value);
        }


        private void addScoreByVisit(String friend) {
            if (earlyFriends.contains(friend)) return;
            int value = 1;
            if (scores.containsKey(friend)) {
                value += scores.get(friend);
            }
            scores.put(friend, value);
        }
    }
}
