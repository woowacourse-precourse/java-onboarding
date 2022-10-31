package onboarding.problem6;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EmailTest {

	private static final String EMAIL_LENGTH_10 = "12345@7.91";
	private static final String EMAIL_LENGTH_20 = "12345@7.911234512345";
	private static final String EMAIL_VALID = "test@email.com";
	private static final String EMAIL_INVALID = "email@gmail.com";

	@Test
	@DisplayName("이메일은 이메일 형식을 가진다")
	void email_has_format_of_email() {
		assertThatNoException().isThrownBy(() -> new Email(EMAIL_VALID));
		assertThatIllegalArgumentException().isThrownBy(() -> new Email("test@."));
	}

	@Test
	@DisplayName("이메일의 길이를 제한한다")
	void email_is_longer_or_equal_than_11_and_shorter_than_20() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Email(EMAIL_LENGTH_10));
		assertThatIllegalArgumentException().isThrownBy(() -> new Email(EMAIL_LENGTH_20));
	}

	@Test
	@DisplayName("이메일을 특정 도메인에 제한한다")
	void only_specific_domain_is_allowed() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Email(EMAIL_INVALID));
	}
}
