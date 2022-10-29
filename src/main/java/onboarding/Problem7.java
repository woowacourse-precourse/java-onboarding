package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<String> userFriendList = findFriendListByUser(user, friends);

        return answer;
    }

    private static List<String> findFriendListByUser(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();
        for (List<String> friend : friends) {
            if (isUserFriend(user, friend)) {
                String friendName = findFriendByUser(user, friend);
                friendList.add(friendName);
            }
        }
        return friendList;
    }

    private static boolean isUserFriend(String user, List<String> friend) {
        return nameEq(user, friend.get(0)) || nameEq(user, friend.get(1));
    }

    private static String findFriendByUser(String user, List<String> friend) {
        if (nameEq(user, friend.get(0))) {
            return friend.get(1);
        } else {
            return friend.get(0);
        }
    }

    private static boolean nameEq(String user, String target) {
        return user.equals(target);
    }
}
