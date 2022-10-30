package onboarding.problem6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmailRangeValidatorTest {

	@Test
	void email_range() {
		EmailRangeValidator emailRangeValidator = new EmailRangeValidator();
		Assertions.assertThat(emailRangeValidator.validatorRange(10)).isFalse();
		Assertions.assertThat(emailRangeValidator.validatorRange(20)).isFalse();

		Assertions.assertThat(emailRangeValidator.validatorRange(11)).isTrue();
		Assertions.assertThat(emailRangeValidator.validatorRange(19)).isTrue();

	}
}
