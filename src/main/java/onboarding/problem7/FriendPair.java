package onboarding.problem7;

import onboarding.problem7.exception.FriendElementOutOfSizeException;
import onboarding.problem7.exception.IllegalRegexException;
import onboarding.problem7.exception.UserNameLengthNotSatisfiedException;

import java.util.List;

public class FriendPair {

    private static final int MIN_USERNAME_LENGTH = 1;
    private static final int MAX_USERNAME_LENGTH = 30;

    private static final int PAIR_ELEMENT_COUNT = 2;

    private final String user1;
    private final String user2;

    public FriendPair(List<String> userPair) {
        validateElementCount(userPair.size());
        this.user1 = userPair.get(0);
        this.user2 = userPair.get(1);
        validateNameFormat();
    }

    private void validateElementCount(int count) {
        if (count != PAIR_ELEMENT_COUNT) {
            throw new FriendElementOutOfSizeException();
        }
    }

    private void validateNameFormat() {
        validateUserName(user1);
        validateUserName(user2);

    }

    private void validateUserName(String userName) {
        validateNameLength(userName.length());
        validateHasUppercase(userName);
    }

    private void validateNameLength(int nameLength) {
        if (nameLength < MIN_USERNAME_LENGTH || nameLength > MAX_USERNAME_LENGTH) {
            throw new UserNameLengthNotSatisfiedException();
        }
    }

    private void validateHasUppercase(String userName) {
        final String REGEX = "^[a-z]*$";
        if (!userName.matches(REGEX)) {
            throw new IllegalRegexException();
        }
    }

    public String getUser1() {
        return user1;
    }

    public String getUser2() {
        return user2;
    }
}
