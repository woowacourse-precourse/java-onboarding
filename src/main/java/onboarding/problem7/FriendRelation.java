package onboarding.problem7;

import java.util.ArrayList;
import java.util.List;

public class FriendRelation {
    private final List<List<UserId>> friends;

    public FriendRelation(List<List<String>> friends) {
        isValid(friends);
        this.friends = new ArrayList<>();
        friends.forEach(connection -> this.friends.add(connectionToUserIds(connection)));
    }

    private void isValid(List<List<String>> friends) {
        isNotNull(friends);
        isSizeEnough(friends);
        isIdLengthValid(friends);
    }

    private void isNotNull(List<List<String>> friends) {
        if (friends == null) {
            throw new IllegalArgumentException();
        }
    }

    private void isSizeEnough(List<List<String>> friends) {
        if (friends.size() == 0 || friends.size() > 10000) {
            throw new IllegalArgumentException();
        }
    }

    private void isIdLengthValid(List<List<String>> friends) {
        friends.forEach((connection) -> {
            if (connection == null) {
                throw new IllegalArgumentException();
            }
            if (connection.size() != 2) {
                throw new IllegalArgumentException();
            }
        });
    }

    private List<UserId> connectionToUserIds(List<String> connection) {
        return List.of(new UserId(connection.get(0)), new UserId(connection.get(1)));
    }

    public List<List<UserId>> getFriends() {
        return friends;
    }
}
