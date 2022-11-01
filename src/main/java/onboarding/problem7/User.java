package onboarding.problem7;

import java.util.HashSet;
import java.util.Set;

public class User {

    private final int MIN_ID_LENGTH = 1;
    private final int MAX_ID_LENGTH = 30;

    private String id;
    private Set<User> friends;

    public User(String id) {
        validateId(id);
        this.id = id;
        this.friends = new HashSet<>();
    }

    private void validateId(String id) {
        if (isOutOfBounds(id)) throw new IllegalArgumentException("user id is out of bounds");

        if (!isLowerCase(id)) throw new IllegalArgumentException("user id is not lowercase");
    }

    private boolean isOutOfBounds(String id) {
        return id.length() < MIN_ID_LENGTH || id.length() > MAX_ID_LENGTH;
    }

    private boolean isLowerCase(String id) {
        return id.chars()
                .filter(Character::isUpperCase)
                .findAny()
                .isEmpty();
    }

    public int countCoFriends(User user) {
        int count = 0;

        for (User friend : friends) {
            for (User userFriend : user.friends) {
                if (friend.equals(userFriend)) count++;
            }
        }

        return count;
    }

}