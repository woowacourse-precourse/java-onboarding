package onboarding.problem7.validation;

import java.util.List;

public class FriendsValidation {
    private static final int MAX_FRIENDS_SIZE = 10_000;
    private static final int MIM_FRIENDS_SIZE = 1;
    private static final String FRIEND_LENGTH_EXCEPTION_MESSAGE = "friend의 아이디 길이는 1이상 30이하여야 합니다.";
    private static final String FRIENDS_SIZE_EXCEPTION_MESSAGE = "friends의 길이는 길이가 1 이상 10,000 이하여야 합니다.";
    private static final String FRIEND_LOWERCASE_EXCEPTION_MESSAGE = "friend의 아이디 길이는 소문자로 구성되어야 합니다.";

    public static void validate(List<List<String>> friends) {
        validateFriendsSize(friends);
        validateFriendsId(friends);
    }

    private static void validateFriendsSize(List<List<String>> friends) {
        if ((friends.size() < MIM_FRIENDS_SIZE) || (friends.size() > MAX_FRIENDS_SIZE)) {
            throw new IllegalArgumentException(FRIENDS_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private static void validateFriendsId(List<List<String>> friends) {
        for (List<String> friendPair : friends) {
            String user1 = friendPair.get(0);
            String user2 = friendPair.get(1);
            validateFriendId(user1);
            validateFriendId(user2);
        }
    }

    private static void validateFriendId(String friendId) {
        if (!IdValidation.validateIdLengthInRange(friendId)) {
            throw new IllegalArgumentException(FRIEND_LENGTH_EXCEPTION_MESSAGE);
        }
        if (!IdValidation.validateIsLowerCaseId(friendId)) {
            throw new IllegalArgumentException(FRIEND_LOWERCASE_EXCEPTION_MESSAGE);
        }
    }
}
