package onboarding;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> map = new HashMap<>();

        List<String> userFriends = findFriend(user, friends);

        addScore10(map, user, userFriends, friends);
        addScore1(map, visitors, userFriends);

        getTop5(map);
        List<String> answer = new ArrayList<>(getTop5(map).keySet());
        return answer;
    }

    private static HashMap<String, Integer> getTop5 (HashMap<String, Integer> map) {
        //  entrySet로 key, value 가져올 수 있음.
        HashMap<String, Integer> result = map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(5)
                .filter(f -> f.getValue() > 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (k, v) -> k, LinkedHashMap::new));
        return result;
    }

    private static void addScore1 (HashMap<String, Integer> map, List<String> visitors, List<String> userFriends) {
        for(String visitor : visitors) {
            if (map.containsKey(visitor) && !userFriends.contains(visitor)) {
                map.put(visitor, map.get(visitor) + 1);
                continue;
            }
            if (!userFriends.contains(visitor))  map.put(visitor, 1);
        }
    }

    private static void addScore10 (HashMap<String, Integer> map, String user, List<String> userFriends, List<List<String>> friends) {
        for(String friend : userFriends) {
            List<String> scoreFriend = findFriend(friend, friends);
            scoreFriend.remove(user);

            for (String iter : scoreFriend) {
                map.put(iter, 10);
            }
        }
    }

    private static List<String> findFriend (String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();

        for(List<String> friend : friends) {
            int friendIdx = friend.indexOf(user);
            if (friendIdx == 0) {
                friendList.add(friend.get(1));
            } else if (friendIdx == 1) {
                friendList.add(friend.get(0));
            }
        }
        return friendList;
    }
}
