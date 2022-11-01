package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Problem7 {

    private static final int MIN_USER_SIZE = 1;
    private static final int MAX_USER_SIZE = 30;
    private static final int MIN_FRIENDS_SIZE = 1;
    private static final int MAX_FRIENDS_SIZE = 10000;
    private static final int REQULAR_FRIEND_RELATIONSHIP_SIZE = 2;
    private static final int MIN_ID_SIZE = 1;
    private static final int MAX_ID_SIZE = 30;
    private static final String ENGLISH_PATTERN = "^[a-z]*$";
    private static final int MAX_RECOMMENDATION_NUM = 5;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
    private static void validateFriendId(List<List<String>> friends) {
        for (List<String> friend : friends) {
            for (String id : friend) {
                if (!Pattern.matches(ENGLISH_PATTERN, id)) {
                    throw new IllegalArgumentException("아이디는 영소문자로만 이루어져야 합니다");
                }
                if (id.length() < MIN_ID_SIZE || id.length() > MAX_ID_SIZE) {
                    throw new IllegalArgumentException("아이디 길이는 1이상 30 이하여야 합니다");
                }
            }
        }
    }

    private static void validateFriendRelationshipListSize(List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (friend.size() != REQULAR_FRIEND_RELATIONSHIP_SIZE) {
                throw new IllegalArgumentException("친구목록 리스트의 길이는 2여야 합니다");
            }
        }
    }

    private static void validateFriendsSize(List<List<String>> friends) {
        if (friends.size() < MIN_FRIENDS_SIZE || friends.size() > MAX_FRIENDS_SIZE) {
            throw new IllegalArgumentException("친구목록의 길이는 1 이상 10000 이하여야 합니다");
        }
    }

    private static void validateUser(String user) {
        if (user.length() < MIN_USER_SIZE || user.length() > MAX_USER_SIZE) {
            throw new IllegalArgumentException("유저 이름 길이는 1 이상 30 이하여야 합니다");
        }
        if (!Pattern.matches(ENGLISH_PATTERN, user)) {
            throw new IllegalArgumentException("유저이름은 영소문자로만 이루어져야 합니다");
        }
    }
}
