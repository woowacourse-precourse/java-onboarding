package onboarding.problem6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NicknameKoreanValidatorTest {

	@Test
	void name() {
		NicknameKoreanValidator nicknameKoreanValidator = new NicknameKoreanValidator();
		Assertions.assertThat(nicknameKoreanValidator.validateAllKorean("한글")).isTrue();
		Assertions.assertThat(nicknameKoreanValidator.validateAllKorean("한글a")).isFalse();
	}
}
