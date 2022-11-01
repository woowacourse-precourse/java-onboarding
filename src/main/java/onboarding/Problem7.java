package onboarding;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Map.*;
import static java.util.stream.Collectors.toMap;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Map<String, List<String>> relationMap = createRelationMap(friends);
        Map<String, Integer> pointMap = createPointMap(user, relationMap, visitors);
        System.out.println(pointMap);
        return pointMap.entrySet()
                       .stream()
                       .filter(stringIntegerEntry -> stringIntegerEntry.getValue() != 0)
                       .sorted(Entry.comparingByKey())
                       .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                       .map(Entry::getKey)
                       .collect(Collectors.toList());
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

    public static Map<String, Integer> createPointMap(String user, Map<String, List<String>> relationMap,List<String> visitors) {
        List<String> userFriendList = relationMap.get(user);
        Map<String, Integer> pointMap = relationMap.entrySet()
                                                   .stream()
                                                   .filter(checkUserORUserFriends(user, userFriendList))
                                                   .collect(toMap(Entry::getKey, calcPoint(userFriendList)));
        updateVisitorsPoint(userFriendList,pointMap, visitors);
        return pointMap;
    }

    private static Function<Entry<String, List<String>>, Integer> calcPoint(List<String> userFriendList) {
        return entry -> {
            List<String> relationList = entry.getValue();
            return countMatchesFriend(userFriendList, relationList) * 10;
        };
    }

    private static Predicate<Entry<String, List<String>>> checkUserORUserFriends(String user, List<String> userFriendList) {
        return entry -> !entry.getKey()
                              .equals(user) && !userFriendList.contains(entry.getKey());
    }

    private static void updateVisitorsPoint(List<String> userFriendList, Map<String, Integer> pointMap, List<String> visitors) {

        for (String visitor : visitors) {
            if (userFriendList.contains(visitor)) {
                continue;
            }
            if (pointMap.containsKey(visitor)) {
                Integer point = pointMap.get(visitor);
                pointMap.put(visitor, point + 1);
                continue;
            }
            pointMap.put(visitor, 1);
        }

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
