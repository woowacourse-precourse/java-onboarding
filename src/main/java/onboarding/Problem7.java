package onboarding;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class FriendForPro7 {

    public Set<String> makeFriendSet(List<List<String>> friends, Set<String> friendSet) {
        for (List<String> friend : friends) {
            friendSet.add(friend.get(0));
            friendSet.add(friend.get(1));
        }
        return friendSet;
    }
}

class UserSelectedForPro7 {

    private List<String> userSelectedList;

    public UserSelectedForPro7(String user, List<List<String>> friends, List<String> visitors) {
        ExceptionClassForPro7 exceptionClassForPro7 = new ExceptionClassForPro7(user, friends,
            visitors);
        FriendForPro7 friendClass = new FriendForPro7();
        Set<String> friendSet = friendClass.makeFriendSet(friends, new HashSet<>());
    }
}

class ExceptionClassForPro7 {
    private static final int USER_LENGTH_MIN = 1;
    private static final int USER_LENGTH_MAX = 30;
    private static final int FRIENDS_LENGTH_MIN = 1;
    private static final int FRIENDS_LENGTH_MAX = 10000;
    private static final int FRIENDS_LIST_ARR_LENGTH = 2;
    private static final int FRIENDS_ID_LENGTH_MIN = 1;
    private static final int FRIENDS_ID_LENGTH_MAX = 30;
    private static final int VISITOR_LENGTH_MIN = 0;
    private static final int VISITOR_LENGTH_MAX = 10000;

    public ExceptionClassForPro7(String user, List<List<String>> friends,
        List<String> visitors) {
        validateInfo(user, friends, visitors);
    }

    private void validateInfo(String user, List<List<String>> friends,
        List<String> visitors) {
        validateUser(user);
        validatefriends(friends);
        validateVisitors(visitors);
    }

    private void validateUser(String user) {
        if (user.length() < USER_LENGTH_MIN || USER_LENGTH_MAX < user.length()) {
            throw new IllegalArgumentException(
                "user의 길이는 " + USER_LENGTH_MIN + "이상 " + USER_LENGTH_MAX + "이하의 정수여야 합니다.");
        }
        validateSmallAlpha(user);
    }

    private void validatefriends(List<List<String>> friends) {
        validateFriedsLength(friends);
        validateFriensETC(friends);
    }

    private void validateFriedsLength(List<List<String>> friends) {
        if (friends.size() < FRIENDS_LENGTH_MIN || FRIENDS_LENGTH_MAX < friends.size()) {
            throw new IllegalArgumentException(
                "friends를 담고 있는 리스트/배열의 길이는 " + FRIENDS_LENGTH_MIN + "이상 " + FRIENDS_LENGTH_MAX
                    + "이하의 정수여야 합니다.");
        }
    }

    private void validateFriensETC(List<List<String>> friends) {
        for (List<String> onePair : friends) {
            if (onePair.size() != FRIENDS_LIST_ARR_LENGTH || onePair.contains("")) {
                throw new IllegalArgumentException("friends에 담긴 친구 쌍에 문제가 있습니다.");
            }
            validateNameLength(onePair.get(0));
            validateNameLength(onePair.get(1));
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < FRIENDS_ID_LENGTH_MIN || FRIENDS_ID_LENGTH_MAX < name.length()) {
            throw new IllegalArgumentException(
                "friends에 담긴 이름의 길이는 " + FRIENDS_ID_LENGTH_MIN + "이상 " + FRIENDS_ID_LENGTH_MAX
                    + "이하의 정수여야 합니다.");
        }
        validateSmallAlpha(name);
    }

    private void validateVisitors(List<String> visitors) {
        if (VISITOR_LENGTH_MAX < visitors.size()) {
            throw new IllegalArgumentException(
                "visitors의 길이는 " + VISITOR_LENGTH_MIN + "이상 " + VISITOR_LENGTH_MAX + "이하의 정수여야 합니다.");
        }
        for (String name : visitors) {
            validateSmallAlpha(name);
        }
    }

    private void validateSmallAlpha(String name) {
        if (!name.matches("^[a-z]*$")) {
            throw new IllegalArgumentException("아이디는 알파벳 소문자로만 이루어져야 합니다.");
        }
    }
}

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {
        UserSelectedForPro7 userSelected = new UserSelectedForPro7(user, friends, visitors);

        List<String> answer = Collections.emptyList();
        return answer;
    }
}
