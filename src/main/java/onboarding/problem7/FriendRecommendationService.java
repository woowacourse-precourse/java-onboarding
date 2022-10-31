package onboarding.problem7;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FriendRecommendationService {
    private final String user;
    private final List<List<String>> friends;
    private final List<String> visitors;

    public FriendRecommendationService(String user, List<List<String>> friends, List<String> visitors) {
        this.user = user;
        this.friends = friends;
        this.visitors = visitors;
    }

    public List<String> getRecommendedFriends(int limit) {
        List<String> userFriends = extractUserFriends();
        List<String> recommendedFriends = extractRecommendedFriends(userFriends);
        Map<String, Integer> scoreTable = generateScoreTable(userFriends, recommendedFriends);
        return scoreTable.entrySet()
                .stream()
                .sorted(Comparator.comparingInt((Map.Entry<String, Integer> e) -> -e.getValue())
                        .thenComparing(Map.Entry::getKey))
                .limit(limit)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private Map<String, Integer> generateScoreTable(List<String> userFriend, List<String> recommendedFriends) {
        Map<String, Integer> scoreTable = new HashMap<>();
        recommendedFriends.stream()
                .filter(friend -> !user.equals(friend))
                .forEach(friend -> scoreTable.merge(friend, 10, Integer::sum));
        visitors.stream()
                .filter(visitor -> !userFriend.contains(visitor))
                .forEach(visitor -> scoreTable.merge(visitor, 1, Integer::sum));
        return scoreTable;
    }

    private List<String> extractRecommendedFriends(List<String> userFriends) {
        return friends.stream()
                .map(friend -> {
                    if (userFriends.contains(friend.get(0))) {
                        return friend.get(1);
                    } else if (userFriends.contains(friend.get(1))) {
                        return friend.get(0);
                    }
                    return null;
                }).flatMap(Stream::ofNullable)
                .collect(Collectors.toList());
    }

    private List<String> extractUserFriends() {
        return friends.stream()
                .map(friend -> {
                    if (user.equals(friend.get(0))) {
                        return friend.get(1);
                    } else if (user.equals(friend.get(1))) {
                        return friend.get(0);
                    }
                    return null;
                }).flatMap(Stream::ofNullable)
                .collect(Collectors.toList());
    }
}
