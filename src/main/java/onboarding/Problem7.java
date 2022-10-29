package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    static Map<String, List<String>> parseFriends(List<List<String>> friends) {
        Map<String, List<String>> parsedFriends = new HashMap<>();

        friends.forEach(f -> {
            String user1 = f.get(0);
            String user2 = f.get(1);

            if (!parsedFriends.containsKey(user1)) {
                parsedFriends.put(user1, new ArrayList<>());
            }
            List<String> user1Friends = parsedFriends.get(user1);
            user1Friends.add(user2);
            parsedFriends.put(user1, user1Friends);

            if (!parsedFriends.containsKey(user2)) {
                parsedFriends.put(user2, new ArrayList<>());
            }
            List<String> user2Friends = parsedFriends.get(user2);
            user2Friends.add(user1);
            parsedFriends.put(user2, user2Friends);
        });

        return parsedFriends;
    }

}
