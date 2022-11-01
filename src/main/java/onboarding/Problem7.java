package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = new ArrayList<>();

        List<String> friendsList = getFriendsList(user, friends);
        Map<String, Integer> friendPointMap = getFriendPoint(user, friendsList, friends, visitors);
        Map<String, Integer> totalPointMap = plusVisitPoint(friendsList, visitors, friendPointMap);
        List<Map.Entry<String, Integer>> sortedFriendsList = sorted(totalPointMap);

        for(Map.Entry<String, Integer> point : sortedFriendsList){
            if(answer.size() > 5) {
                break;
            }
            answer.add(point.getKey());
        }

        return answer;
    }

    private static List<String> getFriendsList(String user, List<List<String>> friends) {

        List<String> friendsList = new ArrayList<>();

        for (List<String> names : friends) {
            if (user.equals(names.get(0))) {
                friendsList.add(names.get(1));
            }
            if (user.equals(names.get(1))) {
                friendsList.add(names.get(0));
            }
        }
        return friendsList;
    }

    private static Map<String, Integer> getFriendPoint(
            String user, List<String> friendsList, List<List<String>> friends, List<String> visitors) {

        Map<String, Integer> pointMap = new HashMap<>();

        for (List<String> friend : friends) {
            String friendName = friend.get(0);
            String friendOfFriend = friend.get(1);
            if (!user.equals(friendOfFriend) && isFriend(friendName, friendsList)) {
                pointMap.put(friendOfFriend, pointMap.getOrDefault(friendOfFriend, 0) + 10);
            }
        }

        return pointMap;
    }

    private static Map<String, Integer> plusVisitPoint(List<String> friendsList, List<String> visitors, Map<String, Integer> friendPointMap) {

        for (String visitor : visitors) {
            if (isFriend(visitor, friendsList)) {
                continue;
            }
            friendPointMap.put(visitor, friendPointMap.getOrDefault(visitor, 0) + 1);
        }
        return friendPointMap;
    }

    private static boolean isFriend(String name, List<String> friendsList) {
        if (friendsList.contains(name)) {
            return true;
        }
        return false;
    }

    private static List<Map.Entry<String, Integer>> sorted(Map<String, Integer> totalPointMap) {
        List<Map.Entry<String, Integer>> sortedFriendsList = new LinkedList<>(totalPointMap.entrySet());
        sortedFriendsList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        return sortedFriendsList;
    }
}