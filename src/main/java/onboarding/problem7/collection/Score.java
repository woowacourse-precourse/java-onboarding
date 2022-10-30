package onboarding.problem7.collection;

import onboarding.problem7.vo.Friend;

import java.util.*;
import java.util.stream.Collectors;

public class Score {
    private final Map<Friend, Integer> scoreInfo;
    private final List<Friend> alreadyFriends;

    private Score() {
        this.scoreInfo = new HashMap<>();
        this.alreadyFriends = new ArrayList<>();
    }

    public static Score makeNewScore() {
        return new Score();
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
