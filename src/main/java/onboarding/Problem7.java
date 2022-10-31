package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static boolean isAlreadyFriend(List<String> userFriends, String friendName) {
        return userFriends.contains(friendName);
    }

    private static void addFriendToList(List<String> userFriends, String friendName) {
        userFriends.add(friendName);
    }
}
