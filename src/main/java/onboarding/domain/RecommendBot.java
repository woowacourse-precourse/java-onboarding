package onboarding.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RecommendBot {
    private final List<String> userFriends;

    public RecommendBot(String user, List<List<String>> friends, List<String> visitors) {
        userFriends = findUserFriends(user, friends);
    }

    private List<String> findUserFriends(String user, List<List<String>> friends) {
        return friends.stream()
                .filter(friend -> friend.contains(user))
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }
}
