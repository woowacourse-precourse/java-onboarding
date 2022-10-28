package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    private static void checkUser(String user) {
        if (user.length() > 30 || user.length() < 1)
            throw new IllegalArgumentException("user는 1이상 30이하여야합니다.");
    }

    private static void checkFriends(List<List<String>> friends) {
        if (friends.size() > 10000 || friends.size() < 1)
            throw new IllegalArgumentException("friends는 1이상 10000이하여야합니다.");
    }

    private static void checkVisitors(List<String> visitors) {
        if (visitors.size() > 10000)
            throw new IllegalArgumentException("visitors는 0이상 10000이하여야합니다.");
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
