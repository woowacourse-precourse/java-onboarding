package onboarding.problem2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CryptogramRangeValidatorTest {

	@Test
	void cryptogram_range() {
		CryptogramRangeValidator cryptogramRangeValidator = new CryptogramRangeValidator();
		assertThat(cryptogramRangeValidator.validate(1001)).isFalse();
		assertThat(cryptogramRangeValidator.validate(0)).isFalse();

		assertThat(cryptogramRangeValidator.validate(1)).isTrue();
		assertThat(cryptogramRangeValidator.validate(1000)).isTrue();
	}
}
