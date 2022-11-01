package onboarding.problem6;

public class Email {

	private final static int MIN_EMAIL_LENGTH = 11;
	private final static int MAX_EMAIL_LENGTH = 19;
	private final static String DOMAIN = "@email.com";
	private final String emailId;

	public Email(String emailInput) {
		validateEmailInput(emailInput);
		int lastIndex = emailInput.lastIndexOf("@");
		this.emailId = emailInput.substring(0, lastIndex);
	}

	private void validateEmailInput(String emailInput) {
		validateEmailLength(emailInput);
		validateEmailDomain(emailInput);
	}

	private void validateEmailLength(String emailInput) {
		if (emailInput.length() < MIN_EMAIL_LENGTH || emailInput.length() > MAX_EMAIL_LENGTH) {
			throw new IllegalArgumentException("이메일의 길이는 11자 이상 20자 미만이어야 합니다.");
		}
	}

	private void validateEmailDomain(String emailInput) {
		int startIndex = emailInput.lastIndexOf("@");
		if (!emailInput.substring(startIndex).equals(DOMAIN)) {
			throw new IllegalArgumentException("도메인은 email.com으로만 가입 가능합니다.");
		}
	}

	@Override
	public String toString() {
		return emailId + DOMAIN;
	}
}
