package onboarding.problem1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddEachDigitToSumTest {

	@Test
	void add_each_digit_to_sum() {
		int sum1 = AddEachDigitToSum.calculate(345);
		assertThat(sum1).isEqualTo(12);

		int sum2 = AddEachDigitToSum.calculate(987);
		assertThat(sum2).isEqualTo(24);
	}

}
