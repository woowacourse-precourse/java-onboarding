package onboarding.problem7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FriendsRecommendator implements Recommendator{

    public static final int ZERO = 0;
    private final PointCalculator calculator;
    public FriendsRecommendator(PointCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public List<String> recommend(List<String> friendsOfFriends, List<String> friendsOfVisitedRecord, int friendOfFriendPoint, int visitedFriendPoint, int recommendationFriendsLimit) {
        return lineUpUserNewFriends(
            calculator.calculateWithPoint(friendsOfFriends, friendOfFriendPoint),
            calculator.calculateWithPoint(friendsOfVisitedRecord, visitedFriendPoint)).stream()
            .limit(recommendationFriendsLimit)
            .collect(Collectors.toList());
    }

    private List<String> lineUpUserNewFriends(Map<String, Integer> userNewFriendsFromUserFriends,
        Map<String, Integer> userNewFriendsFromVisitRecord) {
        if(userNewFriendsFromUserFriends.isEmpty()) {
            return decideUserNewFriendsFromVisitRecord(userNewFriendsFromVisitRecord);
        }

        combineTwoConditionalNewUserFriends(userNewFriendsFromUserFriends, userNewFriendsFromVisitRecord);

        return decideUserNewFriends(userNewFriendsFromVisitRecord);
    }

    private void combineTwoConditionalNewUserFriends(Map<String, Integer> userNewFriendsFromUserFriends,
        Map<String, Integer> userNewFriendsFromVisitRecord) {
        userNewFriendsFromUserFriends
            .forEach((friend, friendPoint) -> userNewFriendsFromVisitRecord.merge(friend, friendPoint,(friendPoint1,friendPoint2) -> friendPoint1 + friendPoint2));
    }

    private List<String> decideUserNewFriendsFromVisitRecord(Map<String, Integer> userNewFriendsFromVisitRecord) {
        if(userNewFriendsFromVisitRecord.isEmpty()) {
            return new ArrayList<>();
        }

        return decideUserNewFriends(userNewFriendsFromVisitRecord);
    }

    private List<String> decideUserNewFriends(Map<String, Integer> userNewFriendsNameAndPointMap) {
        return userNewFriendsNameAndPointMap.entrySet()
            .stream()
            .filter(isNotZeroPoint())
            .sorted(Comparator.comparingInt(Entry<String, Integer>::getValue)
                .reversed()
                .thenComparing(Entry.comparingByKey()))
            .map(Entry::getKey)
            .collect(Collectors.toList());
    }

    private Predicate<Entry<String, Integer>> isNotZeroPoint() {
        return entry -> entry.getValue() != ZERO;
    }
}
