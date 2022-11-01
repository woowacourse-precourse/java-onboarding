package onboarding;

import java.util.ArrayList;
import java.util.List;

public class FriendsWithFriendsList {
    private final List<String> friendsOfFriendsList;

    public FriendsWithFriendsList(UserWithFriendsList userFriendsList, List<List<String>> friendsList) {
        this.friendsOfFriendsList = getFriendsOfFriendsList(userFriendsList, friendsList);
    }

    public List<String> getFriendsOfFriendsList() {
        return friendsOfFriendsList;
    }

    public List<String> getFriendsOfFriendsList(UserWithFriendsList userFriendsList, List<List<String>> friendsList) {
        List<String> friendsOfFriendsList = new ArrayList<>();
        friendsList.stream()
                .forEach(friends -> {
                    if (userFriendsList.findOnlyFriendAndNotUser(friends)) {
                        friendsOfFriendsList.add(friends.get(1));
                    }
                });
        System.out.println(friendsOfFriendsList);
        return friendsOfFriendsList;
    }
}
