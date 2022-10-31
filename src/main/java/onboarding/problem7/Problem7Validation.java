package onboarding.problem7;

import onboarding.validation.MinMaxInputValidatable;
import onboarding.validation.MinMaxListInputValidate;
import onboarding.validation.MinMaxStringInputValidate;

import java.util.List;

public class Problem7Validation {

    private static final int USER_INPUT_MIN = 1;
    private static final int USER_INPUT_MAX = 30;

    private static final int FRIENDS_INPUT_MIN = 1;
    private static final int FRIENDS_INPUT_MAX = 30;

    private static final int FRIENDS_FRIEND_INPUT_LEN = 2;

    private static final int FRIENDS_FRIEND_USER_INPUT_MIN = 1;
    private static final int FRIENDS_FRIEND_USER_INPUT_MAX = 30;

    private static final char LOWER_A = 'a';
    private static final char LOWER_Z = 'z';

    private static final int VISITORS_INPUT_MIN = 0;
    private static final int VISITORS_INPUT_MAX = 10000;

    public static boolean problem7Validation(String user, List<List<String>> friends, List<String> visitors) {
        return userInputValidation(user)
                && friendsInputValidation(friends)
                && visitorsInputValidation(visitors);
    }

    private static boolean userInputValidation(String user) {
        MinMaxInputValidatable minMaxInputValidatable = MinMaxStringInputValidate.getMinMaxStringInputValidate();
        return minMaxInputValidatable.isInputBetweenMinAndMax(user, USER_INPUT_MIN, USER_INPUT_MAX)
                && isUserIdLowerCase(user);
    }

    private static boolean isUserIdLowerCase(String userId) {
        return userId.chars()
                .filter(userIdChar -> LOWER_A <= userIdChar && userIdChar <= LOWER_Z)
                .count() == userId.length();
    }

    private static boolean friendsInputValidation(List<List<String>> friends) {
        MinMaxInputValidatable stringInputValidate = MinMaxStringInputValidate.getMinMaxStringInputValidate();
        MinMaxInputValidatable listInputValidate = MinMaxListInputValidate.getMinMaxListInputValidate();
        return listInputValidate.isInputBetweenMinAndMax(friends, FRIENDS_INPUT_MIN, FRIENDS_INPUT_MAX)
                && (friends.stream()
                    .filter(friendList -> innerFriendsInputValidation(stringInputValidate, listInputValidate, friendList))
                    .count() == friends.size());

    }

    private static boolean innerFriendsInputValidation(MinMaxInputValidatable stringInputValidate, MinMaxInputValidatable listInputValidate, List<String> friendList) {
        return listInputValidate.isInputBetweenMinAndMax(friendList, FRIENDS_FRIEND_INPUT_LEN, FRIENDS_FRIEND_INPUT_LEN)
                && (friendList.stream()
                        .filter(friendId -> stringInputValidate.isInputBetweenMinAndMax(friendId, FRIENDS_FRIEND_USER_INPUT_MIN, FRIENDS_FRIEND_USER_INPUT_MAX)
                            && isUserIdLowerCase(friendId))
                            .count() == FRIENDS_FRIEND_INPUT_LEN);
    }

    private static boolean visitorsInputValidation(List<String> visitors) {
        MinMaxInputValidatable stringInputValidate = MinMaxStringInputValidate.getMinMaxStringInputValidate();
        MinMaxInputValidatable listInputValidate = MinMaxListInputValidate.getMinMaxListInputValidate();
        return listInputValidate.isInputBetweenMinAndMax(visitors,VISITORS_INPUT_MIN, VISITORS_INPUT_MAX)
                && (visitors.stream()
                    .filter(userId -> isUserIdLowerCase(userId))
                    .count() == visitors.size());

    }
}
