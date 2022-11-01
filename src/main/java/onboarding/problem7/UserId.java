package onboarding.problem7;

import static onboarding.problem7.ConstantsP7.MAX_USER_ID_LENGTH;
import static onboarding.problem7.ConstantsP7.MIN_USER_ID_LENGTH;
import static onboarding.problem7.ConstantsP7.USER_ID_PATTERN;

public class UserId {
    private final String id;

    public UserId(String id) {
        this.id = id;
        isValid();
    }

    private void isValid() {
        isNotNull();
        isValidLength();
        isSmallAlphabet();
    }

    private void isNotNull() {
        if (id == null) {
            throw new IllegalArgumentException();
        }
    }

    private void isValidLength() {
        if (id.length() < MIN_USER_ID_LENGTH || id.length() > MAX_USER_ID_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void isSmallAlphabet() {
        if (!USER_ID_PATTERN.matcher(id).matches()) {
            throw new IllegalArgumentException();
        }
    }

    public String getId() {
        return id;
    }
}
