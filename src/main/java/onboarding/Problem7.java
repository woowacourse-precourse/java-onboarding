package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem7 {
    private static HashSet<String> userFriend;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        userFriend = new HashSet<>();
        userFriend.add(user);

        for (List l : friends) {
            String s1 = (String) l.get(0);
            String s2 = (String) l.get(1);

            addFriendNetwork(user, s1, s2);

        }

        return answer;
    }
}