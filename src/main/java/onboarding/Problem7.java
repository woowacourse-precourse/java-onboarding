package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem7 {
    HashSet<String> set = new HashSet<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        System.out.println(getFriendListOfUser(user, friends));

        return answer;
    }

    private static List<String> getFriendListOfUser(String user, List<List<String>> friends) {
        List<String> result = new ArrayList<>();

        for (List<String> list: friends) {
            if (list.get(0).equals(user)) {
                result.add(list.get(1));
            } else if (list.get(1).equals(user)) {
                result.add(list.get(0));
            }
        }

        return result;
    }
}
