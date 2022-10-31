package onboarding.problem7;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UserIDSizeValidatorTest {

	@Test
	void userID_range() {
		UserIDSizeValidator userIDValidator = new UserIDSizeValidator();
		assertThat(userIDValidator.validate(31)).isFalse();
		assertThat(userIDValidator.validate(0)).isFalse();

		assertThat(userIDValidator.validate(30)).isTrue();
		assertThat(userIDValidator.validate(1)).isTrue();
	}
}
