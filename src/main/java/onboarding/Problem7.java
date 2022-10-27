package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Score score = new Score();

        addTenScore(user, friends, score);
        addOneScore(visitors, score);

        return score.getBestRecommendedFriends();
    }

    private static void addTenScore(String userName, List<List<String>> friends, Score score) {
        findAlreadyFriends(userName, friends, score);
        addAllFriends(userName, friends, score);

        friends.forEach(relation ->
            relation.forEach(
                friendName -> score.addScore(Friend.of(friendName), 10)
            )
        );
    }

    private static void addOneScore(List<String> visitors, Score score) {
        visitors.forEach(
            visitorName -> {
                Friend friend = Friend.of(visitorName);
                score.addFriend(friend);
                score.addScore(friend, 1);
            }
        );
    }

    private static void findAlreadyFriends(String user, List<List<String>> friends, Score score) {
        friends.stream()
            .filter(relation -> relation.contains(user))
            .forEach(relation -> relation
                .forEach(friendName -> {
                    if (!friendName.equals(user)) {
                        score.addAlreadyFriend(Friend.of(friendName));
                    }
                }));
    }

    private static void addAllFriends(String user, List<List<String>> friends, Score score) {
        friends.stream()
            .filter(relation ->
                score.getAlreadyFriends().contains(Friend.of(relation.get(0)))
                    || score.getAlreadyFriends().contains(Friend.of(relation.get(1)))
            )
            .forEach(relation ->
                relation.forEach(friendName -> {
                    if (!friendName.equals(user)) {
                        score.addFriend(Friend.of(friendName));
                    }
                })
            );
    }

    public static class Friend {
        private final String name;

        private Friend(String name) {
            this.name = name;
        }

        public static Friend of(String name) {
            return new Friend(name);
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Friend))
                return false;
            Friend friend = (Friend)o;
            return name.equals(friend.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "Friend{" +
                "name='" + name + '\'' +
                '}';
        }
    }

    public static class Score {
        private final Map<Friend, Integer> scoreInfo;
        private final List<Friend> alreadyFriends;

        private Score() {
            this.scoreInfo = new HashMap<>();
            this.alreadyFriends = new ArrayList<>();
        }

        public void addAlreadyFriend(Friend friend) {
            if (!isAlreadyFriend(friend)) {
                alreadyFriends.add(friend);
            }
        }

        public void addFriend(Friend friend) {
            if (!hasScoreInfo(friend)) {
                scoreInfo.put(friend, 0);
            }
        }

        public void addScore(Friend friend, int score) {
            if (hasScoreInfo(friend) && !isAlreadyFriend(friend)) {
                scoreInfo.put(friend, scoreInfo.get(friend) + score);
            }
        }

        public List<String> getBestRecommendedFriends() {
            ArrayList<String> list = new ArrayList<>();
            scoreInfo.entrySet().stream()
                .filter(entry -> !isAlreadyFriend(entry.getKey()) && isScoreZero(entry))
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toList())
                .forEach(entry -> list.add(entry.getKey().getName()));
            return list;
        }

        public List<Friend> getAlreadyFriends() {
            return new ArrayList<>(alreadyFriends);
        }

        private boolean hasScoreInfo(Friend friend) {
            return scoreInfo.get(friend) != null;
        }

        private boolean isAlreadyFriend(Friend friend) {
            return alreadyFriends.contains(friend);
        }

        private boolean isScoreZero(Map.Entry<Friend, Integer> entry) {
            return entry.getValue() != 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Score))
                return false;
            Score score = (Score)o;
            return scoreInfo.equals(score.scoreInfo) && alreadyFriends.equals(score.alreadyFriends);
        }

        @Override
        public int hashCode() {
            return Objects.hash(scoreInfo, alreadyFriends);
        }

        @Override
        public String toString() {
            return "Score{" +
                "scoreInfo=" + scoreInfo +
                '}';
        }
    }
}
