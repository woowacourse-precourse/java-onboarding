package onboarding;

import java.util.*;

public class UserFriends {
    private Set<User> userFriends = new HashSet<>();

    public UserFriends(String name){
        userFriends.add(new User(name));
    }

    public void addUserFriend(String user, List<String> friends) {
        int index = friends.indexOf(user);

        if (index >= 0) {
            index = (index + 1) % 2;
            String friendName = friends.get(index);

            userFriends.add(new User(friendName));
        }
    }

    public boolean isUserFriend(User friend){
        return userFriends.contains(friend);
    }

}
