package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static List<String> getUserFriends(String user , List<List<String>> friends) {
        return friends.stream()
                      .filter(userAndFriends -> userAndFriends.contains(user))
                      .map(userAndFriends -> getFriends(user, userAndFriends))
                      .collect(Collectors.toList());

    }

    private static String getFriends(String user,List<String> userAndFriends) {
        String result = userAndFriends.get(0);
        if (result.equals(user)) {
            return userAndFriends.get(1);
        }
        return result;
    }

}
