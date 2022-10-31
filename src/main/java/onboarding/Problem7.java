package onboarding;


import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem7 {

    private static final Set<String> userFriendList = new HashSet<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        saveUserFriendList(user, friends);
        return Collections.emptyList();
    }

    private static void saveUserFriendList(String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            addFriendToSet(user, friend);
        }
    }

    private static void addFriendToSet(String user, List<String> friend) {
        if (user.equals(friend.get(0))) {
            userFriendList.add(friend.get(1));
        } else if (user.equals(friend.get(1))) {
            userFriendList.add(friend.get(0));
        }
    }
}
