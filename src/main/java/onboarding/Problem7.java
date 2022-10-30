package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        ArrayList<String> userFreinds = new ArrayList<>();
        for (List<String> pair : friends) {
            if (isUserFreind(user, pair)) {
                userFreinds.add(getUserFreind(user, pair));
            }
        }



        return answer;
    }
    public static boolean isUserFreind(String user, List<String> pair) {
        for (String id : pair) {
            if (id == user) {
                return true;
            }
        }
        return false;
    }
    public static String getUserFreind(String user, List<String> pair) {
        return pair.get(0) == user ? pair.get(1) : pair.get(0);
    }
}
