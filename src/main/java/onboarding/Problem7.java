package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    private static final int MIN_USER_LENGTH = 1;
    private static final int MAX_USER_LENGTH = 30;
    private static final int MIN_FRIENDS_LENGTH = 1;
    private static final int MAX_FRIENDS_LENGTH = 10000;
    private static final int MIN_FRIEND_ID_LENGTH = 1;
    private static final int MAX_FRIEND_ID_LENGTH = 30;
    private static final int MIN_VISITORS_LENGTH = 0;
    private static final int MAX_VISITORS_LENGTH = 10000;
    private static final String LOWERCASE_REG = "^[a-z]*$";
    private static final Map<String, Integer> userAndScoreMap = new HashMap<>();
    private static final Set<String> myFriendsSet = new HashSet<>();
    private static final int ACQUAINTANCE_POINT = 10;
    private static final int VISITOR_POINT = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        checkException(user, friends, visitors);
        friendsSetup(friends, user);
        updateScore(friends, visitors);
        removeUserFriendsAndZeroScore();
        List<String> answer = userAndScoreMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
        return answer;
    }
}