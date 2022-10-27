package onboarding;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem7 {
    private static final int ID_A = 0;
    private static final int ID_B = 1;
    private static final int FRIEND_OF_FRIEND_SCORE = 10;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void addFriend(Map<String, List<String>> friendMap, Map<String, Integer> friendScoreMap, String friendA, String friendB) {
        if (!friendMap.containsKey(friendA)) {
            List<String> friends = new LinkedList<>();
            friends.add(friendB);

            friendMap.put(friendA, friends);
            friendScoreMap.put(friendA, 0);
        }
        else {
            List<String> friends = friendMap.get(friendA);
            friends.add(friendB);
        }
    }

    private static void makeFriendMap(Map<String, List<String>> friendMap, Map<String, Integer> friendScoreMap, List<List<String>> friends) {
        for(List<String> relation : friends) {
            String friend1 = relation.get(ID_A);
            String friend2 = relation.get(ID_B);

            addFriend(friendMap, friendScoreMap, friend1, friend2);
            addFriend(friendMap, friendScoreMap, friend2, friend1);
        }
    }

    private static void giveScoreByFriend(String user, Map<String, List<String>> friendMap , Map<String, Integer> friendScoreMap) {
        List<String> friendsOfUser = friendMap.get(user);

        for(String friendOfUser : friendsOfUser) {
            List<String> friendsOfFriend = friendMap.get(friendOfUser);

            for(String friend : friendsOfFriend) {
                if (friend.equals(user)) {
                    continue;
                }

                int friendScore = friendScoreMap.get(friend);
                friendScoreMap.put(friend, friendScore + FRIEND_OF_FRIEND_SCORE);
            }
        }
    }
}
