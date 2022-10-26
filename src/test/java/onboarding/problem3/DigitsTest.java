package onboarding.problem3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DigitsTest {


	@Test
	@DisplayName("숫자의 3,6,9 개수를 알 수 있다")
	void disassemble_number_into_digits() {
		Digits digits = new Digits(333);

		Assertions.assertThat(digits.countThreeSixNine()).isEqualTo(3);
	}
}
