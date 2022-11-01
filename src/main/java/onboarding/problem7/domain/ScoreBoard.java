package onboarding.problem7.domain;

import java.util.*;

public class ScoreBoard {

    private static final int DEFAULT_SCORE = 0;
    private static final int FRIEND_TOGETHER_SCORE = 10;
    private static final int VISITOR_SCORE = 1;
    private final Map<String, Integer> scoreBoard;

    public ScoreBoard(String user, Map<String, Set<String>> friendList, List<String> visitors) {
        this.scoreBoard = new HashMap<>();
        Set<String> userFriendList = friendList.getOrDefault(user, new HashSet<>());
        checkUserFriend(userFriendList, friendList);
        checkVisitor(visitors);
        removeAlreadyUserFriend(userFriendList);
        scoreBoard.remove(user);
    }

    private void checkUserFriend(Set<String> userFriendList, Map<String, Set<String>> friendList) {
        for (String friendId : friendList.keySet()) {
            scoreBoard.put(friendId, scoreBoard.getOrDefault(friendId, DEFAULT_SCORE) +
                    countFriendTogether(friendList, userFriendList, friendId) * FRIEND_TOGETHER_SCORE);
        }
    }

    private static int countFriendTogether(Map<String, Set<String>> friendList, Set<String> userFriendList, String friendId) {
        return Long.valueOf(friendList.getOrDefault(friendId, new HashSet<>()).stream()
                .filter(userFriendList::contains)
                .count()).intValue();
    }

    private void checkVisitor(List<String> visitors) {
        visitors.forEach(visitor -> scoreBoard.put(visitor, scoreBoard.getOrDefault(visitor, DEFAULT_SCORE) + VISITOR_SCORE));
    }

    private void removeAlreadyUserFriend(Set<String> userFriendList) {
        userFriendList.forEach(scoreBoard::remove);
    }

    public Map<String, Integer> scoreBoard() {
        return scoreBoard;
    }
}
