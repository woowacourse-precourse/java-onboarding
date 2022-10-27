package onboarding.cryptogram;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CryptogramDecoderTest {

	@DisplayName("암호문 길이 검증")
	@Test
	void 암호문_길이_검증() {
		assertThat(
			CryptogramDecoder.validateLength("")
		).isFalse();

		assertThat(
			CryptogramDecoder.validateLength("0".repeat(1000))
		).isTrue();

		assertThat(
			CryptogramDecoder.validateLength("0".repeat(1001))
		).isFalse();
	}
}
