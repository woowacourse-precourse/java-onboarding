package onboarding.problem6;

import java.util.Objects;

public class Email {
	public static final String EMAIL_RANGE_GUIDE = "이메일은 전체 길이는 11자 이상 20자 미만이다";
	public static final String EMAIL_TYPE_GUIDE = "이메일 형식이 부합하지 않습니다 혹은 email.com 도메인을 사용하새요.";
	private final String email;

	public Email(String email) {
		EmailRangeValidator emailRangeValidator = new EmailRangeValidator();
		if (!emailRangeValidator.validatorRange(email.length())) {
			throw new IllegalArgumentException(EMAIL_RANGE_GUIDE);
		}
		EmailTypeValidator emailTypeValidator = new EmailTypeValidator();
		if (!emailTypeValidator.validate(email)) {
			throw new IllegalArgumentException(EMAIL_TYPE_GUIDE);
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
