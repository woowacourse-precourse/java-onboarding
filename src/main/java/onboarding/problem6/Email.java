package onboarding.problem6;

public class Email {

    private final int MIN_EMAIL_LENGTH = 11;
    private final int MAX_EMAIL_LENGTH = 20;
    private final String DOMAIN = "@email.com";

    private String email;

    public Email(String email) {
        validateEmail(email);
        this.email = email;
    }

    private void validateEmail(String email) {
        if (isOutOfBounds(email)) throw new IllegalArgumentException("Email length is out of bounds");

        if (!isValidDomain(email)) throw new IllegalArgumentException("Invalid email domain");
    }

    private boolean isOutOfBounds(String email) {
        return email.length() < MIN_EMAIL_LENGTH || email.length() > MAX_EMAIL_LENGTH;
    }

    private boolean isValidDomain(String email) {
        return email.endsWith(DOMAIN);
    }

    public String getEmail() {
        return email;
    }
}
