package onboarding;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem7 {

    private static final int ZERO = 0;
    private static final int FIVE = 5;
    private static final int VISIT_SCORE = 1;
    private static final int ACQUAINTANCE_SCORE = 10;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> userFriends = getUserFriends(user, friends);
        Map<String, Integer> scoreMap = new TreeMap<>();
        getAcquaintanceScore(user, friends, scoreMap, userFriends);
        getVisitorScore(visitors, scoreMap, userFriends);

        return getTopFiveList(user, scoreMap);
    }

    private static List<String> getTopFiveList(String user, Map<String, Integer> scoreMap) {
        return scoreMap
            .entrySet()
            .stream()
            .filter(entry -> !entry.getKey().equals(user))
            .sorted(Problem7::compare)
            .map(Entry::getKey)
            .limit(FIVE).collect(Collectors.toList());
    }

    private static Set<String> getUserFriends(String user, List<List<String>> friends) {
        Set<String> userFriends = new TreeSet<>();
        for (List<String> friend : friends) {
            IntStream.range(0, 2)
                .filter(index -> friend.get(index).equals(user))
                .mapToObj(i -> friend.get(i ^ 1))
                .forEach(userFriends::add);
        }
        return userFriends;
    }

    private static void getAcquaintanceScore(String user, List<List<String>> friends, Map<String, Integer> scoreMap,
        Set<String> userFriends) {
        for (List<String> friend : friends) {
            IntStream.range(0, 2)
                .filter(index -> isAcquaintance(user, userFriends, friend, index))
                .forEach(index ->
                    scoreMap.put(
                        friend.get(index ^ 1),
                        scoreMap.getOrDefault(friend.get(index ^ 1), ZERO) + ACQUAINTANCE_SCORE));
        }
    }

    private static boolean isAcquaintance(String user, Set<String> userFriends, List<String> friend, int i) {
        return userFriends.contains(friend.get(i)) && !friend.get(i).equals(user) && !userFriends.contains(
            friend.get(i ^ 1));
    }

    private static void getVisitorScore(List<String> visitors, Map<String, Integer> scoreMap, Set<String> userFriends) {
        for (String visitor : visitors) {
            if (!userFriends.contains(visitor)) {
                scoreMap.put(visitor, scoreMap.getOrDefault(visitor, ZERO) + VISIT_SCORE);
            }
        }
    }

    private static int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
        return e2.getValue().compareTo(e1.getValue());
    }
}
