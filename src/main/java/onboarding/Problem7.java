package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        findUserFriends(user, friends);
        return answer;
    }

    private static List<String> findUserFriends(String user, List<List<String>> friends) {

        List<String> userFriends = new ArrayList<>();
        for (List i : friends) { //user의 친구 추가
            if (i.get(0).equals(user)) userFriends.add((String) i.get(1));
            if (i.get(1).equals(user)) userFriends.add((String) i.get(0));
        }
        return userFriends;
    }
}
