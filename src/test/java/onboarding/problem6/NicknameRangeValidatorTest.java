package onboarding.problem6;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NicknameRangeValidatorTest {

	@Test
	void nick_range() {
		NicknameRangeValidator nicknameRangeValidator = new NicknameRangeValidator();
		assertThat(nicknameRangeValidator.validateRange(20)).isFalse();
		assertThat(nicknameRangeValidator.validateRange(0)).isFalse();

		assertThat(nicknameRangeValidator.validateRange(19)).isTrue();
		assertThat(nicknameRangeValidator.validateRange(1)).isTrue();
	}
}
