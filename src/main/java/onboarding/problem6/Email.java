package onboarding.problem6;

public class Email {

	private final String email;

	public Email(String email) {
		validateFormat(email);
		this.email = email;
	}

	private void validateFormat(String email) {
		if (!email.matches(".+@.+\\..+")) {
			throw new IllegalArgumentException("이메일의 형식이 잘못되었습니다");
		}
	}
}
