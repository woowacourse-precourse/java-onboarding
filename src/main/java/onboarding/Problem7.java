package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    static final String ERROR = "Error";
    static final int MIN_ID_LENGTH = 1;
    static final int MAX_ID_LENGTH = 30;
    static final int MIN_VISITOR_SIZE = 0;
    static final int MAX_VISITOR_SIZE = 10000;
    static final int MIN_FRIENDS_SIZE = 1;
    static final int MAX_FRIENDS_SIZE = 10000;
    static final int ID_A_INDEX = 0;
    static final int ID_B_INDEX = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        if (!isValidInput(user, friends, visitors)) {
            answer = new ArrayList<>();
            answer.add(ERROR);
            return answer;
        }
        return answer;
    }

    private static boolean isValidInput(String user, List<List<String>> friends, List<String> visitors) {
        if (isValidUserLength(user) && isValidFriendsLength(friends)
             && isValidFriendsIDLength(friends) && isValidVisitorSize(visitors)
             && isValidVisitorIDLength(visitors)) {
            return true;
        }
        return false;
    }

    private static boolean isValidVisitorIDLength(List<String> visitors) {
        for (String visitor : visitors) {
            if (visitor.length() < MIN_ID_LENGTH || visitor.length() > MAX_ID_LENGTH) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidVisitorSize(List<String> visitors) {
        return visitors.size() >= MIN_VISITOR_SIZE && visitors.size() <= MAX_VISITOR_SIZE;
    }

    private static boolean isValidFriendsIDLength(List<List<String>> friends) {
        String IdA;
        String IdB;

        for (List<String> friend : friends) {
            IdA = friend.get(ID_A_INDEX);
            IdB = friend.get(ID_B_INDEX);
            if (IdA.length() < MIN_ID_LENGTH || IdA.length() > MAX_ID_LENGTH) {
                return false;
            }
            if (IdB.length() < MIN_ID_LENGTH || IdB.length() > MAX_ID_LENGTH) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidFriendsLength(List<List<String>> friends) {
        return friends.size() >= MIN_FRIENDS_SIZE && friends.size() <= MAX_FRIENDS_SIZE;
    }

    private static boolean isValidUserLength(String user) {
        return user.length() >= MIN_ID_LENGTH && user.length() <= MAX_ID_LENGTH;
    }
}
