package onboarding.problem6;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EmailTypeValidatorTest {

	@Test
	void email_type_validate() {
		EmailTypeValidator emailTypeValidator = new EmailTypeValidator();
		assertThat(emailTypeValidator.validate("a1234@gmail.com")).isFalse();
		assertThat(emailTypeValidator.validate("a12@34@gmail.com")).isFalse();

		assertThat(emailTypeValidator.validate("a2134@email.com")).isTrue();
	}
}
