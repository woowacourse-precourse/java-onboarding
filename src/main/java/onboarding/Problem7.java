package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        scoreBasedOnFriends(friends);
        scoreBasedOnVisitors(visitors);
        List<String> answer = returnAnswer();
        return answer;
    }

    public static void scoreBasedOnFriends(List<List<String>> friends) {

    }

    public static void scoreBasedOnVisitors(List<String> visitors) {

    }

    public static List<String> returnAnswer() {
        return Collections.emptyList();
    }
}
