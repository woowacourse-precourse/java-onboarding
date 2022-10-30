package onboarding.problem5;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MoneyRangeValidatorTest {

	@Test
	void money_range() {
		MoneyRangeValidator moneyRangeValidator = new MoneyRangeValidator();
		assertThat(moneyRangeValidator.validate(0)).isFalse();
		assertThat(moneyRangeValidator.validate(1)).isTrue();

		assertThat(moneyRangeValidator.validate(1_000_000)).isTrue();
		assertThat(moneyRangeValidator.validate(1_000_001)).isFalse();
	}
}
