package onboarding.problem3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberRangeValidatorTest {

	@Test
	void number_type_validate() {
		NumberRangeValidator numberRangeValidator = new NumberRangeValidator();
		Assertions.assertThat(numberRangeValidator.validate(10001)).isFalse();
		Assertions.assertThat(numberRangeValidator.validate(0)).isFalse();

		Assertions.assertThat(numberRangeValidator.validate(1)).isTrue();
		Assertions.assertThat(numberRangeValidator.validate(10000)).isTrue();
	}
}
