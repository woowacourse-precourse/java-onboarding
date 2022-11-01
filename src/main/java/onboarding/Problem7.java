package onboarding;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static List<String> getUserFriends(String user, List<List<String>> friends) {
        Stream<List<String>> userFriendPairs = friends.stream()
            .filter(friendPair -> friendPair.contains(user));

        Stream<String> userFriends = userFriendPairs
            .flatMap(Collection::stream)
            .filter(userFriend -> !userFriend.equals(user));

        return userFriends
            .collect(Collectors.toList());
    }

    private enum Score {
        ACQUAINTANCE_WITH_USER(10),
        VISIT_TIMELINE(1);

        private final int value;

        Score(int value) {
            this.value = value;
        }
    }
}
