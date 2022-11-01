package problem7;

import java.util.List;
import java.util.Objects;

public class User {

    private final String userId;
    private final Friend friend;

    public User(String userId) {
        this.userId = userId;
        this.friend = new Friend();
    }

    public void addFriend(User otherUser) {
        this.friend.add(otherUser.userId);
    }

    public boolean isFriend(User otherUser) {
        return this.friend.hasFriend(otherUser.userId);
    }

    public void deleteFriendIds(List<String> userIds) {
        friend.deleteFriendToList(userIds);
    }

    public boolean isNotFriend(String friendId) {
        return friend.hasNotFriend(friendId);
    }

    public int commonFriendCount(User otherUser) {
        return friend.commonFriendCount(otherUser.friend);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
