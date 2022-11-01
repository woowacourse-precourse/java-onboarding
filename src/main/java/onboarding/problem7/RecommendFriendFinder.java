package onboarding.problem7;

import java.util.*;
import java.util.stream.Collectors;

public class RecommendFriendFinder {
    private static final HashMap<String, Integer> acquaintanceResult = new HashMap<>();
    private static final HashMap<String, Integer> visitorResult = new HashMap<>();

    public static List<String> findAcquaintanceAmongVisit(String user, List<List<String>> friends, List<String> visitors) {
        putacqResult(user, friends);

        ArrayList<String> visitor = new ArrayList<>(visitors);
        visitor.removeAll(findFriend(user, friends));
        putVistResult(visitor);
        mergeResult();

        LinkedList<Map.Entry<String, Integer>> list = new LinkedList<>(acquaintanceResult.entrySet());

        list.sort((i1, i2) -> i2.getValue().compareTo(i1.getValue()));

        LinkedHashMap<String, Integer> sorResultMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> kv : list) {
            sorResultMap.put(kv.getKey(), kv.getValue());
        }
        List<String> result = sorResultMap.keySet().stream().limit(5).collect(Collectors.toList());
        return result;
    }

    private static void mergeResult() {
        visitorResult.forEach((key, value) -> acquaintanceResult.merge(key, value, Integer::sum));
    }

    private static void putVistResult(ArrayList<String> visitor) {
        for (String visit : visitor) {
            visitorResult.put(visit, getVisitCount(visitor, visit));
        }
    }

    private static void putacqResult(String user, List<List<String>> friends) {
        for (String acq : findAcquaintance(user, friends)) {
            acquaintanceResult.put(acq, RecommendationScore.ACQUAINTANCE.getScore());
        }
    }

    private static int getVisitCount(ArrayList<String> visitor, String visit) {
        return Math.toIntExact((RecommendationScore.VISITOR.getScore() * visitor.stream().filter(s -> s.equals(visit)).count()));
    }

    public static List<String> findAcquaintance(String user, List<List<String>> friends) {
        List<String> acquaintance = removeUser(user, friends);
        acquaintance.removeAll(findFriend(user, friends));
        return acquaintance;
    }

    public static List<String> findFriend(String user, List<List<String>> friends) {

        return friends.stream()
                .filter(friend -> friend.contains(user))
                .flatMap(Collection::stream)
                .filter(fr -> !fr.equals(user))
                .collect(Collectors.toList());
    }


    private static List<String> removeUser(String user, List<List<String>> friends) {
        return friends.stream()
                .filter(friend -> !friend.contains(user))
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
    }


}
