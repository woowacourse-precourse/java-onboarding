package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Problem7 {

    static final int VisitPoint = 1;
    static final int FriendPoint = 10;

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, Set<String>> userRelation = new HashMap<>();
        Map<String, Integer> userPoints = new HashMap<>();

        for (List<String> friend : friends) {
            String userA = friend.get(0);
            String userB = friend.get(1);
            if (!userRelation.containsKey(userA)) {
                userRelation.put(userA, new HashSet<>());
            }
            if (!userRelation.containsKey(userB)) {
                userRelation.put(userB, new HashSet<>());
            }
            userRelation.get(userA).add(userB);
            userRelation.get(userB).add(userA);
        }
        Set<String> userFriendList = userRelation.getOrDefault(user, Collections.emptySet());
        if (!userFriendList.isEmpty()) {
            for (String key : userRelation.keySet()) {
                if (key == user || userFriendList.contains(key)) {
                    continue;
                }
                Set<String> friend = userRelation.get(key);
                friend.retainAll(userFriendList);
                if (friend.size() != 0) {
                    userPoints.put(key, FriendPoint * friend.size());
                }

            }
        }
        for (String visitor : visitors) {
            if (userFriendList.contains(visitor)) {
                continue;
            }
            userPoints.put(visitor,
                userPoints.containsKey(visitor) ? userPoints.get(visitor) + VisitPoint
                    : VisitPoint);
        }
        List<Entry<String, Integer>> list_userPoints = sortPoints(userPoints);
        for (int i = 0; i < 5; i++) {
            if (list_userPoints.isEmpty()) {
                break;
            }
            answer.add(list_userPoints.remove(0).getKey());
        }
        return answer;
    }

    public static List<Entry<String, Integer>> sortPoints(Map<String, Integer> userpoint) {
        List<Entry<String, Integer>> userPoints = new ArrayList<Entry<String, Integer>>(userpoint.entrySet());
        Collections.sort(userPoints, (o1, o2) -> {
            if (o1.getValue().compareTo(o2.getValue()) == 0) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue().compareTo(o1.getValue());
        });
        return userPoints;
    }
}
