package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Problem7 {

    public static final int INITIAL_SCORE = 0;
    public static final int SCORE_MUTUAL_FRIEND = 10;
    public static final int SCORE_VISITOR = 1;
    private static HashMap<String, Integer> score = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = Collections.emptyList();

        initializeScore(friends, visitors);

        for (String visitor : visitors) {
            score.put(visitor, score.get(visitor) + SCORE_VISITOR);
        }

        List<String> directFriendsOfUser = getDirectFriends(user, friends);
        handleMutualFriends(friends, directFriendsOfUser);

        System.out.println(score);

        return answer;
    }

    private static void initializeScore(List<List<String>> friends, List<String> visitors) {
        for (List<String> pairedFriends : friends) {
            for (String friend : pairedFriends) {
                score.put(friend, INITIAL_SCORE);
            }
        }
        for (String visitor : visitors) {
            score.put(visitor, INITIAL_SCORE);
        }
    }

    private static void handleMutualFriends(List<List<String>> friends, List<String> directFriends) {
        for (String directFriend : directFriends) {
            List<String> mutualFriends = getDirectFriends(directFriend, friends);
            for (String mutualFriend : mutualFriends) {
                score.put(mutualFriend, score.get(mutualFriend) + SCORE_MUTUAL_FRIEND);
            }
        }
    }

    private static List<String> getDirectFriends(String target, List<List<String>> friends) {
        List<String> directFriends = new ArrayList<>();
        for (List<String> friendPair : getFriendPairsWithTarget(target, friends)) {
            for (String directFriend : friendPair) {
                if (!directFriend.equals(target)) {
                    directFriends.add(directFriend);
                }
            }
        }
        return directFriends;
    }

    private static List<List<String>> getFriendPairsWithTarget(String target, List<List<String>> friends) {
        List<List<String>> friendPairs = friends.stream()
                .filter(friendPair -> friendPair.contains(target))
                .collect(Collectors.toList());
        return friendPairs;
    }
}
