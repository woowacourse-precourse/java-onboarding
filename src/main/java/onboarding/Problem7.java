package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendsMap = makeFriendsMap(friends, user);
        Set<String> acquaintance = findAcquaintance(friendsMap, user);
        Map<String, Integer> scoreByFriends = new HashMap<>();

        for(String a : acquaintance) scoreByFriends.put(a, 10);
        for (String visitor : visitors) {
            if(friendsMap.get(user).contains(visitor)) continue;
            scoreByFriends.put(visitor, scoreByFriends.getOrDefault(visitor, 0) + 1);
        }



    }

    private static Set<String> findAcquaintance(Map<String, List<String>> friendsMap, String user) {
        Set<String> tmp = new HashSet<>();
        List<String> friendsOfUser = friendsMap.get(user);

        for (String friend : friendsOfUser) {
            for (String f : friendsMap.get(friend)) {
                if(f.equals(user)) continue;
                tmp.add(f);
            }
        }
        return tmp;
    }
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
