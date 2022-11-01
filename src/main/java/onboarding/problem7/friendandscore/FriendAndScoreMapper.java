package onboarding.problem7.friendandscore;

import onboarding.problem7.wrapper.User;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FriendAndScoreMapper {
    private Map<User, Integer> newFriendAndScore;
    private final int INITIAL_POINT = 0;

    public FriendAndScoreMapper(List<User> newFriend) {
        this.newFriendAndScore = setNewFriendAndScore(newFriend);
    }

    private Map<User, Integer> setNewFriendAndScore(List<User> newFriend) {
        return newFriend.stream()
                .collect(Collectors.toMap(
                        key -> key,
                        value -> INITIAL_POINT)
                );
    }

    public void calculateScoreOfNewFriendWith(List<User> friendList, int point) {
        for (User newFriend : friendList) {
            int score = Collections.frequency(friendList, newFriend) * point;
            int value = newFriendAndScore.get(newFriend);
            newFriendAndScore.put(newFriend, value + score);
        }
    }

    public Map<User, Integer> getFriendAndScore() {
        return newFriendAndScore;
    }
}
