package onboarding.problem6;

public class Nickname {
    private final String value;

    public Nickname(String value) {
        value = isValidName(value);

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private String isValidName(String value) {
        if (!value.matches("^[가-힣+]{1,19}$")) {
            return "Invalid";
        }

        return value;
    }
}
