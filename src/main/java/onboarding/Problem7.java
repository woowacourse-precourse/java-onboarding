package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
    public static final int ACQUAINTANCE_SCORE = 10;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<String> friendsOfUser = findFriendsByUser(user, friends);
        Map<String, Integer> scoreOfAcquaintance = addAcquaintanceScore(friends, friendsOfUser);

        return answer;
    }

    private static Map<String, Integer> addAcquaintanceScore(List<List<String>> friends, List<String> friendsOfUser) {
        Map<String, Integer> numberOfAcquaintance = new HashMap<>();
        for (String friendOfUser : friendsOfUser) {
            List<String> acquaintances = findFriendsByUser(friendOfUser, friends);
            for (String acquaintance : acquaintances) {
                if (numberOfAcquaintance.containsKey(acquaintance)) {
                    numberOfAcquaintance.put(acquaintance, ACQUAINTANCE_SCORE);
                }
                if (!numberOfAcquaintance.containsKey(acquaintance)) {
                    numberOfAcquaintance.put(acquaintance, numberOfAcquaintance.get(acquaintance) + ACQUAINTANCE_SCORE);
                }
            }
        }
        return numberOfAcquaintance;
    }

    private static List<String> findFriendsByUser(String user, List<List<String>> friends) {
        Set<String> friendsOfUser = new HashSet<>();
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                for (String name : friend) {
                    friendsOfUser.add(name);
                }
            }
        }
        friendsOfUser.remove(user);
        return new ArrayList<>(friendsOfUser);
    }
}
