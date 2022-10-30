package onboarding.problem6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class KoreanValidatorTest {

	@Test
	void name() {
		KoreanValidator koreanValidator = new KoreanValidator();
		Assertions.assertThat(koreanValidator.validateAllKorean("한글")).isTrue();
		Assertions.assertThat(koreanValidator.validateAllKorean("한글a")).isFalse();
	}
}
