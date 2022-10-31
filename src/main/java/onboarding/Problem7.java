package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        if (!checkValidInput(user, friends, visitors)) {
            return Collections.emptyList();
        }

        return answer;
    }

    private static boolean checkValidInput(String user, List<List<String>> friends, List<String> visitors) {
        if (user.length() < 1 || user.length() > 30) {
            return false;
        }
        if (friends.size() == 0 || friends.size() > 10000) {
            return false;
        }
        if (visitors.size() > 10000) {
            return false;
        }

        return true;
    }
}
