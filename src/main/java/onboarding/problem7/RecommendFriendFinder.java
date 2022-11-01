package onboarding.problem7;

import java.util.*;
import java.util.stream.Collectors;

public class RecommendFriendFinder {
    private final Map<String, Integer> visitResult = new HashMap<>();
    private final Map<String, Integer> acquaintanceResult = new HashMap<>();
    public Map<String, Integer> getVisitResult(SnsId user, List<List<SnsId>> friends, List<SnsId> visitors) {

        List<SnsId> visitor = removeFriendsToVisit(user, friends, visitors);

        for (SnsId visit : visitor) {
            visitResult.put(visit.getUser(), getVisitCount(visitor, visit));
        }
        return visitResult;
    }

    private List<SnsId> removeFriendsToVisit(SnsId user, List<List<SnsId>> friends, List<SnsId> visitors) {
        ArrayList<SnsId> snsIds = new ArrayList<>(visitors);
        snsIds.removeAll(findFriend(user, friends));
        return snsIds;
    }

    private static int getVisitCount(List<SnsId> visitor, SnsId visit) {
        return Math.toIntExact((RecommendationScore.VISITOR.getScore() * visitor.stream().filter(s -> s.equals(visit)).count()));
    }

    public Map<String, Integer> getAcquaintanceResult(SnsId user, List<List<SnsId>> friends) {
        for (SnsId acq : findAcquaintance(user, friends)) {
            acquaintanceResult.put(acq.getUser(), RecommendationScore.ACQUAINTANCE.getScore());
        }
        return acquaintanceResult;
    }

    private List<SnsId> findAcquaintance(SnsId user, List<List<SnsId>> friends) {
        List<SnsId> acquaintance = removeUser(user, friends);
        acquaintance.removeAll(findFriend(user, friends));
        return acquaintance;
    }

    private static List<SnsId> findFriend(SnsId user, List<List<SnsId>> friends) {

        return friends.stream()
                .filter(friend -> friend.contains(user))
                .flatMap(Collection::stream)
                .filter(fr -> !fr.equals(user))
                .collect(Collectors.toList());
    }

    private static List<SnsId> removeUser(SnsId user, List<List<SnsId>> friends) {
        return friends.stream()
                .filter(friend -> !friend.contains(user))
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
    }

}
