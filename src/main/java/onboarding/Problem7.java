package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, List<String>> relationMap = createRelationMap(getUserFriendList(user, friends), friends);
        return answer;
    }

    public static List<String> getUserFriendList(String user, List<List<String>> friends) {
        return friends.stream()
                      .filter(userAndFriends -> userAndFriends.contains(user))
                      .map(userAndFriend -> getFriend(user, userAndFriend))
                      .collect(Collectors.toList());
    }

    public static Map<String, List<String>> createRelationMap(List<List<String>> friends) {

        Map<String, List<String>> relationMap = new HashMap<>();
        for (List<String> userRelations : friends) {
            String user1 = userRelations.get(0);
            String user2 = userRelations.get(1);
            addRelation(relationMap,user1);
            addRelation(relationMap, user2);
            setRelation(relationMap, user1, user2);
        }
        System.out.println(relationMap);
        return relationMap;
    }

    private static void setRelation(Map<String, List<String>> relationMap, String user1, String user2) {
        relationMap.get(user1)
                   .add(user2);
        relationMap.get(user2)
                   .add(user1);
    }
    private static void addRelation(Map<String, List<String>> relationMap, String user) {
        if (relationMap.containsKey(user)) {
            return;
        }
        relationMap.put(user, new ArrayList<>());
    }

    private static String getFriend(String user, List<String> userAndFriends) {
        return userAndFriends.stream()
                             .filter(friend -> !friend.equals(user))
                             .collect(Collectors.joining());
    }

}
