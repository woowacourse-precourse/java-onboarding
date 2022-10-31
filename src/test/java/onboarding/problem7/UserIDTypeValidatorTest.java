package onboarding.problem7;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UserIDTypeValidatorTest {

	@Test
	void userID_type() {
		UserIDTypeValidator userIDTypeValidator = new UserIDTypeValidator();

		assertThat(userIDTypeValidator.validate("Abc")).isFalse();
		assertThat(userIDTypeValidator.validate("1bc")).isFalse();

		assertThat(userIDTypeValidator.validate("abc")).isTrue();
	}
}
