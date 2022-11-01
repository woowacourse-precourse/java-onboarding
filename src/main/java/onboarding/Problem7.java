package onboarding;

import java.util.*;

import static java.util.Map.*;
import static java.util.stream.Collectors.toMap;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, List<String>> relationMap = createRelationMap(friends);
        Map<String, Integer> pointMap = createPointMap(user, relationMap);

        System.out.println(relationMap);
        System.out.println(pointMap);
        return answer;
    }

    public static Map<String, List<String>> createRelationMap(List<List<String>> friends) {

        Map<String, List<String>> relationMap = new HashMap<>();
        for (List<String> userRelations : friends) {
            String user1 = userRelations.get(0);
            String user2 = userRelations.get(1);
            addRelation(relationMap, user1);
            addRelation(relationMap, user2);
            setRelation(relationMap, user1, user2);
        }
        return relationMap;
    }

    public static Map<String, Integer> createPointMap(String user, Map<String, List<String>> relationMap) {
        List<String> userFriendList = relationMap.get(user);
        return relationMap.entrySet()
                          .stream()
                          .filter(entry -> !entry.getKey()
                                                 .equals(user) && !userFriendList.contains(entry.getKey()))
                          .collect(toMap(Entry::getKey, entry -> {
                              List<String> relationList = entry.getValue();
                              return countMatchesFriend(userFriendList, relationList) * 10;
                          }, Integer::sum));
    }

    private static boolean hasAnyUserFriend(List<String> userFriendList, List<String> userRelationList) {
        return userRelationList.stream()
                               .anyMatch(userFriendList::contains);
    }

    private static Integer countMatchesFriend(List<String> userFriendList, List<String> userRelationList) {
        long count = userRelationList.stream()
                                     .filter(userFriendList::contains)
                                     .count();
        return (int) count;
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
}
