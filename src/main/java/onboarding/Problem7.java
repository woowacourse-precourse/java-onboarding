package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {

    public static final int INITIAL_SCORE = 0;
    public static final int SCORE_MUTUAL_FRIEND = 10;
    public static final int SCORE_VISITOR = 1;
    private static HashMap<String, Integer> score;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = Collections.emptyList();

        score = initializeScore(friends, visitors);

        for(String visitor: visitors) {
            score.put(visitor, score.get(visitor) + SCORE_VISITOR);
        }

        Set<String> directFriendsOfUser = getDirectFriends(user, friends);
        Set<String> mutualFriendsOfUser = getMutualFriends(friends, directFriendsOfUser);

        for(String mutualFriend: mutualFriendsOfUser) {
            score.put(mutualFriend, score.get(mutualFriend) + SCORE_MUTUAL_FRIEND);
        }



        return answer;
    }

    private static HashMap<String, Integer> initializeScore(List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> score = new HashMap<>();
        for (List<String> pairedFriends : friends) {
            for (String friend : pairedFriends) {
                score.put(friend, INITIAL_SCORE);
            }
        }
        for (String visitor : visitors) {
            score.put(visitor, INITIAL_SCORE);
        }
        return score;
    }

    private static Set<String> getMutualFriends(List<List<String>> friends, Set<String> directFriendsOfUser) {
        Set<String> mutualFriendsOfUser = new HashSet<>();
        for (String directFriend : directFriendsOfUser) {
            mutualFriendsOfUser.addAll(getDirectFriends(directFriend, friends));
        }
        return mutualFriendsOfUser;
    }

    private static Set<String> getDirectFriends(String target, List<List<String>> friends) {
        Set<String> directFriends = new HashSet<>();
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
