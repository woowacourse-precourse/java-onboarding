package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    private final static int TIMELINE_VISIT_SCORE = 1;
    private final static int KNOW_TOGETHER_SCORE = 10;

    private static Set<String> userFriends;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        userFriends = createUserFriendsSet(user, friends);

        return answer;
    }

    private static Set<String> createUserFriendsSet(String user, List<List<String>> friends) {
        return friends.stream()
                .filter(pair -> pair.contains(user))
                .flatMap(Collection::stream)
                .collect(Collectors.toCollection(HashSet::new));
    }
}
