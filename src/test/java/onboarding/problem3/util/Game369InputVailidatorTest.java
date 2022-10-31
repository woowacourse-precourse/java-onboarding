package onboarding.problem3.util;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Game369InputVailidatorTest {
	@Nested
	class Problem3Test {
		@Test
		void 입력_값의_범위_체크() {
			// give
			int numberPassed = 13;
			int numberFail = 123_456;
			// when
			boolean resultPassed = true;
			boolean resultFailed = true;
			// then
			assertThat(Game369InputVailidator.rangeValidator(numberPassed)).isEqualTo(resultPassed);
			assertThat(Game369InputVailidator.rangeValidator(numberFail)).isNotEqualTo(resultFailed);
		}
	}
}
