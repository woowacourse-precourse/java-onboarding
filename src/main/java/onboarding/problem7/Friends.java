package onboarding.problem7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Friends {
    private final Set<User> friends;

    public Friends() {
        this.friends = new HashSet<>();
    }

    public Friends(User user) {
        this.friends = new HashSet<>(Set.of(user));
    }

    public void add(User user) {
        friends.add(user);
    }

    public List<User> toList() {
        return new ArrayList<>(friends);
    }

    public boolean isNotFriend(User user) {
        return !friends.contains(user);
    }

}
