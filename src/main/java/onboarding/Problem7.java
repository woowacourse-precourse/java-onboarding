package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Set<String> userFriends = new HashSet<>();

        for (List<String> friend : friends) {
            if (friend.get(0) == user) {
                userFriends.add(friend.get(1));
            } else if (friend.get(1) == user) {
                userFriends.add(friend.get(0));
            }
        }
        userFriends.remove(user);

        for (String userFriend : userFriends) {
            for (List<String> friend : friends) {
                String friend1 = friend.get(0);
                String friend2 = friend.get(1);

                if (friend1 == userFriend && friend2 != user && !userFriends.contains(friend2)) {
                    addToMap(map, friend2, 10);
                } else if (friend2 == userFriend && friend1 != user && !userFriends.contains(friend1)) {
                    addToMap(map, friend1, 10);
                }
            }
        }

        for (String visitor : visitors) {
            if (userFriends.contains(visitor))
                continue;
            else
                addToMap(map, visitor, 1);
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : entryList) {
            answer.add(entry.getKey());
            if (answer.size() == 5)
                break;
        }

        return answer;
    }

    public static void addToMap(Map<String, Integer> map, String key, int value) {
        if (map.containsKey(key))
            map.put(key, map.get(key) + value);
        else
            map.put(key, value);
    }
}
