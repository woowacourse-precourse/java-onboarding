package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendsScoreList {
    private Map<User, Score> friendsScoreList = new HashMap<>();
    private User user;

    public FriendsScoreList(String name) {
        this.user = new User(name);
    }

    public void add(String name) {
        User user = new User(name);
        Score score = new Score();

        if (checkUserExist(user)) {
            throw new IllegalArgumentException("동일한 친구 정보는 주어질 수 없습니다.");
        }

        friendsScoreList.put(user, score);
    }

    private boolean checkUserExist(User user) {
        return friendsScoreList.containsKey(user);
    }



}
