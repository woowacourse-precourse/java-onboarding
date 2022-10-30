package onboarding.problem7.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

    private final String name;

    private final Set<User> friends = new HashSet<>();

    private final List<User> visitors = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public List<User> getVisitors() {
        return visitors;
    }

    public void addFriend(User friend) {
        friends.add(friend);
        if (!friend.isFriends(this)) {
            friend.addFriend(this);
        }
    }

    public boolean isFriends(User user) {
        return friends.contains(user);
    }

    public void addVisitor(User visitor) {
        visitors.add(visitor);
    }
}
