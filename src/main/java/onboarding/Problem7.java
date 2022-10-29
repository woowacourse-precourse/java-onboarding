package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, Integer> userList = fillUserList(user, friends, visitors);

        List<String> userFriends = fillUserFriends(user, friends);

        return answer;
    }

    public static List<String> fillUserFriends(String user, List<List<String>> friends) {
        Map<String, List<String>> relationships = makeRelationShips(friends);
        List<String> userFriend = relationships.get(user);
        return userFriend;
    }

    private static Map<String, List<String>> makeRelationShips(List<List<String>> friends) {
        Map<String, List<String>> relationships = new HashMap<>();
        for (List<String> friendRelation : friends) {
            enrichRelation(relationships, friendRelation.get(0), friendRelation.get(1));
            enrichRelation(relationships, friendRelation.get(1), friendRelation.get(0));
        }
        return relationships;
    }

    private static void enrichRelation(Map<String, List<String>> relationships, String f1, String f2) {
        if (isEmptyList(relationships.get(f1), f1)) {
            relationships.put(f1, new ArrayList<>());
        }
        relationships.get(f1).add(f2);
    }

    private static boolean isEmptyList(List<String> list, String key) {
        return list == null;
    }

    public static Map<String, Integer> fillUserList(String user, List<List<String>> friends,
            List<String> visitors) {
        Map<String, Integer> userList = new HashMap<String, Integer>();
        userList.put(user, 0);

        for (List<String> friendRelation : friends) {
            userList.put(friendRelation.get(0), 0);
            userList.put(friendRelation.get(1), 0);
        }

        for (String visitor: visitors) {
            userList.put(visitor, 0);
        }
        return userList;
    }
}
