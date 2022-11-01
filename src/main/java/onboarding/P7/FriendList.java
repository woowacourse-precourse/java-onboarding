package onboarding.P7;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FriendList {
    public List<String> getFriendOfFriend(String user, List<List<String>> friends){
        return FriendOfFriend(user, friends, friendsList(user, friends));
    }
    public List<String> friendsList(String user, List<List<String>> friends){
        List<String> userfriend = new ArrayList<>();
        for (List<String> friend : friends) {
            if (Objects.equals(user, friend.get(1))) {
                userfriend.add(friend.get(0));
            }
        }
        return userfriend;
    }

    private static List<String> FriendOfFriend(String user, List<List<String>> friends, List<String> usersfriend){
        List<String> userfriendfriend = new ArrayList<>();
        for (List<String> friend : friends) {
            for (String s : usersfriend) {
                if (Objects.equals(friend.get(0), s) && !Objects.equals(friend.get(1), user)) {
                    userfriendfriend.add(friend.get(1));
                }
            }
        }
        return userfriendfriend;
    }
}
