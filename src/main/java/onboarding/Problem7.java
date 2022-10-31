package onboarding;


import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
    public static final int MUTUAL_SCORE = 10;

    private static final Set<String> userFriendList = new HashSet<>();
    private static final Map<String, Integer> recommendScore = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        saveUserFriendList(user, friends);
        addMutualFriend(user, friends);
        return Collections.emptyList();
    }

    private static void saveUserFriendList(String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            addFriendToSet(user, friend);
        }
    }

    private static void addFriendToSet(String user, List<String> friend) {
        if (user.equals(friend.get(0))) {
            userFriendList.add(friend.get(1));
        } else if (user.equals(friend.get(1))) {
            userFriendList.add(friend.get(0));
        }
    }

    private static void addMutualFriend(String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            scoreMutualFriend(user, friend);
        }
    }

    private static void scoreMutualFriend(String user, List<String> friend) {
        if (!isNewFriend(user, friend.get(0))) {
            if (isNewFriend(user, friend.get(1))) {
                addRecommendScore(friend.get(1), MUTUAL_SCORE);
            }
        } else if (!isNewFriend(user, friend.get(1))) {
            if (isNewFriend(user, friend.get(0))) {
                addRecommendScore(friend.get(0), MUTUAL_SCORE);
            }
        }
    }

    private static boolean isNewFriend(String user, String friend) {
        return !(userFriendList.contains(friend) || user.equals(friend));
    }

    private static void addRecommendScore(String friend, int x) {
        if (recommendScore.containsKey(friend)) {
            recommendScore.replace(friend, recommendScore.get(friend) + x);
        } else {
            recommendScore.put(friend, x);
        }
    }


}
