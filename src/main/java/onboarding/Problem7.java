package onboarding;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        if (!isValidate(user, friends, visitors)) {
            System.out.println("hello");
            return Collections.emptyList();
        }
        List<String> answer = Collections.emptyList();
        return answer;
    }

    /**
     * 제한사항을 검증하는 기능
     */

    private static boolean isValidate(String user, List<List<String>> friends, List<String> visitors) {
        return (validateUser(user) &&
                validateFriends(friends) &&
                validateVisitors(visitors) &&
                isFriendToRecommendExist(user, friends, visitors)
        );
    }

    private static boolean validateUser(String user) {
        return (validateUserLength(user) && validateUserNickname(user));
    }

    private static boolean validateUserLength(String user) {
        return (user != null && user.length() > 0 && user.length() < 31);
    }

    private static boolean validateUserNickname(String user) {
        for (char ch : user.toCharArray()) {
            if (!isLowerAlpha(ch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLowerAlpha(char ch) {
        return (ch >= 'a' && ch <= 'z');
    }

    private static boolean validateFriends(List<List<String>> friends) {
        return (validateFriendsSize(friends.size()) &&
                validateEachFriend(friends) &&
                validateDuplicated(friends));
    }

    private static boolean validateFriendsSize(int size) {
        return (size > 0 && size < 10001);
    }

    private static boolean validateDuplicated(List<List<String>> friends) {
        Set<List<String>> dup = new HashSet<>();
        for (List<String> friend : friends) {
            if (dup.contains(friend)) {
                return false;
            }
            dup.add(friend);
        }
        return true;
    }

    private static boolean validateEachFriend(List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (!validateFriendSize(friend.size())) {
                return false;
            }
            String id1 = friend.get(0);
            String id2 = friend.get(1);
            if (!validateUser(id1) || !validateUser(id2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean validateFriendSize(int size) {
        return (size == 2);
    }

    private static boolean validateVisitors(List<String> visitors) {
        return (validateVisitorsSize(visitors.size()) && validateVisitor(visitors));
    }

    private static boolean validateVisitorsSize(int size) {
        return (size >= 0 && size <= 10000);
    }

    private static boolean validateVisitor(List<String> visitors) {
        for (String visitor : visitors) {
            if (!validateUser(visitor)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isFriendToRecommendExist(String user, List<List<String>> friends, List<String> visitors) {
        for (List<String> friend : friends) {
            if (friend.get(1).equals(user)) {
                return true;
            }
        }
        return visitors.size() != 0;
    }
}
