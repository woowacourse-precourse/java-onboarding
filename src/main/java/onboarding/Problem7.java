package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static final int USER_MIN = 1;
    private static final int USER_MAX = 30;
    private static final int FRIENDS_ID_MIN = 1;
    private static final int FRIENDS_ID_MAX = 30;
    private static final int FRIENDS_MIN = 1;
    private static final int FRIENDS_MAX = 10000;
    private static final int VISITOR_MIN = 0;
    private static final int VISITOR_MAX = 10000;
    private static final Map<String, Integer> scoreForUser = new HashMap<>();
    private static final Set<String> userFriends = new HashSet<>();



    public static void setFriendsOfUserFriends(List<List<String>> friends, String user) {
        for (List<String> friend : friends) {
            if (isFriendsOfUser(friend, user)) {
                userFriends.addAll(friend);
            }
        }
    }

    public static boolean isFriendsOfUser(List<String> friends, String user) {
        return friends.contains(user);
    }


}
