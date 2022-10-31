package onboarding.problem2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CryptogramTypeValidatorTest {

	@Test
	void cryptogram_type_validate() {
		CryptogramTypeValidator cryptogramTypeValidator = new CryptogramTypeValidator();
		assertThat(cryptogramTypeValidator.validate("Abb")).isFalse();
		assertThat(cryptogramTypeValidator.validate("1ab")).isFalse();
		assertThat(cryptogramTypeValidator.validate("*ab")).isFalse();

		assertThat(cryptogramTypeValidator.validate("aabb")).isTrue();
	}
}
