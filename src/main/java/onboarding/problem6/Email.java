package onboarding.problem6;

import java.util.Objects;

public class Email {
	private final String email;

	public Email(String email) {
		EmailRangeValidator emailRangeValidator = new EmailRangeValidator();
		if (!emailRangeValidator.validatorRange(email.length())) {
			throw new IllegalArgumentException("이메일은 전체 길이는 11자 이상 20자 미만이다");
		}
		EmailTypeValidator emailTypeValidator = new EmailTypeValidator();
		if (!emailTypeValidator.validate(email)) {
			throw new IllegalArgumentException("이메일 형식이 부합하지 않습니다 혹은 email.com 도메인을 사용하새요.");
		}
		this.email = email;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Email))
			return false;
		Email email1 = (Email)o;
		return Objects.equals(email, email1.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public String toString() {
		return email;
	}
}
