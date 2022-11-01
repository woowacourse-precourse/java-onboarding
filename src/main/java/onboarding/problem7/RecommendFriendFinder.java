package onboarding.problem7;

import java.util.*;
import java.util.stream.Collectors;

public class RecommendFriendFinder {
    private final Map<String, Integer> visitResult = new HashMap<>();
    private final Map<String, Integer> acquaintanceResult = new HashMap<>();

    public Map<String, Integer> getVisitResult(List<SnsId> friends, List<SnsId> visitors) {

        List<SnsId> visitor = removeFriendsToVisit(friends, visitors);

        for (SnsId visit : visitor) {
            visitResult.put(visit.getUser(), getVisitCount(visitor, visit));
        }
        return visitResult;
    }

    private List<SnsId> removeFriendsToVisit(List<SnsId> friends, List<SnsId> visitors) {
        ArrayList<SnsId> snsIds = new ArrayList<>(visitors);
        snsIds.removeAll(friends);
        return snsIds;
    }

    private static int getVisitCount(List<SnsId> visitor, SnsId visit) {
        return Math.toIntExact((RecommendationScore.VISITOR.getScore() * visitor.stream().filter(s -> s.equals(visit)).count()));
    }

    public Map<String, Integer> getAcquaintanceResult(List<SnsId> acquaintance) {
        for (SnsId acq : acquaintance) {
            acquaintanceResult.put(acq.getUser(), RecommendationScore.ACQUAINTANCE.getScore());
        }
        return acquaintanceResult;
    }

}
