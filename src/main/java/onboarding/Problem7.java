package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem7 {

    public static final int USER_FRIEND_FRIEND = 10;
    public static final int USER_TIMELINE_VISITOR = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
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

        for (String visitor : visitors) {
            scoreMap.put(visitor, scoreMap.getOrDefault(visitor, 0) + USER_TIMELINE_VISITOR);
        }

        List<String> answer = scoreMap.keySet()
                                      .stream()
                                      .filter(friend -> isMeOrMyFriend(friend, relationMap, user))
                                      .filter(friend -> scoreMap.get(friend) > 0)
                                      .sorted((friend1, friend2) -> {
                                          if (scoreMap.get(friend1).equals(scoreMap.get(friend2))) {
                                              return friend1.compareTo(friend2);
                                          }

                                          return scoreMap.get(friend2) - scoreMap.get(friend1);
                                      })
                                      .limit(5)
                                      .collect(Collectors.toList());

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

    private static boolean isMeOrMyFriend(String name, Map<String, List<String>> relationMap, String user) {
        if (name.equals(user)) {
            return false;
        }

        for (String userFriend : relationMap.get(user)) {
            if (userFriend.equals(name)) return false;
        }

        return true;
    }
}
