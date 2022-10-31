package onboarding.problem6;

import java.util.regex.Pattern;

public class Email {

	private static final Pattern EMAIL_COM_DOMAIN_PATTERN = Pattern.compile(".+@email.com");
	private static final Pattern EMAIL_FORMAT_PATTERN = Pattern.compile(".+@.+\\..+");

	private final String email;

	public Email(String email) {
		validateNotNull(email);
		validateLength(email);
		validateFormat(email);
		validateDomain(email);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	private void validateNotNull(String email) {
		if (email == null) {
			throw new IllegalArgumentException("이메일은 null일 수 없습니다");
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

	private void validateFormat(String email) {
		if (!EMAIL_FORMAT_PATTERN.matcher(email).matches()) {
			throw new IllegalArgumentException("이메일의 형식이 잘못되었습니다");
		}
	}

	private void validateDomain(String email) {
		if (!EMAIL_COM_DOMAIN_PATTERN.matcher(email).matches()) {
			throw new IllegalArgumentException("이메일의 형식이 잘못되었습니다");
		}
	}
}
