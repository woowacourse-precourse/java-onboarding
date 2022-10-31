package onboarding.problem7;

import java.util.*;

public class UserRepository {
    private final Map<String, User> users = new HashMap<>();

    public UserRepository(final String username, final List<List<String>> friends, final List<String> visitors) {
        var targetUser = this.addUser(username);
        friends.forEach(this::addUserAndConnectFriend);
        visitors.forEach(this::addUserAndVisitor);


        targetUser.plusScoreCaseFriendsAFriend();
    }

    public Collection<User> findAll() {
        return this.users.values();
    }

    public User findByName(final String username) {
        return this.users.get(username);
    }

    private User addUser(final String username) {
        if (users.containsKey(username)) {
            return users.get(username);
        }
        User user = new User(username);
        users.put(username, user);
        return user;
    }

    private void addUserAndConnectFriend(final List<String> usernames) {
        var user1 = this.addUser(usernames.get(0));
        var user2 = this.addUser(usernames.get(1));

        user1.addFriend(user2);
    }

    private void addUserAndVisitor(final String username) {
        var user = this.addUser(username);
        user.plusScoreCaseVisitors();
    }
}

