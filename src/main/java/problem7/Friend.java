package problem7;

import java.util.ArrayList;
import java.util.List;

public class Friend {

    private final List<String> friends;

    public Friend() {
        friends = new ArrayList<>();
    }

    public void add(String userId) {
        friends.add(userId);
    }

    public boolean hasFriend(String userId) {
        return friends.contains(userId);
    }

    public void deleteFriendToList(List<String> userIds) {
        friends.forEach(userIds::remove);
    }

    public boolean hasNotFriend(String userId) {
        return !hasFriend(userId);
    }

    public int commonFriendCount(Friend otherFriend) {
        return friends.stream().mapToInt(friendId -> checkFriendId(friendId, otherFriend)).sum();
    }

    private int checkFriendId(String friendId, Friend otherFriend) {
        return (int) otherFriend.friends.stream().filter(friendId::equals).count();
    }
}
