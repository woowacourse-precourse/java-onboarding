package onboarding.problem7;

import java.util.*;
import java.util.stream.Collectors;

public class RecommendFriendFinder {
    private final Map<String, Integer> visitResult = new HashMap<>();
    private final Map<String, Integer> acquaintanceResult = new HashMap<>();
    public Map<String, Integer> getVisitResult(String user, List<List<String>> friends, List<String> visitors) {

        List<String> visitor = removeFriendsToVisit(user, friends, visitors);

        for (String visit : visitor) {
            visitResult.put(visit, getVisitCount(visitor, visit));
        }
        return visitResult;
    }

    private List<String> removeFriendsToVisit(String user, List<List<String>> friends, List<String> visitors) {
        ArrayList<String> visitor = new ArrayList<>(visitors);
        visitor.removeAll(findFriend(user, friends));
        return visitor;
    }

    private static int getVisitCount(List<String> visitor, String visit) {
        return Math.toIntExact((RecommendationScore.VISITOR.getScore() * visitor.stream().filter(s -> s.equals(visit)).count()));
    }

    public Map<String, Integer> getAcquaintanceResult(String user, List<List<String>> friends) {
        for (String acq : findAcquaintance(user, friends)) {
            acquaintanceResult.put(acq, RecommendationScore.ACQUAINTANCE.getScore());
        }
        return acquaintanceResult;
    }

    private List<String> findAcquaintance(String user, List<List<String>> friends) {
        List<String> acquaintance = removeUser(user, friends);
        acquaintance.removeAll(findFriend(user, friends));
        return acquaintance;
    }

    private static List<String> findFriend(String user, List<List<String>> friends) {

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
