package onboarding.problem6;

public class Email {

	private final String email;

	public Email(String email) {
		validateLength(email);
		validateFormat(email);
		this.email = email;
	}

	private void validateFormat(String email) {
		if (!email.matches(".+@.+\\..+")) {
			throw new IllegalArgumentException("이메일의 형식이 잘못되었습니다");
		}
	}

	private void validateLength(String email) {
		if (email.length() < 11) {
			throw new IllegalArgumentException("이메일은 11글자 이상입니다");
		}
		if (email.length() >= 20) {
			throw new IllegalArgumentException("이메일은 20글자 미만입니다");
		}
	}
}
