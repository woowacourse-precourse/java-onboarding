package onboarding.problem7;

import java.util.*;
import java.util.stream.Collectors;

public class RecommendFriendFinder {
    private final Map<String, Integer> visitResult = new HashMap<>();
    private final Map<String, Integer> acquaintanceResult = new HashMap<>();
    public Map<String, Integer> getVisitResult(SNSId user, List<List<SNSId>> friends, List<SNSId> visitors) {

        List<SNSId> visitor = removeFriendsToVisit(user, friends, visitors);

        for (SNSId visit : visitor) {
            visitResult.put(visit.getUser(), getVisitCount(visitor, visit));
        }
        return visitResult;
    }

    private List<SNSId> removeFriendsToVisit(SNSId user, List<List<SNSId>> friends, List<SNSId> visitors) {
        ArrayList<SNSId> snsIds = new ArrayList<>(visitors);
        snsIds.removeAll(findFriend(user, friends));
        return snsIds;
    }

    private static int getVisitCount(List<SNSId> visitor, SNSId visit) {
        return Math.toIntExact((RecommendationScore.VISITOR.getScore() * visitor.stream().filter(s -> s.equals(visit)).count()));
    }

    public Map<String, Integer> getAcquaintanceResult(SNSId user, List<List<SNSId>> friends) {
        for (SNSId acq : findAcquaintance(user, friends)) {
            acquaintanceResult.put(acq.getUser(), RecommendationScore.ACQUAINTANCE.getScore());
        }
        return acquaintanceResult;
    }

    private List<SNSId> findAcquaintance(SNSId user, List<List<SNSId>> friends) {
        List<SNSId> acquaintance = removeUser(user, friends);
        acquaintance.removeAll(findFriend(user, friends));
        return acquaintance;
    }

    private static List<SNSId> findFriend(SNSId user, List<List<SNSId>> friends) {

        return friends.stream()
                .filter(friend -> friend.contains(user))
                .flatMap(Collection::stream)
                .filter(fr -> !fr.equals(user))
                .collect(Collectors.toList());
    }

    private static List<SNSId> removeUser(SNSId user, List<List<SNSId>> friends) {
        return friends.stream()
                .filter(friend -> !friend.contains(user))
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
    }


}
