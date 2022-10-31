package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static final int FRIEND_POINT = 10;
    private static final int VISITOR_POINT = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> myFriendsList = myFriends(user, friends);
        HashMap<String, Integer> score = new HashMap<>();

        for (String myFriend : myFriendsList) {
            for (String recomendedFriends : myFriends(myFriend, friends)) {
                if (!recomendedFriends.equals(user)) {
                    addRecomendedScore(score, recomendedFriends);
                }
            }
        }

        for (String visitor : visitors) {
            if (!myFriendsList.contains(visitor)) {
                addVisitorScore(score, visitor);
            }
        }

        return score.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.<String, Integer>comparingByValue())
                        .thenComparing(Map.Entry.comparingByKey()))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
    }

    private static void addRecomendedScore(HashMap<String, Integer> recomendedFriend, String id) {
        if (recomendedFriend.containsKey(id)) {
            recomendedFriend.put(id, recomendedFriend.get(id) + FRIEND_POINT);
        } else {
            recomendedFriend.put(id, FRIEND_POINT);
        }
    }

    private static void addVisitorScore(HashMap<String, Integer> recomendedFriend, String id) {
        if (recomendedFriend.containsKey(id)) {
            recomendedFriend.put(id, recomendedFriend.get(id) + VISITOR_POINT);
        } else {
            recomendedFriend.put(id, VISITOR_POINT);
        }
    }

    private static List<String> myFriends(String user, List<List<String>> friends) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            String idA = friends.get(i).get(0);
            String idB = friends.get(i).get(1);
            if (user.equals(idA)) {
                list.add(idB);
            }
            if (user.equals(idB)) {
                list.add(idA);
            }
        }
        return list;
    }
}
