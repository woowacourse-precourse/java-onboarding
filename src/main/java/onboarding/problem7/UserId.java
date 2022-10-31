package onboarding.problem7;

import java.util.regex.Pattern;

public class UserId {
    private final String id;
    private final Pattern smallAlphabet = Pattern.compile("^[a-z]*$");

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
        if (id.length() == 0 || id.length() > 30) {
            throw new IllegalArgumentException();
        }
    }

    private void isSmallAlphabet() {
        if (!smallAlphabet.matcher(id).matches()) {
            throw new IllegalArgumentException();
        }
    }

    public String getId() {
        return id;
    }
}
