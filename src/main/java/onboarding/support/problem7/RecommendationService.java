package onboarding.support.problem7;

import java.util.*;
import java.util.stream.Collectors;

public class RecommendationService {

    //함께 아는 친구
    private static final int ACQUAINTANCE_SCORE = 10;
    private static final int TIME_LINE_VISIT_SCORE = 1;
    private final List<String> sortedFriends;
    private final String user;

    public RecommendationService(List<List<String>> friends, String user, List<String> visitors) {
        this.user = user;
        this.sortedFriends = new ArrayList<>();

        Map<String, Set<String>> friendRelationMap = new HashMap<>();
        Map<String, Integer> scoreMap = new HashMap<>();

        for (List<String> friend : friends) {
            makeFriendRelation(friendRelationMap, friend);
        }
        for (Map.Entry<String, Set<String>> friendEntry : friendRelationMap.entrySet()) {
            calculateAcquaintanceScore(friendRelationMap, scoreMap, friendEntry);
        }

    }

    private void calculateAcquaintanceScore(Map<String, Set<String>> friendRelationMap, Map<String, Integer> scoreMap, Map.Entry<String, Set<String>> friendEntry) {
        if (isNotUser(friendEntry.getKey())) {
            for (String relatedFriend : friendEntry.getValue()) {
                if (isUsersFriend(friendRelationMap.get(user), relatedFriend)) {
                    scoreMap.merge(friendEntry.getKey(), ACQUAINTANCE_SCORE, Integer::sum);
                }
            }
        }
    }

    private static void makeFriendRelation(Map<String, Set<String>> friendRelationMap, List<String> friend) {
        String firstFriend = friend.get(0);
        String secondFriend = friend.get(1);

        friendRelationMap.computeIfAbsent(firstFriend, value -> new HashSet<>()).add(secondFriend);
        friendRelationMap.computeIfAbsent(secondFriend, value -> new HashSet<>()).add(firstFriend);
    }

    private boolean isNotUser(String name) {
        return !user.equals(name);
    }

    private boolean isUsersFriend(Set<String> usersFriend, String relatedFriend) {
        return usersFriend.contains(relatedFriend);
    }

    public List<String> getSortedFriends() {
        return sortedFriends;
    }
}
