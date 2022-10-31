package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {

    static HashMap<String, Set<String>> friendsMap = new HashMap<>();
    static HashMap<String, Integer> points = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void addFriends(List<String> friend, String user) {
        if (!friend.get(0).equals(user)) points.put(friend.get(0), 0);
        if (!friend.get(1).equals(user)) points.put(friend.get(1), 0);

        if (!friendsMap.containsKey(friend.get(0))) friendsMap.put(friend.get(0), new HashSet<>());
        if (!friendsMap.containsKey(friend.get(1))) friendsMap.put(friend.get(1), new HashSet<>());

        friendsMap.get(friend.get(1)).add(friend.get(0));
        friendsMap.get(friend.get(0)).add(friend.get(1));

        return;
    }

    private static void getFriendsCalc(String user) {
        Set<String> userFriends = friendsMap.get(user);
        Set<String> chainFriends = new HashSet<String>();
        for (String userFriend : userFriends) {
            chainFriends = friendsMap.get(userFriend);
            for (String chainFriend : chainFriends) {
                if (points.containsKey(chainFriend)) points.put(chainFriend, points.get(chainFriend).intValue() + 10);
            }
        }
        return;
    }

    private static void getVisitorsCalc(List<String> visitors, String user) {
        for (String visitor : visitors) {
            if (friendsMap.get(user).contains(visitor)) continue;
            if (!points.containsKey(visitor)) points.put(visitor, 0);
            points.put(visitor, points.get(visitor).intValue() + 1);
        }
        return;
    }

    private static void delFriendsFromPoints(String user) {
        for (String friend : friendsMap.get(user)) {
            points.remove(friend);
        }
        return;
    }
}
