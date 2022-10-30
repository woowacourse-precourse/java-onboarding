package onboarding;

import onboarding.problem7.collection.Score;
import onboarding.problem7.vo.Friend;

import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Score score = Score.makeNewScore();

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
}
