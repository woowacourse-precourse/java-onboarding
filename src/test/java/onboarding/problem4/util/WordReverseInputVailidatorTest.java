package onboarding.problem4.util;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WordReverseInputVailidatorTest {

	@Nested
	class Problem4Test {
		@Test
		void 입력된_문자열의_길이_체크() {
			// give
			String wordPassed = "1234567890";
			StringBuilder sbWordFailed = new StringBuilder();
			for (int i = 0; i < 110; i++) {
				sbWordFailed.append(wordPassed);
			}
			String wordFailed = sbWordFailed.toString();
			// when
			boolean resultPassed = true;
			boolean resultFailed = true;
			// then
			assertThat(WordReverseInputVailidator.lengthValidator(wordPassed)).isEqualTo(resultPassed);
			assertThatIllegalArgumentException().isThrownBy(() -> {
				WordReverseInputVailidator.lengthValidator(wordFailed);
			});
		}
	}
}
