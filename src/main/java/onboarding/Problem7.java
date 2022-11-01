package onboarding;

import java.util.*;

public class Problem7 {
    public static final int MAX_RECOMMEND_SIZE = 5;
    public static final int FRIEND_IN_COMMON_SCORE = 10;
    public static final int VISITOR_SCORE = 1;

    public static final Comparator<Map.Entry<String, Integer>> byValDesc = Map.Entry.comparingByValue(Comparator.reverseOrder());
    public static final Comparator<Map.Entry<String, Integer>> byKeyAsc = Map.Entry.comparingByKey();
    public static final Comparator<Map.Entry<String, Integer>> sortConditions = byValDesc.thenComparing(byKeyAsc);

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Set<String>> userToFriends = getUserToFriendMap(friends);


        return null;
    }

    public static Map<String, Set<String>> getUserToFriendMap(List<List<String>> friends) {
        Map<String, Set<String>> userToFriends = new HashMap<>();

        for (List<String> relation : friends) {
            addFriend(userToFriends, relation.get(0), relation.get(1));
        }


        return userToFriends;
    }

    public static void addFriend(Map<String, Set<String>> userToFriends, String user1, String user2) {
        userToFriends
                .computeIfAbsent(user1, k -> new HashSet<>())
                .add(user2);

        userToFriends
                .computeIfAbsent(user2, k -> new HashSet<>())
                .add(user1);

    }

    public static Map<String, Integer> getFriendsInCommon(Map<String, Set<String>> userToFriends, String user) {
        Map<String, Integer> friendsInCommon = new HashMap<>();

        for (String id : userToFriends.keySet()) {
            friendsInCommon.put(id, getNumberOfFriendsInCommon(userToFriends, user, id));
        }
        return friendsInCommon;
    }

    public static int getNumberOfFriendsInCommon(Map<String, Set<String>> userToFriends, String user, String other) {
        if (user.equals(other)) {
            return 0;
        }

        int count = 0;

        for (String id : userToFriends.keySet()) {

            if (userToFriends.getOrDefault(user, Set.of()).contains(id) && userToFriends.getOrDefault(other, Set.of()).contains(id)) {
                count += 1;
            }
        }
        return count;
    }

}
