package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendsMap = makeFriendsMap(friends, user);
        Map<String, Integer> acquaintance = findAcquaintance(friendsMap, user);
        Map<String, Integer> scoreByFriends = new HashMap<>();

        for(String a : acquaintance.keySet()) scoreByFriends.put(a, 10 * acquaintance.get(a));
        for (String visitor : visitors) {
            if(friendsMap.get(user).contains(visitor)) continue;
            scoreByFriends.put(visitor, scoreByFriends.getOrDefault(visitor, 0) + 1);
        }


        return scoreByFriends.entrySet().stream()
                .sorted(Collections
                        .reverseOrder(Map.Entry.<String, Integer>comparingByValue())
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(5)
                .map(stringIntegerEntry -> stringIntegerEntry.getKey())
                .collect(Collectors.toList());

    }

    private static Map<String, Integer> findAcquaintance(Map<String, List<String>> friendsMap, String user) {
        Map<String, Integer> tmp = new HashMap<>();
        List<String> friendsOfUser = friendsMap.get(user);

        for (String friend : friendsOfUser) {
            for (String f : friendsMap.get(friend)) {
                if(f.equals(user)) continue;
                tmp.put(f, tmp.getOrDefault(tmp, 0) + 1);
            }
        }
        return tmp;
    }

    private static Map<String, List<String>> makeFriendsMap(List<List<String>> friends, String user) {
        Map<String, List<String>> tmp = new HashMap<>();

        for (List<String> friend : friends) {
            tmp.computeIfAbsent(friend.get(0), s -> new ArrayList<>()).add(friend.get(1));
            tmp.computeIfAbsent(friend.get(1), s -> new ArrayList<>()).add(friend.get(0));
        }
        return tmp;
    }
}
