package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        if (isUserException(user) || isFriendsException(friends) || isVisitorsException(visitors)) {
            throw new RuntimeException("올바르지 않은 인자입니다.");
        }

        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static Boolean isUserException(String user) {
        for (int i = 0; i < user.length(); i++) {
            if (user.charAt(i) < 'A' || user.charAt(1) > 'Z') return true;
        }
        return user.length() < 1 || user.length() > 30;
    }

    private static Boolean isFriendsException(List<List<String>> friends) {
        if (friends.size() < 1 || friends.size() > 10000) return true;
        return friends.stream()
                .anyMatch(friend -> (friend.size() != 2)
                        || (friend.stream().anyMatch(f -> (f.length() < 1 || f.length() > 30))));
    }

    private static Boolean isVisitorsException(List<String> visitors) {
        return visitors.size() < 0 || visitors.size() > 10000;
    }
}
