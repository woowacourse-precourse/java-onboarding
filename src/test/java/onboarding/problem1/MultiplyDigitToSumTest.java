package onboarding.problem1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MultiplyDigitToSumTest {

	@Test
	void multiply_digit_to_sum() {
		int sum1 = MultiplyDigitToSum.calculate(120);
		assertThat(sum1).isEqualTo(0);

		int sum2 = MultiplyDigitToSum.calculate(236);
		assertThat(sum2).isEqualTo(36);
	}
}
