package onboarding;

import java.util.ArrayList;
import java.util.List;

public class UserWithFriendsList {
    private final String user;
    private final List<String> friendsList;

    public UserWithFriendsList(String user, List<List<String>> friends) {
        this.user = user;
        this.friendsList = getUserFriends(user, friends);
    }

    public List<String> getFriendsList() {
        return friendsList;
    }

    public List<String> getUserFriends(String user, List<List<String>> friends) {
        List<String> friendsList = new ArrayList<>();
        friends
                .forEach(friend -> {
                    findFriends(user, friendsList, friend);
                });
        return friendsList;
    }

    private void findFriends(String user, List<String> friendsList, List<String> friend) {
        if (friend.get(0).equals(user)) {
            friendsList.add(friend.get(1));
        }
        if (friend.get(1).equals(user)) {
            friendsList.add(friend.get(0));
        }
    }

    public boolean findOnlyFriendAndNotUser(List<String> friends) {
        if (friendsList.contains(friends.get(0)) && friends.get(1) == user) {
            return false;
        }
        if (friendsList.contains(friends.get(0))) {
            return true;
        }
        return false;
    }

    public boolean contains(String visitor) {
        return friendsList.stream()
                .anyMatch(friends -> friends.equals(visitor));
    }
}
