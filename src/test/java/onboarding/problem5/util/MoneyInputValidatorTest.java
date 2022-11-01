package onboarding.problem5.util;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MoneyInputValidatorTest {
	@Nested
	class Problem5Test {
		@Test
		void 입력된_숫자의_범위_체크() {
			// give
			int moneyPassed = 50237;
			int moneyFailed = 1_000_001;
			// when
			boolean resultPassed = true;
			// then
			assertThat(MoneyInputValidator.rangeValidator(moneyPassed)).isEqualTo(resultPassed);
			assertThatIllegalArgumentException().isThrownBy(() -> {
				MoneyInputValidator.rangeValidator(moneyFailed);
			});
		}
	}
}
