package onboarding.nicknamevalidator.review;

public class Email {

	private static final int MIN_EMAIL_LENGTH = 11;

	private static final int MAX_EMAIL_LENGTH = 19;

	private static final String VALID_DOMAIN_FORMAT = "email.com";

	private final String email;

	public Email(final String email) {
		validateEmail(email);
		this.email = email;
	}

	private void validateEmail(final String email) {
		if (isOutOfBound(email) || !isValidDomain(email)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean isValidDomain(final String email) {
		return email.endsWith(VALID_DOMAIN_FORMAT);
	}

	private boolean isOutOfBound(final String email) {
		int length = email.length();
		return MIN_EMAIL_LENGTH > length
			|| length > MAX_EMAIL_LENGTH;
	}

	public String getEmail() {
		return email;
	}
}
