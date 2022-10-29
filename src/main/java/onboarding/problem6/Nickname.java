package onboarding.problem6;

public class Nickname {
    private final String value;

    public Nickname(String value) {
        isValidName(value);

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private void isValidName(String value) {
        if (!value.matches("^[가-힣+]{1,19}$")) {
            throw new IllegalArgumentException("Invalid Nickname Value!");
        }
    }
}
