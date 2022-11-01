package onboarding;

import java.util.*;

public class Problem7 {

    static HashMap<String, Set<String>> friendsMap = new HashMap<>();
    static HashMap<String, Integer> friendPointMap = new HashMap<>();

    private static final int FRIEND_A = 0;
    private static final int FRIEND_B = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        for (List<String> friend : friends) {
            putFriendToMap(friend, user);
        }
        calcFriendPoints(user);
        calcVisitorPoints(visitors, user);
        delDuplicate(user);

        friendPointMap.entrySet().stream().sorted(Map.Entry.comparingByKey());
        friendPointMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry -> {
                    answer.add(entry.getKey());
                });
        return answer;
    }

    private static void putFriendToMap(List<String> friend, String user) {
        if (!friend.get(FRIEND_A).equals(user)){
            friendPointMap.put(friend.get(FRIEND_A), 0);
        }
        if (!friendsMap.containsKey(friend.get(FRIEND_A))) {
            friendsMap.put(friend.get(FRIEND_A), new HashSet<>());
        }
        if (!friend.get(FRIEND_B).equals(user)) {
            friendPointMap.put(friend.get(FRIEND_B), 0);
        }
        if (!friendsMap.containsKey(friend.get(FRIEND_B))) {
            friendsMap.put(friend.get(FRIEND_B), new HashSet<>());
        }

        friendsMap.get(friend.get(FRIEND_B)).add(friend.get(FRIEND_A));
        friendsMap.get(friend.get(FRIEND_A)).add(friend.get(FRIEND_B));
    }

    private static void calcFriendPoints(String user) {
        Set<String> userFriends = friendsMap.get(user);
        for (String userFriend : userFriends) {
            for (String chainFriend : friendsMap.get(userFriend)) {
                if (friendPointMap.containsKey(chainFriend))
                    friendPointMap.put(chainFriend, friendPointMap.get(chainFriend) + 10);
            }
        }
    }

    private static void calcVisitorPoints(List<String> visitors, String user) {
        for (String visitor : visitors) {
            if (friendsMap.get(user).contains(visitor)) continue;
            if (!friendPointMap.containsKey(visitor)) friendPointMap.put(visitor, 0);
            friendPointMap.put(visitor, friendPointMap.get(visitor) + 1);
        }
    }

    private static void delDuplicate(String user) {
        for (String friend : friendsMap.get(user)) {
            friendPointMap.remove(friend);
        }
    }
}