package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {

    public static final int USER_FRIEND_FRIEND = 10;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, List<String>> relationMap = new HashMap<>();
        Map<String, Integer> scoreMap = new HashMap<>();

        for (List<String> friend : friends) {
            makeFriendRelation(friend, relationMap);
        }

        List<String> userFriends = relationMap.get(user);

        for (String userFriend : userFriends) {

            List<String> userFriendFriends = relationMap.get(userFriend);

            for (String userFriendFriend : userFriendFriends) {
                scoreMap.put(userFriendFriend,
                             scoreMap.getOrDefault(userFriendFriend, 0) + USER_FRIEND_FRIEND);
            }
        }

        return answer;
    }

    private static void makeFriendRelation(List<String> friend, Map<String, List<String>> relationMap) {
        String friend1 = friend.get(0);
        String friend2 = friend.get(1);

        relationMap.computeIfAbsent(friend1, string -> new ArrayList<>());
        relationMap.computeIfAbsent(friend2, string -> new ArrayList<>());

        relationMap.get(friend1).add(friend2);
        relationMap.get(friend2).add(friend1);
    }
}
