package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<String> friendsList = getFriendsList(user, friends);

        return answer;
    }

    private static List<String> getFriendsList(String user, List<List<String>> friends) {

        List<String> friendsList = new ArrayList<>();

        for (List<String> names : friends) {
            if (user.equals(names.get(0))) {
                friendsList.add(names.get(1));
            }
            if (user.equals(names.get(1))) {
                friendsList.add(names.get(0));
            }
        }
        return friendsList;
    }
}