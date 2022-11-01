package onboarding.problem2.util;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CryptogramInputVailidatorTest {
	@Nested
	class Problem2Test {
		@Test
		void 입력된_String_값의_길이_체크() {
			// give
			String cryptogramPass = "browoanoommnaon";
			String cryptogramFail = "1234567890";
			StringBuilder sbCryptogramFail = new StringBuilder("1234567890");
			for (int i = 0; i < 100; i++) sbCryptogramFail.append(cryptogramFail);

			cryptogramFail = sbCryptogramFail.toString();
			// when
			boolean resultPassed = true;
			boolean resultFailed = true;
			// then
			assertThat(CryptogramInputVailidator.lengthValidator(cryptogramPass)).isEqualTo(resultPassed);
			assertThat(CryptogramInputVailidator.lengthValidator(cryptogramFail)).isNotEqualTo(resultFailed);
		}

		@Test
		void 입력된_String_값이_알파벳_소문자로만_이루어져_있는지_체크() {
			// give
			String cryptogramPass = "browoanoommnaon";
			String cryptogramFail = "1234567890ABc";
			String cryptogramFailNumber = "1234567890";
			String cryptogramFailUppercase = "BROWOANOOMMNAON";
			String cryptogramFailKorean = "한글";

			// when
			boolean resultPassed = true;
			boolean resultFailed = true;
			// then
			assertThat(CryptogramInputVailidator.alphabetLowcasePattern(cryptogramPass)).isEqualTo(resultPassed);
			assertThat(CryptogramInputVailidator.alphabetLowcasePattern(cryptogramFail)).isNotEqualTo(resultFailed);
			assertThat(CryptogramInputVailidator.alphabetLowcasePattern(cryptogramFailNumber)).isNotEqualTo(resultFailed);
			assertThat(CryptogramInputVailidator.alphabetLowcasePattern(cryptogramFailUppercase)).isNotEqualTo(resultFailed);
			assertThat(CryptogramInputVailidator.alphabetLowcasePattern(cryptogramFailKorean)).isNotEqualTo(resultFailed);
		}
	}
}
