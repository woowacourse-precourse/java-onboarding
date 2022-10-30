package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {

    private static boolean checkParam(String user, List<List<String>> friends, List<String> visitors) {
        if (user == null || friends == null || visitors == null) {
            return true;
        } else if (checkUser(user)) {
            return true;
        } else if (checkFriends(friends)) {
            return true;
        } else {
            return checkUserList(visitors);
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
