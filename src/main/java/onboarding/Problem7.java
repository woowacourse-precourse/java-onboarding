package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static Set<String> getFriend(String user, List<List<String>> friends){
        Set<String> userFriend = new HashSet<>();

        for (List<String> list : friends){
            String friend1 = list.get(0);
            String friend2 = list.get(1);

            if (user.equals(friend1))
                userFriend.add(friend2);
            else if (user.equals(friend2))
                userFriend.add(friend1);
        }

        return userFriend;
    }
}
