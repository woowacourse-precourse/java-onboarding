package onboarding.problem2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CryptogramValidatorTest {

	@Test
	void cryptogram_validate() {

		CryptogramValidator cryptogramValidator = new CryptogramValidator();

		assertThat(cryptogramValidator.validate(null)).isFalse();

		assertThat(cryptogramValidator.validate("a".repeat(1001))).isFalse();
		assertThat(cryptogramValidator.validate("")).isFalse();
		assertThat(cryptogramValidator.validate("a")).isTrue();
		assertThat(cryptogramValidator.validate("a".repeat(1000))).isTrue();

		assertThat(cryptogramValidator.validate("Abb")).isFalse();
		assertThat(cryptogramValidator.validate("1ab")).isFalse();
		assertThat(cryptogramValidator.validate("*ab")).isFalse();
		assertThat(cryptogramValidator.validate("aabb")).isTrue();
	}
}
