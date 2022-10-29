package onboarding.problem6;

public class Email {
    private final String value;

    public Email(String value) {
        isValidEmail(value);

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private void isValidEmail(String value) {
        if (!value.matches("^[a-z0-9-A-Z]{1,9}+@email.com$")) {
            throw new IllegalArgumentException("Invalid Email value!");
        }
    }
}
